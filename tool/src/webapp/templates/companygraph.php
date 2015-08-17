<?php 
include ( "../../include/jpgraph/jpgraph.php"); 
include ("../../include/jpgraph/jpgraph_line.php");
include ("../../include/jpgraph/jpgraph_bar.php");
include ("../../init.inc");



sharedbopen();


#echo  "select extract(epoch from max(inserttimestamp)) from closingprices where cid=".$_GET['cid'];
			$pgdata=pg_query($shareconn,"select extract(epoch from max(inserttimestamp)) from closingprices where cid=".$_GET['cid']." and inserttimestamp>date(now()- interval '".$_GET['months']." months')");
			$maxdate=pg_fetch_result($pgdata,0,0);
			$pgdata=pg_query($shareconn,"select extract( epoch from min(inserttimestamp)) from closingprices where cid=".$_GET['cid']." and inserttimestamp>date(now()- interval '".$_GET['months']." months')");
			$mindate=pg_fetch_result($pgdata,0,0);
$sql="Select * from closingprices where cid=".$_GET['cid']." and inserttimestamp>date(now()- interval '".$_GET['months']." months')";
$pgdata=pg_query($shareconn,$sql);
#echo $sql;

  			




    
// Some data 
for ($i=0;$i<pg_numrows($pgdata);$i++) {

$xdata[]=pg_fetch_result($pgdata,$i,"inserttimestamp");
$ydata[]=pg_fetch_result($pgdata,$i,"ruling_price");
 


}
#print count($ydata);

#$ydata = array(11,3, 8,12,5 ,1,9, 13,5,7 ); 



// Create the graph. These two calls are always required 
$graph = new Graph(600,250,"auto");     
$graph->SetScale( "textlin"); 
$graph ->SetMargin(30,140,40,70);


$graph ->title->Set( 'Share price for '.pg_fetch_result($pgdata,0,'alpha_code'));

$graph->xaxis-> SetTickLabels( $xdata);
$graph->xaxis-> SetTextLabelInterval(30);
$graph->xaxis-> SetLabelAngle(90);



$bplot = new linePlot($ydata);
#$bplot ->SetFillColor ("blue"); 
$bplot -> SetLegend("Logins");



$graph ->legend->Pos( 0.05,0.5,"right" ,"center");
#$gbplot = new GroupBarPlot (array($bplot ,$bplot2,$bplot3,$bplot4,$bplot5,$bplot6,$bplot7)); 
$graph->Add( $bplot); 

// Display the graph 
$graph->Stroke(); 


dbclose();
agdbclose();
?> 
