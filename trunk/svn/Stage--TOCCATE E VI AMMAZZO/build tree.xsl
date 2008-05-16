<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
	<xsl:output method="xml" indent="yes"/>
	
	<xsl:template match="/">
		<xsl:element name="root">
			<xsl:call-template name="root">
				<xsl:with-param name="index" select="1"/>
				<xsl:with-param name="listR" select="distinct-values(//FIELD[@NAME='Release'])"/>
			</xsl:call-template>
		</xsl:element>
	</xsl:template>
	
	<xsl:template name="root">
		<xsl:param name="index"/>
		<xsl:param name="listR"/>
		<xsl:element name="Release">
			<xsl:attribute name="name" select="$listR[$index]"/>
			<xsl:call-template name="base">
				<!-- nome release -->
				<xsl:with-param name="release" select="$listR[$index]"/>
				<!-- lista features radici -->
				<xsl:with-param name="list" select="distinct-values(//RECORD[FIELD[@NAME='Release']=$listR[$index] 
					and not(string(FIELD[@NAME='padre']))]/FIELD[@NAME='Features di riferimento'])"/>
				<!-- inizializzazione -->
				<xsl:with-param name="index" select="1"/>
			</xsl:call-template>
		</xsl:element>
		<xsl:if test="not(empty($listR[$index+1]))">
			<xsl:call-template name="root">
				<xsl:with-param name="index" select="$index+1"/>
				<xsl:with-param name="listR" select="$listR"/>
			</xsl:call-template>
		</xsl:if>		
	</xsl:template>
	
	<xsl:template name="base">
		<!-- la lista degli id delle feature corrispondenti alla release che non hanno padre -->
		<xsl:param name="release"/>
		<xsl:param name="index"/>
		<!-- list sono tutti gli id delle features senza padre inerenti alla relase $release -->
		<xsl:param name="list"/>
		<xsl:element name="ListaInterventi">
			<xsl:attribute name="FdR" select="$list[$index]"/>
			<xsl:attribute name="Titolo" select="distinct-values(//RECORD[FIELD[@NAME='Features di riferimento']=$list[$index]]/FIELD[@NAME='Titolo'])"/>
			<!-- stampo tutti gli interventi senza padre e relativi alla giusta release-->
			<xsl:for-each select="//RECORD[FIELD[@NAME='Features di riferimento']=$list[$index] and 
				FIELD[@NAME='Release']=$release and not(string(FIELD[@NAME='padre']))]">
				<xsl:call-template name="printIntervento"/>
				<!-- ed eventuali figli -->
			</xsl:for-each>
			<xsl:element name="Childs">
				<xsl:call-template name="recursive">
					<!-- list in questo caso mi dice quali sono i codici che valgono da mettere senza che 
						consideri il padre alle chiamate successive-->
					<xsl:with-param name="list" select="distinct-values(//RECORD[
						FIELD[@NAME='padre']=$list[$index] and 
						FIELD[@NAME='Release']=$release]/FIELD[@NAME='Features di riferimento'])"/>
					<xsl:with-param name="index" select="1"/>
					<xsl:with-param name="Release" select="$release"/>
				</xsl:call-template>
			</xsl:element>
		</xsl:element>
		<xsl:if test="not(empty($list[$index+1]))">
			<xsl:call-template name="base">
				<xsl:with-param name="release" select="$release"/>
				<xsl:with-param name="list" select="$list"/>
				<xsl:with-param name="index" select="$index+1"/>
			</xsl:call-template>
		</xsl:if>
	</xsl:template>
	
	<!-- gestisce tutti gli inteventi inerenti alla release e al padre ricorsivamente -->
	<xsl:template name="recursive">
		<!-- list e' la lista delle feature di riferimento che devo scorrere in quanto figlie della feature chiamante -->
		<xsl:param name="list"/>
		<xsl:param name="index"/>
		<xsl:param name="Release"/>
		<xsl:if test="count($list)>0">
			<xsl:element name="ListaInterventi">
				<xsl:attribute name="FdR" select="$list[$index]"/>
				<xsl:attribute name="Titolo" select="distinct-values(//RECORD[FIELD[@NAME='Features di riferimento']=$list[$index]]/FIELD[@NAME='Titolo'])"/>
				<!-- Qua stampo tutti gli interventi riferite a $list[$index] e della release appropriata  -->
				<xsl:for-each select="//RECORD[FIELD[@NAME='Release']=$Release and 
					FIELD[@NAME='Features di riferimento']=$list[$index]]">
					<xsl:call-template name="printIntervento"/>
				</xsl:for-each>
				<xsl:element name="Childs">
					<xsl:call-template name="recursive">
						<!-- list in questo caso mi dice quali sono i codici che valgono da mettere senza che 
							consideri il padre alle chiamate successive-->
						<xsl:with-param name="list" select="distinct-values(//RECORD[
							FIELD[@NAME='padre']=$list[$index] and 
							FIELD[@NAME='Release']=$Release]/FIELD[@NAME='Features di riferimento'])"/>
						<xsl:with-param name="index" select="1"/>
						<xsl:with-param name="Release" select="$Release"/>
					</xsl:call-template>
				</xsl:element>
			</xsl:element>
			<xsl:if test="not(empty($list[$index+1]))">
				<xsl:call-template name="recursive">
					<xsl:with-param name="Release" select="$Release"/>
					<xsl:with-param name="index" select="$index+1"/>
					<xsl:with-param  name="list" select="$list"/>
				</xsl:call-template>
			</xsl:if>
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
