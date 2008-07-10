<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
	<xsl:output method="xml" indent="yes"/>

	<!-- lista delle releases -->
	<xsl:variable name="release" select="distinct-values(//FIELD[@NAME='Release'])"/>
	
	<xsl:template match="/">
		<xsl:element name="root">
			<xsl:call-template name="recursive">
				<xsl:with-param name="index" select="1"/>
				<xsl:with-param name="list" select="distinct-values(//RECORD[not(string(FIELD[@NAME='Codice padre']))]/FIELD[@NAME='Feature'])"/>
			</xsl:call-template>
		</xsl:element>
	</xsl:template>
	
	<!-- gestisce tutti gli inteventi inerenti alla release e al padre ricorsivamente -->
	<xsl:template name="recursive">
		<xsl:param name="index"/>
		<xsl:param name="list"/>
		<xsl:variable name="padre" select="$list[$index]"/>
		<xsl:element name="Feature">
			<xsl:attribute name="name" select="$padre"/>
			<xsl:call-template name="IntRelease">
				<xsl:with-param name="index" select="1"/>
				<xsl:with-param name="feature" select="$padre"/>
			</xsl:call-template>
			<xsl:variable name="subFeatures" select="//RECORD[FIELD[@NAME='Codice padre']=$padre]"/>
			<!-- test per vedere se ho sottorecord, evita la ricorsione infinita -->
			<xsl:if test="not(empty($subFeatures))">
				<xsl:element name="Chids">
					<xsl:call-template name="recursive">
						<xsl:with-param name="index" select="1"/>
						<!-- list deve essere la lista delle features con padre $FeatRoot[$index]-->
						<xsl:with-param name="list" select="distinct-values($subFeatures/FIELD[@NAME='Feature'])"/>
					</xsl:call-template>
				</xsl:element>
			</xsl:if>
		</xsl:element>
		<xsl:if test="not(empty($list[$index+1]))">
			<xsl:call-template name="recursive">
				<xsl:with-param name="index" select="$index+1"/>
				<xsl:with-param name="list" select="$list"/>
			</xsl:call-template>
		</xsl:if>
	</xsl:template>
	
	<xsl:template name="IntRelease">
		<!-- index e' l'indice della release e feature l'indice della feature -->
		<xsl:param name="index"/>
		<xsl:param name="feature"/>
		<!-- scorri gli interventi stampandoli per release -->
		<!-- test per vedere se per questa release esistono feature -->
		<xsl:if test="some $i in //RECORD satisfies $i[FIELD[@NAME='Feature']=$feature]/FIELD[@NAME='Release']=$release[$index] ">
			<xsl:variable name="Interventi" select="//RECORD[
				FIELD[@NAME='Feature']=$feature and 
				FIELD[@NAME='Release']=$release[$index] and
				string(FIELD[@NAME='Oggetto'])]"/>
			<xsl:element name="Release">
				<xsl:attribute name="name" select="$release[$index]"/>
				<xsl:attribute name="completi" select="count($Interventi[FIELD[@NAME='Stato della lavorazione']=('CO')])"/>
				<xsl:attribute name="aperti" select="count($Interventi[FIELD[@NAME='Stato della lavorazione']=('NU','IN','WL','LA','TE')])"/>
				
				<!--<xsl:for-each select="$Interventi">
					<xsl:call-template name="printIntervento"/>	
				</xsl:for-each>-->
			</xsl:element>
		</xsl:if>
		<xsl:if test="not(empty($release[$index+1]))">
			<xsl:call-template name="IntRelease">
				<xsl:with-param name="index" select="$index+1"/>
				<xsl:with-param name="feature" select="$feature"/>
			</xsl:call-template>
		</xsl:if>
	</xsl:template>
	
	<!-- stampa gli interventi.....non so se serva -->
	<xsl:template name="printIntervento" match="RECORD">
		<xsl:element name="Intervento">
			<xsl:element name="padre">
				<xsl:value-of select="FIELD[@NAME='Codice padre']"/>
			</xsl:element>
			<xsl:element name="Oggetto">
				<xsl:value-of select="FIELD[@NAME='Oggetto']"/>
			</xsl:element>
			<xsl:element name="Stato">
				<xsl:value-of select="FIELD[@NAME='Stato della lavorazione']"/>
			</xsl:element>
			<xsl:element name="Codice">
				<xsl:value-of select="FIELD[@NAME='Codice']"/>
			</xsl:element>
		</xsl:element>
	</xsl:template>
</xsl:stylesheet>
