<?xml version="1.0" encoding="UTF-8"?>
<!-- Per via del distinct-values funziona solo con XSLT 2.0, alternativamente usare Muenchian Method -->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
	<xsl:output method='xml' indent="yes"/>
	
	<xsl:variable name="release" select="distinct-values(//Release/@name)"/>
	
	<xsl:template match="/">
		<root>
			<xsl:call-template name="buildTree">
			<!-- Mi porto dietro l'indirizzo dell'elelemto in release da analizzare e iterativamente lo incremento in modo da 
			scorrere tutte le release-->
				<xsl:with-param name="index" select="1"/>
			</xsl:call-template>
		</root>
	</xsl:template>
	
	
	<!-- Per ogni release costruisco l'albero delle feature con controllo ricorsivo sul numero degli interventi completi e
	aperti. Per ottimizzare viene fatto un controllo che evita di sviluppare sotto alberi nel caso in cui non ci siano interventi 
	o sottointerventi associati-->
	<xsl:template name="buildTree">
		<xsl:param name="index"/>
		<Release name='{$release[$index]}'>
			<xsl:for-each select="root/Feature">
				<xsl:variable name="cmp" select="sum(.//Release[@name=$release[$index]]/@completi)"/>
				<xsl:variable name="apt" select="sum(.//Release[@name=$release[$index]]/@aperti)"/>
				<xsl:if test="$cmp+$apt>0">
					<Feature name='{@name}' completi='{$cmp}' aperti='{$apt}'>
						<xsl:for-each select="Childs/Feature">
							<xsl:call-template name="rec">
								<xsl:with-param name="rel" select="$release[$index]"/>
							</xsl:call-template>     
						</xsl:for-each>	
					</Feature>
				</xsl:if>
			</xsl:for-each>
		</Release>
		<xsl:if test="not(empty($release[$index+1]))">
			<xsl:call-template name="buildTree">
				<xsl:with-param name="index" select="$index+1"/>
			</xsl:call-template>
		</xsl:if>
	</xsl:template>
	
	<!-- Scorre tutte le feature  -->
	<xsl:template name="rec">
		<xsl:param name="rel"/>
		<xsl:variable name="cmp" select="sum(.//Release[@name=$rel]/@completi)"/>
		<xsl:variable name="apt" select="sum(.//Release[@name=$rel]/@aperti)"/>
		<xsl:if test="$apt+$cmp>0">
			<Feature name='{@name}' completi='{$cmp}' aperti='{$apt}'>
				<xsl:for-each select="Childs/Feature">
					<xsl:call-template name="rec">
						<xsl:with-param name="rel" select="$rel"/>
					</xsl:call-template>     
				</xsl:for-each>
			</Feature>
		</xsl:if>
	</xsl:template>
	
</xsl:stylesheet>
