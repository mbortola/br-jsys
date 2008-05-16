<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
	<xsl:output method="xml" indent="yes"/>
	
	<!-- lista delle radici e lista delle releases -->
	<xsl:variable name="FeatRoot" select="distinct-values(//RECORD[not(string(FIELD[@NAME='padre']))]/FIELD[@NAME='Features di riferimento'])"/>
	<xsl:variable name="release" select="distinct-values(//FIELD[@NAME='Release'])"/>
	
	<xsl:template match="/">
		<xsl:element name="root">
			<xsl:call-template name="root">
				<xsl:with-param name="index" select="1"/>
			</xsl:call-template>
		</xsl:element>
	</xsl:template>
	
	<xsl:template name="root">
		<xsl:param name="index"/>
		<xsl:element name="Feature">
			<xsl:attribute name="name" select="$FeatRoot[$index]"/>
			<!-- stampa interventi per Release -->
			<xsl:call-template name="IntRelease">
				<xsl:with-param name="index" select="1"/>
				<xsl:with-param name="feature" select="$FeatRoot[$index]"/>
			</xsl:call-template>
			<!-- non faccio child se non no almano 1 intervento figlio -->
			<xsl:if test="not(empty(//RECORD[FIELD[@NAME='padre']=$FeatRoot[$index]]))">
				<xsl:element name="Chids">
					<xsl:call-template name="recursive">
						<xsl:with-param name="index" select="1"/>
						<!-- list deve essere la lista delle features con padre $FeatRoot[$index]-->
						<xsl:with-param name="list" select="distinct-values(//RECORD[
							FIELD[@NAME='padre']=$FeatRoot[$index]]/FIELD[@NAME='Features di riferimento'])"/>
					</xsl:call-template>
				</xsl:element>
			</xsl:if>
		</xsl:element>
		<xsl:if test="not(empty($FeatRoot[$index+1]))">
			<xsl:call-template name="root">
				<xsl:with-param name="index" select="$index+1"/>
			</xsl:call-template>
		</xsl:if>
	</xsl:template>
	
	<xsl:template name="IntRelease">
		<!-- index e' l'indice della release e feature l'indice della feature -->
		<xsl:param name="index"/>
		<xsl:param name="feature"/>
		<!-- scorri gli interventi stampandoli per release -->
		<xsl:if test="not(empty((index-of(
			//RECORD[FIELD[@NAME='Features di riferimento']=$feature]/FIELD[@NAME='Release']
			,$release[$index]))))">
			<xsl:element name="Release">
				<xsl:attribute name="name" select="$release[$index]"/>
				<xsl:for-each select="//RECORD[FIELD[@NAME='Features di riferimento']=$feature and FIELD[@NAME='Release']=$release[$index]]">
					<xsl:call-template name="printIntervento"/>	
				</xsl:for-each>
			</xsl:element>
		</xsl:if>
		<xsl:if test="not(empty($release[$index+1]))">
			<xsl:call-template name="IntRelease">
				<xsl:with-param name="index" select="$index+1"/>
				<xsl:with-param name="feature" select="$feature"/>
			</xsl:call-template>
		</xsl:if>
	</xsl:template>
	
	<!-- gestisce tutti gli inteventi inerenti alla release e al padre ricorsivamente -->
	<xsl:template name="recursive">
		<xsl:param name="index"/>
		<xsl:param name="list"/>
		<xsl:element name="Feature">
			<xsl:attribute name="name" select="$list[$index]"/>
			<xsl:call-template name="IntRelease">
				<xsl:with-param name="index" select="1"/>
				<xsl:with-param name="feature" select="$list[$index]"/>
			</xsl:call-template>
			<xsl:if test="not(empty(//RECORD[FIELD[@NAME='padre']=$list[$index]]))">
				<xsl:element name="Chids">
					<xsl:call-template name="recursive">
						<xsl:with-param name="index" select="1"/>
						<!-- list deve essere la lista delle features con padre $FeatRoot[$index]-->
						<xsl:with-param name="list" select="distinct-values(//RECORD[
							FIELD[@NAME='padre']=$list[$index]]/FIELD[@NAME='Features di riferimento'])"/>
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
	
	<xsl:template name="printIntervento" match="RECORD">
		<xsl:element name="Intervento">
			<xsl:element name="padre">
				<xsl:value-of select="FIELD[@NAME='padre']"/>
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
