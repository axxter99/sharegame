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
Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307,  'USA.

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

<HTML>
<HEAD>
<TITLE>Trading History</TITLE>
</HEAD>
<body leftmargin="0" rightmargin="0" topmargin="0" marginwidth="0" marginheight="0" background="<?=$SBIGURI?>/images/<?=$buttoncolour?>/background.gif">

<table width="750" cellpadding="0" cellspacing="0" border="0">
  <tr>
  <td width="130" valign="top" background="<?=$SBIGURI?>/images/<?=$buttoncolour?>/navback.gif"><? require ("../include/navigation.php") ?></td>
  <td width="620" valign="top">
<? if ($graphicheader) { ?><img src="<?=$SBIGURI?>/images/<?=$buttoncolour?>/graphicheader.gif"><br><? } ?>
<center>

<a href="javascript:history.go(-1)">Back</a>

<hr>


<H2>Trading History</h2>

<p align=left>
Your trading history is shown below. 
It lists all trades that have been executed. 
It does not list any pending trades
</p>	

<?


sharedbopen();
$arecordset=pg_exec($shareconn,"Select tradetype || ' ' || CompanyCode as Trade,tradequantity AS Quantity,motivation AS Motivation,tradetimestamp AS When,confirmation AS Confirm from trades,companies where mid~*'".$_SESSION['studentid']."' and companies.cid=trades.cid and tradecommitted");
#echo "Select tradetype || ' ' || CompanyCode as Trade,tradequantity AS Quantity,motivation AS Motivation,tradetimestamp AS When,confirmation AS Confirm from trades,companies where mid~*'".$_SESSION['studentid']."' and companies.cid=trades.cid and tradecommitted";

if (! pg_numrows($arecordset)==0) {
?>

<table border=1>
<tr>
<?
  for ($i=0;$i<pg_num_fields($arecordset);$i++) {
?>
<th><?=pg_field_name($arecordset,$i)?></th>
<?
  } #next
?>
</tr>
<?
for ($arecount=0;$arecount<pg_numrows($arecordset);$arecount++) {
?>
<TR>
<?
  for ($i=0;$i<pg_num_fields($arecordset);$i++) {
?>
<td valign=top align=left>
<?
	#if ($i=pg_num_fields($arecordset)-1) { echo "<font size=2>";}
	if ($i==1) { echo "<p align=right>"; }
    echo pg_fetch_result($arecordset,$arecount,$i);
	if ($i==1) { echo "</p>"; }
	#if ($i== pg_num_fields($arecordset)-1) { echo "</font>"; }
?>
</td>
<?
  } #next
?>
</tr>
<?
 } #arecordset.MoveNext

?>
</table>

<?
}


pg_close($shareconn)
?>

</center>

</td></tr></table>

</body>
</html>











