<?
require ('../../init.inc');
?>
<html>

<head>
<title>Welcome to the Industry Research Project Share Game</title>
</head>

<body>
<?
#check the users sahregame settings
sharedbopen();
$usrrec=pg_query($shareconn,"Select * from portfoliomanagers where mid='".$_SESSION['studentid']."'");
#echo "Select * from portfoliomanagers where mid='".$_SESSION['studentid']."'";
if (pg_numrows($usrrec)==0) {
 # echo "no user";
  $cuser=pg_query($shareconn,"insert into portfoliomanagers values ('".$_SESSION['studentid']."','".$_SESSION['firstname']." ".$_SESSION['surname']."','old',false,NULL,NULL,NULL,'".$_SESSION['email']."')");

#create a bankacount
  $bnkrec=pg_query($shareconn,"insert into bankaccounts values ('".$_SESSION['studentid']."',100000)");

}

pg_close($shareconn);

?>


<h1 align="center">Welcome to the Industry Research Project Share Game</h1>

<p>We will look at three shares in the gold industry that were the focus of our scenario.
Click the Continue button below to start. When you have finished or need to return to
Excel, click the Close button [X] in the top right corner of this small window.</p>

<form method="POST" action="share.php"
name="Intro">
  <input type="hidden" name="LastMID" value><div align="center"><center><p><input
  type="submit" value="Continue" name="B1"></p>
  </center></div>
</form>
</body>
</html>

