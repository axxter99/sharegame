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
	<title>Trade Shares</title>
</head>

<body leftmargin="0" rightmargin="0" topmargin="0" marginwidth="0" marginheight="0" background="<?=$SBIGURI?>/images/<?=$buttoncolour?>/background.gif">

<table width="750" cellpadding="0" cellspacing="0" border="0">
  <tr>
  <td width="130" valign="top" background="<?=$SBIGURI?>/images/<?=$buttoncolour?>/navback.gif"><? require ("../include/navigation.php") ?></td>
  <td width="620" valign="top">
<? if ($graphicheader) { ?><img src="<?=$SBIGURI?>/images/<?=$buttoncolour?>/graphicheader.gif"><br><? } ?>
<form method="POST" name="Trade" action="transact.php">
<?
#echo php_info();
echo "<input name=\"LastMID\" type=\"hidden\" value=\"" . $_SESSION["studentid"] . "\">";
?>
<center>
<strong>
<a href="javascript:history.go(-1)">back</a>
</strong>
<br>
<br>

<table width="80%">
<tr>
	<b>Manager's name: <?=$_SESSION["firstname"]?> <?=$_SESSION['surname']?></b>
	<hr>
</tr>
<tr>
	<input type="radio" value="buy" name="TransactionType">Buy
</tr>
<tr>
   <input type="radio" name="TransactionType" value="sell">Sell
</tr>
<tr>
	<input type="radio" name="TransactionType" value="enquire" checked>Enquire
</tr>
<tr>
	<br>
	<input type="submit" value="Ok" name="B1">
	<hr>
</tr>
</table>
</center>
</form>

<p align="center"><a href="../game/share.php">Exit Share Trading (see historical share price data)</a></p>
    
</td></tr></table>

</body>
</html>
