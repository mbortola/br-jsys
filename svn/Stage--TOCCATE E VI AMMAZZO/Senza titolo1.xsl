<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
    <xsl:output method="xml" indent="yes"/>
    <xsl:variable name="padri" select="distinct-values(//FIELD[@NAME='padre'])"/>
    <xsl:variable name="roots" select="distinct-values(//RECORD[not(string(FIELD[@NAME='padre']))]/FIELD[@NAME='Features di riferimento'])"/>
    <xsl:template match="/">
        <xsl:element name="aaa">
            <xsl:element name="padri">
                <xsl:value-of select="$padri"/>
            </xsl:element>
            <xsl:element name="roots">
                <xsl:value-of select="$roots"/>
            </xsl:element>
            <xsl:element name="exist">
                <xsl:call-template name="root">
                    <xsl:with-param name="index" select="1"/>
                </xsl:call-template>
            </xsl:element>
        </xsl:element>
    </xsl:template>
    
    <xsl:template name="root">
        <xsl:param name="index"/>
        <xsl:call-template name="test">
            <xsl:with-param name="val" select="$padri[$index]"/>
        </xsl:call-template>
        <xsl:if test="not(empty($padri[$index+1]))">
            <xsl:call-template name="root">
                <xsl:with-param name="index" select="$index+1"/>
            </xsl:call-template>
        </xsl:if>
    </xsl:template>
    
    <xsl:template name="test">
        <xsl:param name="val"/>
                    <xsl:if test="empty(//RECORD[FIELD[@NAME='Features di riferimento']=$val])">
                        <xsl:element name="NO">
                            <xsl:attribute name="quanti" select="count(//RECORD[FIELD[@NAME='padre']=$val])"/>
                            <xsl:value-of select="$val"/>
                        </xsl:element>
                    </xsl:if>
    </xsl:template>
</xsl:stylesheet>
