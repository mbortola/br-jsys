<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
    <xsl:template match="/">
        <xsl:element name="x">
            <xsl:value-of select="sum(//@completi)+sum(//@aperti)"/>
        </xsl:element>
    </xsl:template>
</xsl:stylesheet>
