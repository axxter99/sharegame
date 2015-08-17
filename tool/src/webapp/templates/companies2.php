<?
require ("../../init.inc");
#require ("../include/db_routines.php");
#require ("../include/user.php");

?>
<html>

<head>
	<title>Company Information</title>
</head>

<body bgcolor="#ffffff">
<p align="center"><a href="javascript:history.go(-1)">Back</a><P>
<hr>

<?
	
sharedbopen();
$arecordset=pg_exec($shareconn,"Select * From companies, sector where companies.sector=sector.sectorid and companycode~*'".$_GET["code"]."'");

	if (pg_numrows($arecordset)!==0) {
?>

<table width="90%" cellpadding="1" border="0" class="normal" align="center">
<tr>
	<td id="tabcolor1" colspan="2"><span class="normal"><b>Short Name:</b></span></td><td id="tabcolor3" colspan="2"><span class="normal"><?=pg_result($arecordset,0,"quickname")?></span></td><td id="tabcolor1" colspan="2"><span class="normal"><b>Name:</b></span></td><td id="tabcolor3" colspan="2"><span class="normal"><?=pg_result($arecordset,0,"companyname")?></span></td>
</tr>
<tr>
	<td id="tabcolor1" colspan="2"><span class="normal"><b>Code:</b></span></td><td id="tabcolor3" colspan="2"><span class="normal"><?=pg_result($arecordset,0,"companycode")?></span></td><td id="tabcolor1" colspan="2"><span class="normal"> <b>Sector:</b></span></td><td id="tabcolor3" colspan="2"><span class="normal"><?=pg_result($arecordset,0,"sectorname")?></span></td>
</tr>
<tr>
	<td colspan="8" align="left"></td>
</tr>
<tr>
	<td></td>
</tr>
<tr>
	<td colspan="8" align="middle">
	<table width="100%" align="center">
		<tr>
			<td width="50%"></td>
		</tr>
	</td>
</tr><!--next block-->
<tr>
	<td id="tabcolor1" valign="top" colspan="2" nowrap><span class="normal"><b>Nature of Business:</b></span></td><td colspan="6" id="tabcolor3"><span class="normal"><?=pg_result($arecordset,0,"natureofbusiness")?></span></td>
</tr>
<tr>
	<td id="tabcolor1" valign="top" colspan="2"><span class="normal"><b>Next Results:</b></span></td><td colspan="6" id="tabcolor3"><span class="normal"><?=pg_result($arecordset,0,"nextresults")?></span></td>
</tr>
<tr>
	<td id="tabcolor1" valign="top" colspan="2"><span class="normal"><b>Internet Address:</b></span></td><td id="tabcolor3" nowrap colspan="2"><span class="normal"><a href="<?=pg_result($arecordset,0,"website")?>"><?=pg_result($arecordset,0,"website")?></a> </span></td></tr><tr><td colspan="8">&nbsp;</td>
</tr>

<?
$sql="Select * from closingprices where cid=".pg_result($arecordset,0,"cid")." and inserttimestamp=(select max(inserttimestamp) from closingprices where cid=".pg_result($arecordset,0,"cid").")";
																																						     $brecordset=pg_exec($shareconn,$sql);
		if (pg_numrows($brecordset)!==0) {
?>

<tr>
	<td id="tabcolor1" colspan="8"><span class="normal"><b>Closing Price as at <?=pg_result($brecordset,0,"inserttimestamp")?>:</b></span></td>
</tr>
<tr>
	<td id="tabcolor1" align="middle"><span class="normal"><b>Close</b></span></td>
	<td id="tabcolor1" align="middle"><span class="normal"><b>High</b></span></td>
	<td id="tabcolor1" align="middle"><span class="normal"><b>Low</b></span></td>
	<td id="tabcolor1" align="middle"><span class="normal"><b>P/E<br>Ratio</b></span></td>
	<td id="tabcolor1" align="middle"><span class="normal"><b>Div<br>Yield</b></span></td>
	<td id="tabcolor1" align="middle"><span class="normal"><b>Earn<br> Yield</b></span></td>
</tr>
<tr>
	<td id="tabcolor3" align="middle"><span class="normal"><?=pg_result($brecordset,0,"ruling_price")?></span></td>
	<td id="tabcolor3" align="middle"><span class="normal"><?=pg_result($brecordset,0,"high")?></span></td>
	<td id="tabcolor3" align="middle"><span class="normal"><?=pg_result($brecordset,0,"low")?></span></td>
	<td id="tabcolor3" align="middle"><span class="normal"><?=pg_result($brecordset,0,"peratio")?></span></td>
	<td id="tabcolor3" align="middle"><span class="normal"><?=pg_result($brecordset,0,"divyield")?></span></td>
	<td id="tabcolor3" align="middle"><span class="normal"><?=pg_result($brecordset,0,"earnyield")?></span></td>
</tr>
<tr>
	<td id="tabcolor1" colspan="2"><span class="normal"><b>Shares Issued:</b></span></td><td id="tabcolor3" colspan="2"><span class="normal">
<? if  (! is_null(pg_result($arecordset,0,"sharesissued"))) {
echo pg_result($arecordset,0,"sharesissued");

}
?></span></td>
	<td id="tabcolor1" colspan="2"><span class="normal"><b>Market Cap:</b></span></td><td id="tabcolor3" colspan="6"><span class="normal">R<?
if  (! is_null(pg_result($arecordset,0,"sharesissued"))) {
  echo pg_result($arecordset,0,"sharesissued")*pg_result($brecordset,0,"ruling_price")/100;
	       }
?></span></td>
</tr>

<?
																			   }
	       
?>

<tr>
	<td></td>
</tr>
<tr>
	<td colspan="8" id="tabcolor1"><span class="menu"><b>Share History</b></span></td>
</tr>

<?
   $brecordset=pg_exec($shareconn,"select * from closingprices where cid=".pg_result($arecordset,0,"cid")." order by inserttimestamp desc limit 10");
	if (pg_numrows($brecordset)!==0) {
?>
<tr>
	<td colspan="2" width="25%" id="tabcolor1" align="left"><span class="menu"><b>Date</b></span></td><td width="12.5%" id="tabcolor3" align="right"><span class="menu"><b>Close</b></span></td>
<td width="12.5%" id="tabcolor3" align="right"><span class="menu"><b>High</b></span></td><td width="12.5%" id="tabcolor3" align="right"><span class="menu"><b>Low</b></span></td>
<td width="12.5%" id="tabcolor3" align="right"><span class="menu"><b>Volume</b></span></td><td colspan="2" id="tabcolor3" align="right"><span class="menu">&nbsp;</span></td>
</tr>
<?
 for ($i=0;$i<pg_numrows($brecordset);$i++) {
?>
<tr>
	<td colspan="2" width="25%" id="tabcolor1" align="left"><span class="menu">&nbsp;<?=pg_result($brecordset,$i,"inserttimestamp")?></span></td>
	<td width="12.5%" id="tabcolor3" align="right"><span class="menu"><?=pg_result($brecordset,$i,"ruling_price")?></span></td><td width="12.5%" id="tabcolor3" align="right"><span class="menu"><?=pg_result($brecordset,$i,"high")?></span></td><td width="12.5%" id="tabcolor3" align="right"><span class="menu"><?=pg_result($brecordset,$i,"low")?></span></td><td width="12.5%" id="tabcolor3" align="right"><span class="menu"><?=pg_result($brecordset,$i,"volume")?></span></td><td colspan="2" id="tabcolor3" align="right"><span class="menu">&nbsp;</span></td>
</tr>
<?
				#brecordset.MoveNext
			} #wend
		} #end if
		brecordset.close
?>

</table>
</table>
<div align="center"><hr noshade size="1" color="#c0c0c0" width="95%">
<?
			    } else {
	  echo "Could not find company code '".$_GET["code"]. "'";
			    }
	
pg_close($shareconn);
?>
<p align="center"><a href="javascript:history.go(-1)">Back</a><P>
</BODY>
</HTML>






