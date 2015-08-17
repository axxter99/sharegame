<?
require ("../../init.inc");


?>

<HTML>
<HEAD>
<Title>Company Information</Title>
</HEAD>
<BODY>

<center>
<a href="javascript:history.go(-1)">Back</a>
<hr>

<?
sharedbopen();
$arecordset=pg_exec($shareconn,"Select * from companies,sector where companies.sector=sector.sectorid and used order by companyname");
?>
<table width="50%">
<TR>
 <TH align=left>Company name</th>
 <th align=right>Code</th>
 <th align=right>Sector</th>
</tr>
<?
for ($i=0;$i<pg_numrows($arecordset);$i++) {

?>
<tr>
 <td><a href=companies2.php?code=<?=pg_result($arecordset,$i,"companycode")?>><?=pg_result($arecordset,$i,"companyname")?></a></td>
 <td  align=right><?=pg_result($arecordset,$i,"companycode")?></td>
 <td  align=right><?=pg_result($arecordset,$i,"sectorname")?></td>
</tr>
<?
}
 # arecordset.MoveNext
#wend
?>
</table>
<?
pg_close($shareconn);
?>
</BODY>
</HTML>
