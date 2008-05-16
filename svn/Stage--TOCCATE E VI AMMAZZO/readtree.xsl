<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0"
	xmlns:f="http://whatever" exclude-result-prefixes="f"
	xmlns:xs="http://www.w3.org/2001/XMLSchema">
	<xsl:output method='xml' indent="yes"/>
	<xsl:variable name="release" select="distinct-values(//Release/@name)"/>
	
	<xsl:template match="/">
		<xsl:element name="result">
			<xsl:call-template name="root">
				<xsl:with-param name="index" select="1"/>
			</xsl:call-template>
		</xsl:element>
	</xsl:template>
	<!-- Una feature e' individuata tramite il nome della release e il suo id.......devo fare una marea di query  
	Ho la lista release
	Creo un elemento per ogni release
	Inizialmente mi procuro la lista delle features di livello 1 e calcolo le complete e le avviate per quel livello e i sottostanti
	poi mi procuro tutti i figli di primo grado per ogni release e faccio di nuovo-->
	
	<!-- itero su ogni release -->
	<xsl:template name="root">
		<xsl:param name="index"/>
		<xsl:element name="Release">
			<xsl:attribute name="name" select="$release[$index]"/>
			<xsl:call-template name="base">
				<xsl:with-param name="rel" select="$release[$index]"/>
			</xsl:call-template>
		</xsl:element>
		<xsl:if test="not(empty($release[$index+1]))">
			<xsl:call-template name="root">
				<xsl:with-param name="index" select="$index+1"/>
			</xsl:call-template>
		</xsl:if>
	</xsl:template>
	
	<!-- Pensavo servissero delle funzioni ed invece basta una semplice query per il conteggio -->
	<xsl:template name="base">
		<xsl:param name="rel"/>
		<xsl:for-each select="/root/Feature">
			<xsl:element name="Feature">
				<xsl:attribute name="name" select="@name"/>
			</xsl:element>
			<xsl:element name="Completi">
				<xsl:value-of select="count(Release[@name=$rel]/Intevento[node()='CO'])+
					count(Childs//Intervento[../Release=$rel and node()='CO'])"/>
			</xsl:element>
			<xsl:element name="Aperti">
				<xsl:value-of select="count(Release[@name=$rel]//Intervento[node()=('NU','IN','WL','LA','TE')])"/>
			</xsl:element>
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>
