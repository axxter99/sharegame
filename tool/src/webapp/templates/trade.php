<?
/*
Sharetrade - Simple Sharetrading Simulation V 1.0.2
Copyright (C) 2001-2003  David Horwitz & Andrew Deacon

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
#	response.redirect "login.asp"
#end if
#echo phpinfo();

?>
<html>

<head>
	<title>Trade</title>
</head>

<body>
<?
$midstr= $_SESSION["studentid"];
#'Response.Write midstr
if ($_POST["transactionType"]=="buy" OR $_POST["transactionType"]=="sell") { 
	#'Response.Write $_POST["TransactionType") &"<BR>"
$midstr= $_SESSION["studentid"];
#echo "qwerty $midstr";
	
$quantity= $_POST["quantity"];
if (strlen($quantity)==0) { $quantity=0; }
		#$quantity = quantity)

if ($quantity>0) {  		
  sharedbopen();
			# Substitute in form parameters into the query string
  $sql = "INSERT INTO Trades (MID,TradeType,TradeQuantity,CID,Motivation,tradetimestamp) VALUES ('" . $_POST["MID"] . "','" . $_POST["transactionType"]. "'," . $_POST["quantity"]. "," . $_POST["CID"]. ",'" .str_replace("'", "''",$_POST["Motivation"]) . "',now());";

#echo $sql;
$objectcmd=pg_query($shareconn,$sql);
			#'response.write intrecords & " should be 1"
  $sql= "commit";
$objectcmd=pg_query($dbconn,$sql);
  		 
}
		if ($quantity<=0) {
		  echo  "<center><h1>You Must Enter a quantity greater than 0 in order to trade</h1></center>";
		}
}
?>

<p>Pending Transactions: if there are any, these will be processed later.</p>


<p><b>Manager's name:</b><?=$_SESSION['firstname']?> <?=$_SESSION['surname']?>

</p>

<table width="100%" border="0" bgcolor="#99CCFF">
  <thead>
    <tr>
      <td><b>Trade</b></td>
      <td><b>Quantity</b></td>
      <td><b>Time</b></td>
      <td><b>Motivation</b></td>
    </tr>
  </thead>
  <tbody>
   
<?
$fp_sQry="SELECT * FROM trades WHERE (mid =  '".$midstr."' AND tradecommitted =  'False')";
sharedbopen();
$arecordset=pg_query($shareconn,$fp_sQry);
for ($arecount=0;$arecount<pg_numrows($arecordset);$arecount++) {
?>

    <tr>
      <td><?=pg_fetch_result($arecordset,$arecount,"tradetype")?>
      </td>
      <td><?=pg_fetch_result($arecordset,$arecount,"tradequantity")?>
      </td>
      <td><?=pg_fetch_result($arecordset,$arecount,"tradetimestamp")?>
      </td>
      <td><?=pg_fetch_result($arecordset,$arecount,"motivation")?>
      </td>
    </tr>
    <?
} 
  ?>
  </tbody>
</table>

<form method="POST" action="commerce.php" name="Trade">
<?
echo "<input type=\"hidden\" name=\"LastMID\" value=\"" . $_POST["MID"]. "\">";
pg_close($shareconn);
?>
  <p><input type="submit" value="Continue..." name="B1"></p>
</form>
&nbsp;</body>
</html>
