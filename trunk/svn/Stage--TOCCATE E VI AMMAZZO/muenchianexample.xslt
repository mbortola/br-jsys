<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0"  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" indent="yes" />
	
	<!-- 
		Construct the key (top-level element). As a result, call to function key('car-key','Toyota') would return all car
		elements that have 'Toyota' as value of @manufacturer attribute.
		//-->
	
	<xsl:key name="car-key" match="car" use="@manufacturer"   />
	<!-- 
		Get unique manufacturers by using Muenchian grouping. 
		
		Idea is that call to key function like this:
		key('car-key','Toyota')[1] would return the first car that has Toyota as manufacturer. 
		
		Therefore following:
		generate-id(.)=generate-id(key('car-key',@manufacturer)[1])
		would be true only for car that is the first car from this manufacturer
		
		But generate-id function, that generates unique identification string for given node, uses only the first node in the node-set so predicate [1] is not needed.
		
		So in English the following would be get manufacturer attribute of all car elements that are "first car from this manufacturer" in this document (in other words same as distinct manufacturer))
		
		//-->
	<xsl:variable name="uniquemanufacturers"  select="/cars/car[generate-id(.)=generate-id(key('car-key',@manufacturer))]/@manufacturer" />
	
	<!-- 
		Reflect to root node and form the HTML page
		//-->
	<xsl:template match="/">
		
		
		<html>
			<head>
				<title>
					Unique manufacturers, Muenchian grouping in effect	
				</title>	
			</head>
			<body>
				<table border="1">
					<tr>
						<td colspan="3">
							Example using Muenchian grouping
						</td>
					</tr>
					<tr valign="top">
						<td><b>Manufacturer</b></td>
						<td><b>Count of owners</b></td>
						<td><b>Owner(s)</b></td>
					</tr>
					<!--
						Logic separated to second template
						//-->
					<xsl:call-template name="processmanufacturers" />
				</table>
			</body>
		</html>
	</xsl:template>
	
	<!--
		This then same as in previous article.
		//-->
	<xsl:template name="processmanufacturers">
		<!--
			Process each distinct manufacturer
			//-->
		<xsl:for-each select="$uniquemanufacturers">
			<!--
				Sort by manufacturer
				//-->
			<xsl:sort select="." />
			
			<!-- 
				Output the manufacturer into first row
				//-->
			<tr>
				<td><xsl:value-of select="." /></td>
				<td><xsl:text>&#xa0;</xsl:text></td>
				<td><xsl:text>&#xa0;</xsl:text></td>
			</tr>	
			
			<!-- 
				Get owners (by the current manufacturer)
				//-->
			<xsl:variable name="owners" select="//car[@manufacturer=current()]/@owner" />
			
			
			<tr>
				<td><xsl:text>&#xa0;</xsl:text></td>
				<!-- 
					Output count of owners
					//-->
				<td valign="top"><xsl:value-of select="count($owners)" /></td>
				<td valign="top">			
					<!--
						Process owners and print them out	
						//-->
					<xsl:for-each select="$owners">
						<xsl:sort select="." />
						<xsl:value-of select="current()" /><br/>
					</xsl:for-each>
				</td> 
			</tr>
		</xsl:for-each>
		
	</xsl:template>
	
	
</xsl:stylesheet>

