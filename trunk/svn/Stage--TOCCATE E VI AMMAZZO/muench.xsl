<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
    <xsl:output method="xml" indent="yes"/>
    
    <xsl:key name="chiave" match="*" use="name(.)"/>
    
    <xsl:template match="/">
        <result>
            <xsl:for-each select="root/*[generate-id(.)=generate-id(key('chiave', name(.))[1])]">
                <xsl:sort data-type="number" select="@value"/>
                <xsl:copy-of select="."/>
            </xsl:for-each>
        </result>
    </xsl:template>
</xsl:stylesheet>
