<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
	<xsl:output method="xml" indent="yes"/>
	
	<xsl:key name="krel" match="Intervento" use='Release'/>
	
	<xsl:variable name="release" select="/root/Interventi/Intervento[generate-id(.)=
		generate-id(key('krel',Release)[1])]/Release"/>
	
	<xsl:key name="padre" match="Feature" use="@padre"/>
	
	<xsl:key name="interv" match="Intervento" use="concat(generate-id(Feature),generate-id(Release))"/>
	
	<xsl:template match="/">
		<root>
			<xx><xsl:value-of select="$release"/></xx>
			<xsl:apply-templates select="key('padre','')"/>
		</root>
	</xsl:template>
	
	<xsl:template match="Feature">
		<xsl:variable name="name" select="@name"/>
		<!-- Recupero tutti gli interventi per questa feature --><!--raggruppo per release-->
		<Feature name='{@name}'>
			<xsl:for-each select="$release">
				<xsl:variable name="int" select="key('interv',concat(generate-id($name),generate-id(current())))"/>
				<Release name='{current()}'
					completi='{count($int[Stato="CO"])}'
					aperti="{count($int[Stato=('NU','IN','WL','LA','TE')])} "/>				
			</xsl:for-each>
			<Childs>
				<xsl:apply-templates select="key('padre',@name)"/>
			</Childs>
		</Feature>
	</xsl:template>
	
</xsl:stylesheet>