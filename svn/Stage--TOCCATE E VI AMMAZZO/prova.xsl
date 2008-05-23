<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
<xsl:template name="test" match="/">
    <xsl:call-template name="t2">
        <xsl:with-param name="index" select="0"/>
    </xsl:call-template>
</xsl:template>
    
    <xsl:template name="t2">
        <xsl:param name="index"/>
        
        <xsl:variable name="var" select="$index+1"/>
        <xsl:element name="el">
            <xsl:value-of select="$var"/>
            <xsl:call-template name="t2">
                <xsl:with-param name="index" select="$index+1"/>
            </xsl:call-template>
        </xsl:element>
    </xsl:template>
</xsl:stylesheet>
