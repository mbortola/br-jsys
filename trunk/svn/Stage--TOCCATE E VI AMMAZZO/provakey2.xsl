<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
	
	<xsl:output method="xml" indent="yes"/>
	
	<!-- Raggruppo le feature a seconda del loro elemento padre -->
	<xsl:key name="padre" match="Feature" use="@padre"/>
	
	<!-- Raggruppo gli interventi a seconda del loro elemento Feature -->
	<xsl:key name="interv" match="Intervento" use="Feature"/>
	
	<!-- Creo la radice e istanzio gli alberi di features -->
	<xsl:template match="/">
		<root>
			<xsl:apply-templates select="key('padre','')"/>
		</root>
	</xsl:template>
	
	<!-- Ogni feature viene posizionata , nonchè vengono elencati tutti gli interventi  completi e aperti associati a lei-->
	<xsl:template match="Feature">
		<Feature name='{@name}'>
			<!-- Recupero tutti gli interventi per questa feature -->
			<!--raggruppo per release-->
			<xsl:for-each-group select="key('interv', @name)" group-by="Release">
				<Release name='{current-grouping-key()}'
					completi='{count(current-group()[Stato="CO"])}'
					aperti="{count(current-group()[Stato!='CO'])}"/>
			</xsl:for-each-group>
			<Childs>
				<xsl:apply-templates select="key('padre',@name)"/>
			</Childs>
		</Feature>
	</xsl:template>
	
</xsl:stylesheet>
