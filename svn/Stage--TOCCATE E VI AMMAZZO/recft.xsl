<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
	<xsl:output method="xml" indent="yes"/>
	<xsl:variable name="ft" select="//RECORD[string(FIELD[@NAME='Codice'])]"/>
	
	<xsl:variable name="distft" select="distinct-values(//FIELD[@NAME='Features'])"/>
	
	<xsl:template match="/">
		<xsl:call-template name="noempty"/>
		<xsl:call-template name="feature"/>
	</xsl:template>
	
	<xsl:template name="noempty">
		
			<root>
				<xsl:for-each select="$ft">
					<Intervento>
						<xsl:element name="Release">
							<xsl:value-of select="FIELD[@NAME='Release']"/>
						</xsl:element>
						<xsl:element name="Feature">
							<xsl:value-of select="FIELD[@NAME='Feature']"/>
						</xsl:element>
						<xsl:element name="Codice">
							<xsl:value-of select="FIELD[@NAME='Codice']"/>
						</xsl:element>
						<xsl:element name="Oggetto">
							<xsl:value-of select="FIELD[@NAME='Oggetto']"/>
						</xsl:element>
						<xsl:element name="Stato">
							<xsl:value-of select="FIELD[@NAME='Stato della lavorazione']"/>
						</xsl:element>
					</Intervento>
				</xsl:for-each>
			</root>
		
	</xsl:template>
	
	<xsl:template name="feature">
		<root>
			<xsl:for-each-group select="//RECORD" group-by="FIELD[@NAME='Feature']">
				<Feature name='{current-grouping-key()}' padre="{current-group()[1]/FIELD[@NAME='Codice padre']}"/>
			</xsl:for-each-group>
		</root>
	</xsl:template>
</xsl:stylesheet>
