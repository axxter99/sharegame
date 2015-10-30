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
7001
South Africa
Email: dhorwitz@its.uct.ac.za
   */
require ("../init.inc");
#require ("../include/db_routines.php");


?>
<HTML>
<HEAD>

<TITLE></TITLE>
</HEAD>
<BODY>
<?
#set flsys = createobject("scripting.filesystemobject")

$student = ("lastmid")
Response.Write student&"<p>"
filepath = "e:\wwwroot\megweb\copy_iresearch\game\studentdata\"&student+".txt"

if flsys.FileExists(filepath) then
set studentfile = flsys.DeleteFile(filepath)
end if

set studentfile = flsys.createtextfile(filepath)


cnn1.Open("DSN=sharetrade_psql")
arecordset.Open ("select * from wealth_daily where mid='"&student&"'"),cnn1
'open mid+"txt" for output as #1
studentfile.writeline "Value,Hlabel,color"
while not arecordset.EOF
studentfile.writeline arecordset("wealth")&","&arecordset("date_run")&",Red"
Response.Write arecordset("wealth")&"<br>"
 
arecordset.MoveNext
wend
arecordset.Close

studentfile.close
cnn1.Close


%>
<P>&nbsp;</P>

</BODY>
</HTML>
