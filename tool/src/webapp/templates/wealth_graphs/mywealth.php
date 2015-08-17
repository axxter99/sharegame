<?

include ("../../init.inc");
include ("../../include/jpgraph/jpgraph.php");
include ("../../include/db_routines.php");
include ("../../include/jpgraph/jpgraph_line.php");

sharedbopen();

$sql="Select * from wealth_daily,avg_wealth_daily where mid='".$_SESSION["studentid"]."' and wealth_daily.date_run>=date(now()-interval '6 months') and wealth_daily.date_run=avg_wealth_daily.date_run order by wealth_daily.date_run";
#echo $sql;
$wealthrec=pg_query($shareconn,$sql);



for ($i=0;$i<pg_numrows($wealthrec);$i++) {

  $ydata[] = pg_fetch_result($wealthrec,$i,"wealth");
	$avgline[]=pg_fetch_result($wealthrec,$i,"avg");

}

for ($i=0;$i<pg_numrows($wealthrec);$i++) {

  $xtitles[] = pg_fetch_result($wealthrec,$i,"date_run");


}
pg_close($shareconn);
// Create the graph. These two calls are always required 
$graph = new Graph(600,250,"auto");     
$graph->SetScale( "textlin"); 
$graph ->SetMargin(50,70,40,70);

// Create the linear plot 
$lineplot =new LinePlot($ydata); 
$lineplot ->SetColor("blue"); 
$lineplot2 =new LinePlot($avgline);
$lineplot2 ->SetColor("red"); 
// Add the plot to the graph 
$graph->Add( $lineplot); 
$graph->Add($lineplot2);
$graph->xaxis-> SetTickLabels( $xtitles);
$graph->xaxis-> SetTextLabelInterval(7);
$graph->xaxis-> SetLabelAngle(90);

// Display the graph 
$graph->Stroke(); 

?>