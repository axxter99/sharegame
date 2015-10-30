<?php /*
 * #%L
 * sharegame - Tool
 * %%
 * Copyright (C) 2003 - 2015 Sakai Project
 * %%
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *             http://opensource.org/licenses/ecl2
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */ ?>
<? /*
Sharetrade - Simple Sharetrading Simulation V 1.0.1
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


 ?>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
</head>

<body leftmargin="0" rightmargin="0" topmargin="0" marginwidth="0" marginheight="0" background="<?=$SBIGURI?>/images/<?=$buttoncolour?>/background.gif">

<table width="750" cellpadding="0" cellspacing="0" border="0">
  <tr>
  <td width="130" valign="top" background="<?=$SBIGURI?>/images/<?=$buttoncolour?>/navback.gif"><? require ("../include/navigation.php") ?></td>
  <td width="620" valign="top">
<? if ($graphicheader) { ?><img src="<?=$SBIGURI?>/images/<?=$buttoncolour?>/graphicheader.gif"><br><? } ?>
<center>

<a href="javascript:history.go(-1)">Back</a>

<form method="POST" action="trade.php">

<table border=0 width=80% bordercolor="#000000">
<tr>
	<td spancol=4>
	<b>Manager's name:</b><?=$_SESSION["firstname"]?> <?=$_SESSION['surname']?>
	<hr>
	</td>
</tr>
</table>
<?

$id = $_SESSION["studentid"];
$transtype= $_POST["TransactionType"];

$totalvalue=0;
sharedbopen();

#'lets get the Dollar Rand exchange rate

$brecordset=pg_query($shareconn,"select * from exchange_rate order by rate_date desc");
$usd_zar = pg_fetch_result($brecordset,0,"zar_usd");

#'response.write usd_zar

$brecordset=pg_query($shareconn,"select DISTINCT on (exchangename) * from companies where used=TRUE");
$totalvalue=0;
$k=0;
for ($brecount=0;$brecount<pg_numrows($brecordset);$brecount++) {
?>
<table border=0 width=80% bordercolor="#000000">
<tr>
	<td><b>Exchange: <?=pg_fetch_result($brecordset,$brecount,"exchangename") ?></b></td>
</tr>
</table>
<table border=0 width=80% bordercolor="#000000" bgcolor="#66CCFF">
<?		
	$arecordset=pg_query($shareconn, "select distinct on (companyname) * from portfolios,companies,closingprices where mid='".$id."' and companies.cid=portfolios.cid and closingprices.cid=companies.cid and closingprices.inserttimestamp=(select max(inserttimestamp) from closingprices, companies where companies.cid=closingprices.cid and companies.exchangename='".pg_fetch_result($brecordset,$brecount,"exchangename")."') and companies.exchangename='".pg_fetch_result($brecordset,$brecount,"exchangename")."' and quantity>0");
	if (pg_numrows($arecordset)==0) {
?>
<Tr>
	<td spancol=4><i>No shares owned</i></td>
</tr>		
<?
	 } else {
?>	
<TR>
	<th align="left">Company name</th>
	<th align="right">Quantity</th>
	<th align="right">Ruling price</th>
	<th align="right">Value</th>
</tr>
<?	
		for  ($arecount=0;$arecount<pg_numrows($arecordset);$arecount++) {
			$share_Price = pg_fetch_result($arecordset,$arecount,"ruling_price");
			
			if  (pg_fetch_result($brecordset,$brecount,"exchangename") == "NASDAC" OR pg_fetch_result($brecordset,$brecount,"exchangename")== "NYSE"  OR pg_fetch_result($brecordset,$brecount,"exchangename")== "LSE" ) {
				$share_Price=round($share_Price*$usd_zar);
			}  #end if
?>			
<tr>
	<td><b><a href=companies2.php?code=<?=pg_fetch_result($arecordset,$arecount,"companycode")?>><?=pg_fetch_result($arecordset,$arecount,"companyname") ?></a></b></td>
	<td align="right"> <?=pg_fetch_result($arecordset,$arecount,"Quantity")?> </td>
	<td align="right"> <?=$share_Price?>c</td>
	<td align="right">R<?=$share_Price*pg_fetch_result($arecordset,$arecount,"quantity")/100 ?></td>
</tr>	
<?
	$totalvalue= $totalvalue+(($share_Price*pg_fetch_result($arecordset,$arecount,"quantity"))/100);
	$shares_owned=array(
	$k=>pg_fetch_result($arecordset,$arecount,"cid")
   	    #	[1][$k]=>pg_reult($arecordset,$arecount,"companyname")
			);
	
			$k=$k+1;
	}#	wend
} #end no shares if
	} #brecordset.movenext
	#arecordset.close

?>
</table>

<table border=0 width=80% bgcolor="#FFFF99">
<tr>
	<td><b>Total value of shares</b></td>
	<td></td>
	<td></td>
	<td align="right"><b>R<?=$totalvalue?></b></td>
</tr>
<P>
<?
$arecordset=pg_query($shareconn,"select * from bankaccounts where mid~*'".$id."'");
if (! pg_numrows($arecordset)==0) {
?>
<tr>
	<td><b>Bank balance</b></td>
	<td></td>
	<td></td>
	<td align="right"><b>R<?=round(pg_fetch_result($arecordset,0,"balance"),2)?></b></td>
</tr>
<?
	$i = pg_fetch_result($arecordset,0,"balance");
	$totalvalue = $totalvalue+$i;

}

?>
<tr>
	<td><b>Total wealth</b></td>
	<td></td>
	<td></td>
	<td align="right"><b>R<?=round($totalvalue,2) ?></b></td>
</tr>
</table>

<br>

<table border=0 width=80% bordercolor="#000000">
<tr><td><b>Pending Trades</b></td></tr>
</table>

<table border=0 width=80% bgcolor="#FFCC99" bordercolor="#FFFFFF">
<?
$buy_value=0;
$arecordset=pg_query($shareconn,"select * from trades,companies, closingprices where mid='".$id."' and tradecommitted=false and companies.cid=trades.cid and closingprices.cid=companies.cid and closingprices.inserttimestamp=(select max(inserttimestamp) from closingprices) and tradetype='buy'");
for ($arecount=o;$arecount<pg_numrows($arecordset);$arecount++) {
	$buy_value= $buy_value + (pg_fetch_result($arecordset,$arecount,"tradequantity")*pg_fetch_result($arecordset,$arecount,"ruling_price")/100);
	
}
if ($buy_value==0) {
$buy_value="No Buys Pending";
}
?>
<tr>
	<td>Buys pending</td>
	<td align="right"><?=$buy_value ?></td>
</tr>
<?

$sell_value=0;
$arecordset=pg_query($shareconn,"select * from trades,companies, closingprices where mid='".$id."' and tradecommitted=false and companies.cid=trades.cid and closingprices.cid=companies.cid and closingprices.inserttimestamp=(select max(inserttimestamp) from closingprices) and tradetype='sell'");
for ($arecount=o;$arecount<pg_numrows($arecordset);$arecount++) {
	$sell_value= $sell_value + (pg_fetch_result($arecordset,$arecount,"tradequantity")*pg_fetch_result($arecordset,$arecount,"ruling_price")/100);
	

if ($sell_value==0 ) {
$sell_value="No Sells Pending";
}
} ?>
<tr>
	<td>Sells pending</td>
	<td align="right"><?=$sell_value ?></td>
</tr>

</table>

<br>
<center>
<table border=0 width=80% bordercolor="#000000">

<tr>
<? 
if ($transtype=="buy" OR $transtype=="sell") {
?>		
	<td width="20%">
		<b><?=$transtype ?>:</b> 
	</td>
	<td width="80%">
		<select size=1 name=CID>
		<option value=0>---Select share to <?=$transtype ?>---</option>
<?
	if ($transtype=="buy") {
		#'find out which shares they can buy
		#need to look at this angain..
		#if  session.contents("grp_id1")=1 then
		#	share_sql=""
		#end if
		
		#if session.contents("grp_id1")<>1 then
		#	grp_count=session.contents("grp_count")
		#	z=1		
		#	'get the first group
		#	share_sql= " and ("
		#	for z=1 to grp_count
		#		if z=1 then
		#			share_sql1="group_id="&cstr(session.contents("grp_id"&z))
		#		elseif z > 1 then
		#			share_sql1=" or group_id="&cstr(session.contents("grp_id"&z))
		#		end if
		#		share_sql=share_sql&share_sql1
		#	next
		#	share_sql=share_sql&")"
		#end if
		
		$arecordset=pg_exec ($shareconn,"select * from companies,groups_share_link where companies.cid=groups_share_link.cid and used=TRUE".$share_sql." order by companyname");
		$last_cid="";
		for ($arecount=0;$arecount<pg_numrows($arecordset);$arecount++) {
	  		if (pg_fetch_result($arecordset,$arecount,"cid")<>$last_cid ) {
				echo "<option value=\"" . pg_fetch_result($arecordset,$arecount,"cid") . "\">" . pg_fetch_result($arecordset,$arecount,"companyname") . "</option>";
			}
			$last_cid=pg_fetch_result($arecordset,$arecount,"cid");
		
		}
	
	}


	if  ($transtype=="sell") {
		#'should we get the shares for which buys are pending?
		
	#	$crecordset=pg_query($shareconn,"select distinct on (companyname) * from trades, companies where mid='".$id."' and tradetype='buy' and tradecommitted=FALSE and trades.cid=companies.cid order by companyname");
$sql="select distinct on (companyname) * from portfolios, companies where mid='".$id."' and portfolios.cid=companies.cid order by companyname";
#echo $sql;
	$crecordset=pg_query($shareconn,$sql);

		}
		
		for ($crecount=0;$crecount<pg_numrows($crecordset);$crecount++)  {
		echo "in the loop";
			
				echo "<option value=\"".pg_result($crecordset,$crecount,"cid")."\">".pg_result($crecordset,$crecount,"companyname")."</option>";
			
		#}
	}
?>		 
		</select>
	</td>
</tr>
<tr>
	<td><B>Number of shares:</B></td>
<?
	if ( $k > 0 OR $transtype=="buy" ) {
?>	
		<td><input type=text name=quantity size=20 value=0></td>		
<?
	 } else {
?>	
		<td>0<input type=hidden name=quantity size=20 value=0></td>		
<?		
	}
?>
</tr>
<tr>
	<td><B>Motivation:</B></td>
	<td>
		<input type=text name=Motivation size=60>
		<input type=hidden name=transactionType value="<?= $transtype ?>">
		<input type=hidden name=MID value="<?=$id ?>">
	</td>
</tr>
<?
}
?>
<tr>
</td>
<? 
if ($transtype=="buy" or $transtype=="sell") {
?>	
<tr>
	<td><input type="submit" value="Submit" name="B1"></td>  
	<td>Remember you can't undo your actions</td>
</tr>
<?
}
?>	
<tr>
	<td colspan=2 align=center>
		<br>
		<br>
		<font color="#FF0000" size=2>
			Note: all prices for US stocks are quoted in Rands at the current exchanges rate, <br>
			all transactions will be charged at the exchange rate when the trade is	affected.
		</font>
	</td>
</tr>	
</table>
</form>
</center>
</body>