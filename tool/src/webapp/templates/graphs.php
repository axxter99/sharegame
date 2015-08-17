<? /*
Sharetrade - Simple Sharetrading Simulation V 1.0.1
Copyright (C) 2001  David Horwitz & Andrew Deacon

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, 
USA.

David Horwitz
Multimedia Education Group
Private Bag
Rondebosch
7001
South Africa
Email: dhorwitz@its.uct.ac.za
   */
require ("../../init.inc");
#require ("../include/db_routines.php");

#if isnull(session.contents("mid")) or len(session.contents("mid"))=0 then
#response.redirect "login.asp"
#end if

?>
<html>

<head>
<title>Share Graphs</title>

</head>

<body>

<center>

<a href="javascript:history.go(-1)">Back</a>

<hr>




<table width="90%" border="1">
 
    <tr>
      <td><b>Company</b></td>
      <td><b>GraphURL</b></td>
 
      
    </tr>
    <?
$Lastmid =$_SESSION["studentid"];
#    'response.write session.contents("mid")
 sharedbopen();

$sql="SELECT DISTINCT companies.companyname, companies.website, companies.companycode, companies.quickname,companies.cid, portfoliomanagers.mid FROM Companies, groups_share_link,tblgroups,portfoliomanagers,manager_grps_link WHERE (((companies.Used)=TRUE))  and portfoliomanagers.mid='".$Lastmid ."' and groups_share_link.group_id=tblgroups.tblgroups_id and tblgroups.tblgroups_id=manager_grps_link.group_id and manager_grps_link.mid=portfoliomanagers.mid group by companyname, website, companyCode,quickname,companies.cid, portfoliomanagers.mid;";
$arecordset=pg_exec($shareconn,$sql); 
for ($i=0;$i<pg_numrows($arecordset);$i++) {
$cname=pg_result($arecordset,$i,"companyName");

if (!is_null(pg_result($arecordset,$i,"website"))) {
 $cname="<a href=\"".pg_result($arecordset,$i,"website")."\">".$cname."</a>";
}
#'http://www.moneymax.co.za/chart_centre/companies/default.asp?ticker="&lcase(arecordset("companyCode"))&"&ctype=
$graphurl="<a href=companygraph.php?cid=".pg_fetch_result($arecordset,$i,"cid")."&months=6>graph</a>";
if (! is_null(pg_result($arecordset,0,"quickname"))) {
  $graphurl2="<a href=\"http://www.sharenet.co.za/webgraph/graph.phtml?sharename=".pg_result($arecordset,$i,"quickname")."\"> trend graph (quick)</a>";
  }
if (is_null(pg_result($arecordset,$i,"quickname"))) {
  $graphurl2="";
}

$dataurl="<a href=\"http://www.moneymax.co.za/cosnapshots/ratios.asp?co_refs=".pg_result($arecordset,0,"companycode")."\">Snapshot data</a>";
    echo "<tr><Td>".$cname."</td><TD>".$graphurl."</td></tr>";

} #wend    
    ?>
    
    </table>
     <p align="center"><!--webbot bot="Navigation" S-Type="children" S-Orientation="horizontal" S-Rendering="graphics" B-Include-Home="FALSE" B-Include-Up="TRUE" U-Page S-Target startspan --><!--webbot bot="Navigation" endspan i-checksum="0" --></p>
    <p align="center"><img src="../images/WB01727_.gif" alt="WB01727_.gif (697 bytes)" WIDTH="482" HEIGHT="12"> </p>
    <p align="center">More on shares: <a href="http://www.sharenet.co.za/webgraph/found.phtml?sector=14&amp;exch=JSE">http://www.sharenet.co.za/webgraph/found.phtml?sector=14&amp;exch=JSE</a>
    </p>
    
</body>
</html>
<? pg_close($shareconn);

?>