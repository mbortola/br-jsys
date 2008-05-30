<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
	<xsl:output method="text"/>
	
	<xsl:template match="/">
		<xsl:text>{</xsl:text>
		<xsl:apply-templates select="VZM/*"/>
		<xsl:text>}</xsl:text>
	</xsl:template>
	
	<xsl:template match="*">
		<xsl:value-of select="name()"/>
		<xsl:text>:</xsl:text>
		<xsl:choose>
			<xsl:when test="@type='JSONObject'">
				<xsl:text>{</xsl:text>
				<xsl:apply-templates select="./*"/>
				<xsl:text>}</xsl:text>
			</xsl:when>
			<xsl:when test="@type='JSONArray'">
				<xsl:text>[</xsl:text>
				<xsl:apply-templates select="element|JSONObject"/>
				<xsl:text>]</xsl:text>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="@value"/>
			</xsl:otherwise>
		</xsl:choose>
		<xsl:text>, </xsl:text>
	</xsl:template>
	
	<xsl:template match="element|JSONObject">
		<xsl:choose>
			<xsl:when test="name()='element'">
				<xsl:value-of select="@value"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:text>{</xsl:text>
				<xsl:apply-templates select="./*"/>
				<xsl:text>}</xsl:text>
			</xsl:otherwise>
		</xsl:choose>
		<xsl:text>, </xsl:text>
		
	</xsl:template>
</xsl:stylesheet>
