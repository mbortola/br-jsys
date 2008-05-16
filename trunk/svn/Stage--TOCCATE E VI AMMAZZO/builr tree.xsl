<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
	<xsl:output method="xml" indent="yes"/>
	<!--Nome di tutte le release -->
	<xsl:variable name="seq" select="distinct-values(//FIELD[@NAME='Release'])"/>
	
	<xsl:template match="/">
		<xsl:element name="root">
			<xsl:call-template name="root">
				<xsl:with-param name="index" select="1"/>
			</xsl:call-template>
		</xsl:element>
	</xsl:template>
	
	<xsl:template name="root">
		<xsl:param name="index"/>
		<xsl:element name="Release">
			<xsl:attribute name="name" select="$seq[$index]"/>
			<xsl:call-template name="base">
				<!-- nome release -->
				<xsl:with-param name="release" select="$seq[$index]"/>
				<!-- lista features radici -->
				<xsl:with-param name="list" select="distinct-values(//RECORD[FIELD[@NAME='Release']=$seq[$index] 
					and not(string(FIELD[@NAME='padre']))]/FIELD[@NAME='Features di riferimento'])"/>
				<!-- inizializzazione -->
				<xsl:with-param name="index2" select="1"/>
			</xsl:call-template>
		</xsl:element>
		<xsl:if test="not(empty($seq[$index]))">
			<xsl:call-template name="root">
				<xsl:with-param name="index" select="$index+1"/>
			</xsl:call-template>
		</xsl:if>		
	</xsl:template>
	
	<xsl:template name="base">
		<!-- la lista degli id delle feature corrispondenti alla release che non hanno padre -->
		<xsl:param name="release"/>
		<xsl:param name="index2"/>
		<!-- list sono tutti gli id delle features senza padre inerenti alla relase $release -->
		<xsl:param name="list"/>
		<!-- tiro fuori gli id di tutti gli interventi per la release $release  -->
		<xsl:variable name="Codice">
			
		</xsl:variable>
		<xsl:element name="ListaInterventi">
			<!-- stampo tutti gli interventi senza padre e relativi alla giusta release-->
			<xsl:for-each select="//RECORD[FIELD[@NAME='Features di riferimento']=$list[$index2] and 
				FIELD[@NAME='Release']=$release and not(string(FIELD[@NAME='padre']))]">
				<intervento>
					<xsl:call-template name="printIntervento"/>
				</intervento>
				<!-- ed eventuali figli -->
				<childs>
					<xsl:for-each select="//RECORD[FIELD[@NAME='Release']=$release and
						FIELD[@NAME='padre']=$list[$index2]]">
						<xsl:call-template name="recursive">
							<xsl:with-param name="padre" select="$list[$index2]"/>
							<xsl:with-param name="release" select="$release"/>
							<!-- tutti gli id distinti delle features inerenti alla release e al padre -->
							<xsl:with-param name="list" select="distinct-values(//RECORD[
								FIELD[@NAME='padre']=$list[$index2] and 
								FIELD[@NAME='Release']=$release]/FIELD[@NAME='Features di riferimento'])"/>
							<xsl:with-param name="index" select="1"/>
						</xsl:call-template>
					</xsl:for-each>
				</childs>
			</xsl:for-each>
		</xsl:element>
		<xsl:if test="not(empty($list[$index2+1]))">
			<xsl:call-template name="base">
				<xsl:with-param name="release" select="$release"/>
				<xsl:with-param name="list" select="$list"/>
				<xsl:with-param name="index2" select="$index2+1"/>
			</xsl:call-template>
		</xsl:if>
	</xsl:template>
	
	<!-- gestisce tutti gli inteventi inerenti alla release e al padre ricorsivamente -->
	<xsl:template name="recursive">
		<xsl:param name="padre"/>
		<xsl:param name="release"/>
		<!-- list e' la lista delle features figlie di $padre inerenti alla release $release -->
		<xsl:param name="list"/>
		<xsl:param name="index"/>
		<!-- ogni intervento con padre e release appropriata... -->
		<xsl:element name="ListaInterventi">
			<xsl:for-each select="//RECORD[FIELD[@NAME='padre']=$padre and FIELD[@NAME='Release']=$release
				 and FIELD[@NAME='Features di riferimento']=$list[$index]]">
				<xsl:element name="Intervento">
					<xsl:call-template name="printIntervento"/>
				</xsl:element>
				<xsl:element name="Childs">
					<!-- -->
					<xsl:for-each select="">
						
					</xsl:for-each>
				</xsl:element>
			</xsl:for-each>
		</xsl:element>
	</xsl:template>
	
	<xsl:template name="printIntervento" match="RECORD">
		<xsl:element name="Oggetto">
			<xsl:value-of select="FIELD[@NAME='Oggetto']"/>
		</xsl:element>
		<xsl:element name="Stato">
			<xsl:value-of select="FIELD[@NAME='Stato della lavorazione']"/>
		</xsl:element>
		<xsl:element name="Codice">
			<xsl:value-of select="FIELD[@NAME='Codice']"/>
		</xsl:element>
	</xsl:template>
</xsl:stylesheet>
