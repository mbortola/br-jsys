<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
	<xsl:output method='xml' indent="yes"/>
	
	<!-- Mi mancano dei valori per esempio perche' manca la radice 00000067 -->
	<xsl:variable name="release" select="distinct-values(//Release/@name)"/>
	<!-- tutte le feature radici -->
	<xsl:variable name="RootFeat" select="/root/Feature/@name"/>
	
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
				<xsl:with-param name="node" select="root/Feature"/>
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
		<!-- lista di feature allo stesso livello -->
		<xsl:param name="node"/>
		<!-- Mi posiziono su una feature in particolare della quale analizzero' i figli-->
		<xsl:for-each select="$node">
			<xsl:element name="Feature">
				<xsl:attribute name="name" select="@name"/>
				<xsl:attribute name="Completi" select="sum(.//Release[@name=$rel]/@completi)"/>
				<xsl:attribute name="Aperti" select="sum(.//Release[@name=$rel]/@aperti)"/>
				<xsl:value-of select="./Childs"/>
				<xsl:call-template name="base">
					<xsl:with-param name="rel" select="$rel"/>
					<xsl:with-param name="node" select="*/Feature"/>
				</xsl:call-template>
			</xsl:element>
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>
