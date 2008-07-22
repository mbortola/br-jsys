<?xml version="1.0" encoding="UTF-8"?>
<!-- Senza Muenchian Method -->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="xml" indent="yes"/>
    <xsl:template match="/">
        <result>
            <xsl:for-each select="root/item[not(@ord=preceding-sibling::*/@ord)]">
            <xsl:sort select='@ord'  data-type="number"/>
            <xsl:variable name="var" select='@ord'/>
                <element id='{@ord}'>
                	<xsl:value-of select='count(/root/item[@value=$var])'/>
                </element>
            </xsl:for-each>
        </result>
    </xsl:template>   
</xsl:stylesheet>
