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
7501
South Africa
Email: dhorwitz@its.uct.ac.za
   */ 

require ("../../init.inc");
#require ("../include/db_routines.php");

?>

<HTML>
<HEAD>
</HEAD>
<body leftmargin="0" rightmargin="0" topmargin="0" marginwidth="0" marginheight="0" background="<?=$SBIGURI?>/images/<?=$buttoncolour?>/background.gif">

<table width="750" cellpadding="0" cellspacing="0" border="0">
  <tr>
  <td width="130" valign="top" background="<?=$SBIGURI?>/images/<?=$buttoncolour?>/navback.gif"><? require ("../include/navigation.php") ?></td>
  <td width="620" valign="top">
<? if ($graphicheader) { ?><img src="<?=$SBIGURI?>/images/<?=$buttoncolour?>/graphicheader.gif"><br><? } ?>
<?
sharedbopen();
$i=1;
$arecordset=pg_exec($shareconn,"Select CompanyName,most_recent-last_week as move from movers, companies where movers.cid=companies.cid  and used order by 2 desc");
?>
<center>

<a href="javascript:history.go(-1)">Back</a>

<hr>

<table border=1>
<tr><td>
	<table>
		<tr><th></th><th>5 Best perfoming Share</th></tr>
		<?
for ($arecount=0;$arecount<pg_numrows($arecordset) AND $i<=5;$i++) {
		if (pg_result($arecordset,$arecount,"move")<0) {
		  $move = "<font color=\"Red\">".pg_result($arecordset,$arecount,"move")."</font>";
		} else {
		  $move = pg_result($arecordset,0,"move");
		}
		echo "<tr><td>".$i."</td><td>".pg_result($arecordset,$arecount,"companyname")."</td><td>".$move."</td></tr>";
		$arecount=$arecount+1;
}


	

		?>
	</table>
	</td><td>
	
	<table>
	<tr><th></th><th>5 worst performing share</th></tr>
	<?
	$i=1;
$arecordset=pg_exec($shareconn,"Select CompanyName,most_recent-last_week as move from movers, companies where movers.cid=companies.cid and used and length(2)>=1 order by 2");
for ($arecount=0;$arecount<pg_numrows($arecordset) AND $i<=5;$arecount++) {	
#while not arecordset.EOF and i<=5
	if (pg_result($arecordset,0,"move")<0) {
	  $move = "<font color=\"Red\">".pg_result($arecordset,$arecount."move")."</font>";
	} else {
	  $move =pg_result($arecordset,0,"move");
	   }

 echo "<tr><td>".$i."</td><td>".pg_result($arecordset,$arecount,"companyname")."</td><td>".$move."</td></tr>";
	
 $i=$i+1;
}
	

	?>
	</table>
	</td></tr>
</table>
</center>
<?
pg_close($shareconn); ?>
</td></tr></table>

</body>
</html>
