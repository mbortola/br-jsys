<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
	<xsl:template match="/">
		<xsl:for-each select="for $i in (1,2,3) return $i">
			<a>
				<xsl:value-of select="current()"/>
			</a>
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>
