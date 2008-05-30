<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
	<xsl:output method="text"/>
	
	<xsl:template match="/">
		<xsl:text>{</xsl:text>
		<xsl:apply-templates select="VZM/*" mode="data"/>
		<xsl:text>}</xsl:text>
	</xsl:template>
	
	<xsl:template match="*" mode="data">
		<xsl:value-of select="name()"/>
		<xsl:text>:</xsl:text>
		<xsl:choose>
			<xsl:when test="@type='JSONObject'">
				<xsl:text>{</xsl:text>
				<xsl:apply-templates select="*" mode="data"/>
				<xsl:text>}</xsl:text>
			</xsl:when>
			<xsl:when test="@type='JSONArray'">
				<xsl:text>[</xsl:text>
				<xsl:apply-templates select="element|JSONObject" mode="array"/>
				<xsl:text>]</xsl:text>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="@value"/>
			</xsl:otherwise>
		</xsl:choose>
		<xsl:text>, </xsl:text>
	</xsl:template>
	
<xsl:template match="*" mode="array">	
		<xsl:choose>
			<xsl:when test="name()='element'">
				<xsl:value-of select="@value"/>
			</xsl:when>
			<xsl:when test="@type='JSONArray'">
				<xsl:text>[</xsl:text>
				<xsl:apply-templates select="element|JSONObject" mode="array"/>
				<xsl:text>]</xsl:text>
			</xsl:when>
			<xsl:otherwise>
				<xsl:text>{</xsl:text>
				<xsl:apply-templates select="*" mode="data"/>
				<xsl:text>}</xsl:text>
			</xsl:otherwise>
		</xsl:choose>
		<xsl:text>, </xsl:text>
	</xsl:template>
</xsl:stylesheet>
