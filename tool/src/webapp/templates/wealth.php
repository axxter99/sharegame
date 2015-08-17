<? /*
Sharetrade - Simple Sharetrading Simulation V 1.0.2
Copyright (C) 2001/2  David Horwitz & Andrew Deacon

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
7501
South Africa
Email: dhorwitz@its.uct.ac.za
*/
require ("../../init.inc");
#require ("../include/db_routines.php");

?>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Manager's Wealth</title>
</head>

<body leftmargin="0" rightmargin="0" topmargin="0" marginwidth="0" marginheight="0" background="<?=$SBIGURI?>/images/<?=$buttoncolour?>/background.gif">

<table width="750" cellpadding="0" cellspacing="0" border="0">
  <tr>
  <td width="130" valign="top" background="<?=$SBIGURI?>/images/<?=$buttoncolour?>/navback.gif"><? require ("../include/navigation.php") ?></td>
  <td width="620" valign="top">
<? if ($graphicheader) { ?><img src="<?=$SBIGURI?>/images/<?=$buttoncolour?>/graphicheader.gif"><br><? } ?>

<center>

<a href="javascript:history.go(-1)">Back</a>

<hr>


<img src=wealthgraph.php?months=6>
<?

sharedbopen();


$crsrec=pg_exec($shareconn, "Select * from courses,managerscourses where courses.courseid=managerscourses.courseid and mid='".$_SESSION['studentid']."'");


for ($crsrecount=0;$crsrecount<pg_numrows($crsrec);$crsrecount++) {
?>
<table border=0 bgcolor="#FF9900">
  <thead>
  <tr><th align=left><?=pg_fetch_result($crsrec,$crsrecount,"coursename")?> (<?=pg_fetch_result($crsrec,$crsrecount,"coursecode")?>)</th></tr>
    <tr>
      <td><b>Manager's name</b></td>
      <td align=right><b>Wealth</b></td>
    </tr>
  
  </thead>
  <tbody>
  <?
#and degree<>'MEG001' this needs to be added to the where statement when the course is run to remove staff from the list

$fp_sQry="SELECT * FROM Wealth_daily,portfoliomanagers,managerscourses where date_run=(select max(date_run) from wealth_daily) and wealth_daily.mid=portfoliomanagers.mid and managerscourses.mid=portfoliomanagers.mid and courseid=".pg_fetch_result($crsrec,$crsrecount,"courseid")." and haslogedin ORDER BY Wealth DESC";
$fp_sNoRecords="<tr><td colspan=2 align=left width=\"100%\">No records returned.</td></tr>";
$arecordset=pg_exec($shareconn,$fp_sQry);
#if (pg_numrows($arecordset)==0) { 
#echo  $fp_sNorecords; 
#}

  for ( $arecount=0;$arecount<pg_numrows($arecordset);$arecount++) {
?>
    <tr>
      <td bordercolor="#FFFFFF" bgcolor="#FFFF99"><?=pg_fetch_result($arecordset,$arecount,"name")?></td>
      <td bgcolor="#FFFF99" align=right>R<?=pg_fetch_result($arecordset,$arecount,"wealth")?></td>
    </tr>
<?
     #arecordset.MoveNext
  } #wend
#arecordset.Close

?>
    <P><P>
  </tbody>
</table>


<? 
 } 

pg_close($shareconn);
?>
</center>
</td></tr></table>

</body>
</html>
