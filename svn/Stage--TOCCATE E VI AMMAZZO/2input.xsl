<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
	<xsl:output method="xml" indent="yes"/>
	
	<!--  <xsl:variable name="interventi" select="doc('noempty.xml')/root/Intervento"/>-->
	
	<xsl:variable name="ftlist" select="doc('featurelist.xml')/root/Feature"/>
	
	<!-- <xsl:variable name="release" select="distinct-values($interventi/Release)"/> -->
	
	
	
	<xsl:template match="/">
		<root>
			<xsl:for-each select="$ftlist[not(string(@padre))]">
				<xsl:call-template name="write">
					<xsl:with-param name="feature" select="@name"/>
				</xsl:call-template>
			</xsl:for-each>		
		</root>
	</xsl:template>
	
	<xsl:template name="write">
		<xsl:param name="feature"/>
		
		<Feature name='{$feature}'>
			<!-- <xsl:call-template name="rel">
				<xsl:for-each select="$release">
				<xsl:with-param name="release" select="."/>
				<xsl:with-param name="feature" select="$feature"/>
				</xsl:for-each>
				</xsl:call-template> -->
			<xsl:variable name="figli" select="$ftlist[@padre=$feature]"/>
			<!-- Childs -->
			<xsl:if test="count($figli)>0">
				<Childs>
					<xsl:for-each select="$figli">
						<xsl:call-template name="write">
							<xsl:with-param name="feature" select="@name"/>
						</xsl:call-template>
					</xsl:for-each>
				</Childs>
			</xsl:if>
		</Feature>
	</xsl:template>
	
	<!--  <xsl:template name="rel">
		<xsl:param name="release"/>
		<xsl:param name="feature"/>
		
		<xsl:variable name="cmp" select="count($interventi[Feature=$feature and Stato='CO' and Release=$release])"/>
		<xsl:variable name="apt" select="count($interventi[Feature=$feature and Stato=('NU','IN','WL','LA','TE') and Release=$release])"/>
		
		<xsl:if test="$cmp+$apt>0">
		<Release name='{$release}' completi='{$cmp}' aperti='{$apt}'/>			
		</xsl:if>
		</xsl:template>-->
	
</xsl:stylesheet>
