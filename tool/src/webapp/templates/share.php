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
7001
South Africa
Email: dhorwitz@its.uct.ac.za
   */ 
require ("../../init.inc");


#if isnull(session.contents("mid")) or len(session.contents("mid"))=0 then
#response.redirect "login.php"
#end if
?>
<html>

<head>
<title>Share Game</title>
</head>

<body>

<h2 align="left">Industry Research Project: Share Trading</h2>

<p align="left"><font size="2">You have been given R100 000 to buy shares in companies. 
Use this money to buy the shares you think will increase in value in
the next weeks. Once you have bought shares, the transaction is placed in a database and
marked as 'pending'. The shares are 'bought' at that day's closing price and your 'bank
balance' is debited. If you have insufficient money to buy all the shares you requested,
you will receive the shares you were able to afford. You cannot undo any transactions, so
check what you fill in on the forms. Once you have bought shares and the transaction has
been processed you can sell them. The money is then credited to your bank balance.
Consult the links to useful information or click the 'Start Trading' button below 
to view your portfolio or buy or sell shares.</font></p>

<form method="POST" action="commerce.php">
<?
echo "<input name=\"LastMID\" type=\"hidden\" value=\"".$_SESSION["Studentid"]. "\">";
?>
<div align="left">
<table border="0" width="100%" height="85">
<tr>
	<td><div align="left"><p align="center">
	<input type="submit" value="Trade Shares" name="B3"></p>
      </div><div align="left">
      <ul>
        <li>
          <font size="3"><a href="companyinfo.php">Company 
      Data</a> - share price and company information&nbsp;</font>
        </li>
        <li>
          <font size="3"> <a href="http://wol.sharenet.co.za/free/library/" target="_blank">ShareNet
      Web site</a> - more useful onformation on the shares</font>
        </li>
        <li>
          <font size="3"><a href="graphs.php">Graphs
          and results</a>  - company share price</font>
        </li>
        <li>
          <font size="3"><a href="movers.php">Last week</a> - share prices of
          the week&nbsp;</font>
        </li>
        <li>
          <font size="3"><a href=trades.php>Trading history</a> - your
          trading history</font>
        </li>
        <li>
          <font size="3"><a href="wealth.php">Wealth (Shares + Cash)</a>
          - wealth of everyone in the class&nbsp;</font>
        </li>
        <li>
          <font size="3"><a href="trading.htm">Trading Rules</a> - rules and
          information on trading</font>
        </li>
      </ul>
<?

if (islecturer()) {
?>
      Go to the <a href="admin/">administration tools</a>    
<? 
}
?>
      </div><div align="center"><center><p></p>
      </center></div><div align="center"><center><hr>
        </div>
      </center></td>
    </tr>
    <tr align="center">
      <td><div align="center"><center><p><br>
     <?=$_SESSION['studentid']?>
     <br>    
     <input type="button" value="This is not my student number!" name="B2" onClick="window.open('deletecookie.php', '_top');"></p>
      <BR>
      Our records indicate the you last loged in on <?=$_SESSION["lastlogin"]?>
      <BR>
      If you did not please check your portfolio and speak to the course lecturer
      </center></div><div align="center"><center><p><img src="../images/WB01727_.gif" alt="WB01727_.gif (697 bytes)" WIDTH="482" HEIGHT="12"></td>
    
    </tr>
  </table>
  </div>
</form>

<p align="center">&nbsp; 
</body>
</html>
