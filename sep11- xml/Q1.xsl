<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


<xsl:template>
        <html>
        <head>
        <style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

tr:hover {background-color:#f5f5f5;}
</style>
        </head>
            <body>
                <h1>Questions 1,2,3 </h1>
                <table border="2">
                    <tr>
                        <th>Region</th>
                        <th>Location</th>
                        <th>Feature type</th>
                        <th>ROV Dives</th>
                        <th>Area covered</th>
                        <th>Depth range surveyed </th>
                        <th>Distance from land</th>
                        <th>Shipping activity proxy</th>
                        <th>Items</th>
                    </tr>
                    <xsl:for-each select="isro">
                    <xsl:sort select="rov_dives"/>
                    <xsl:if test="distance &gt; 1100">
                        <tr>
                            <td>
                                <xsl:value-of select="region" />
                            </td>
                            <td>
                                <xsl:value-of select="location" />
                            </td>
                            <td>
                                <xsl:value-of select="feature_type" />
                            </td>
                            <td>
                                <xsl:value-of select="rov_dives" />
                            </td>
                            <xsl:choose>
                               <xsl:when test="area_covered &lt; 1">
                                 <td bgcolor="#ff0000">
                                 <xsl:value-of select="area_covered" /></td>
                               </xsl:when>
                               <xsl:otherwise>
                                <td>
                                 <xsl:value-of select="area_covered" /></td>
                               </xsl:otherwise>
                             </xsl:choose>
                            <td>
                                <xsl:value-of select="depth_range" />
                            </td>
                            <td>
                                <xsl:value-of select="distance" />
                            </td>
                            <td>
                                <xsl:value-of select="shipping" />
                            </td>
                            <td>
                                <xsl:value-of select="items" />
                            </td>
                        </tr>
                        </xsl:if>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
