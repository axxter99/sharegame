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