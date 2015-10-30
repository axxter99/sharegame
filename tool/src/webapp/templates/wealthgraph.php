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
<?php 
include ( "../../include/jpgraph/jpgraph.php"); 
include ("../../include/jpgraph/jpgraph_line.php");
include ("../../include/jpgraph/jpgraph_bar.php");
include ("../../init.inc");



sharedbopen();


#echo  "select extract(epoch from max(inserttimestamp)) from closingprices where cid=".$_GET['cid'];
			$pgdata=pg_query($shareconn,"select extract(epoch from max(date_run)) from wealth_daily where date_run>date(now()- interval '".$_GET['months']." months')");
#echo "select extract(epoch from max(date_run)) from wealth_daily where date_run>date(now()- interval '".$_GET['months']." months')";
			$maxdate=pg_fetch_result($pgdata,0,0);
			$pgdata=pg_query($shareconn,"select extract( epoch from min(date_run)) from wealth_daily where date_run>date(now()- interval '".$_GET['months']." months')");
			$mindate=pg_fetch_result($pgdata,0,0);
$sql="Select date_run,avg(wealth) from wealth_daily where date_run>date(now()-interval '".$_GET['months']." months')  group by date_run";
$pgdata=pg_query($shareconn,$sql);
#echo "qwerty".$sql;

  			




    
// Some data 
for ($i=0;$i<pg_numrows($pgdata);$i++) {
#for ($i=0;$i<100;$i++) {

$xdata[]=pg_fetch_result($pgdata,$i,"date_run");
$ydata[]=pg_fetch_result($pgdata,$i,1);
#$q[]=pg_fetch_result($pgdata,$i,10); 


}
#print count($ydata);

#$ydata = array(11,3, 8,12,5 ,1,9, 13,5,7 ); 



// Create the graph. These two calls are always required 
$graph = new Graph(600,250,"auto");     
$graph->SetScale( "textlin"); 
$graph ->SetMargin(30,140,40,70);


$graph ->title->Set( 'Average wealth of class');

$graph->xaxis-> SetTickLabels( $xdata);
$graph->xaxis-> SetTextLabelInterval(30);
$graph->xaxis-> SetLabelAngle(90);



$bplot = new linePlot($ydata);
#$bplot ->SetFillColor ("blue"); 
#bplot -> SetLegend("Logins");



$graph ->legend->Pos( 0.05,0.5,"right" ,"center");
#$gbplot = new GroupBarPlot (array($bplot ,$bplot2,$bplot3,$bplot4,$bplot5,$bplot6,$bplot7)); 
$graph->Add($bplot); 

// Display the graph 
$graph->Stroke(); 


?>