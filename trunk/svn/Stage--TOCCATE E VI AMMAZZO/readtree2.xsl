<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
    <xsl:output method='xml' indent="yes"/>
    
    <xsl:key name="ref" match="Release" use="@name"/>
    
    
    <xsl:variable name="release" select="distinct-values(//Release/@name)"/>
    
    <xsl:template match="/">
        <root>
            <xsl:call-template name="buildTree">
                <xsl:with-param name="index" select="1"/>
            </xsl:call-template>
        </root>
    </xsl:template>
    
    <xsl:template name="buildTree">
        <xsl:param name="index"/>
        <Release name='{$release[$index]}'>
            <xsl:for-each select="root/Feature">
                <Feature name='{@name}' completi='{sum(.//Release[@name=$release[$index]]/@completi)}'
                    aperti='{sum(.//Release[@name=$release[$index]]/@aperti)}'>
                    <xsl:for-each select="Childs/Feature">
                        <xsl:call-template name="rec">
                            <xsl:with-param name="rel" select="$release[$index]"/>
                        </xsl:call-template>     
                    </xsl:for-each>
                    
                </Feature>
            </xsl:for-each>
        </Release>
        <xsl:if test="not(empty($release[$index+1]))">
            <xsl:call-template name="buildTree">
                <xsl:with-param name="index" select="$index+1"/>
            </xsl:call-template>
        </xsl:if>
    </xsl:template>
    
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
