<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<title>Note Making</title>
<meta name="viewport"
	content="width = device-width, initial-scale = 1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="js/app-ajax.js" type="text/javascript"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.js"
	type="text/javascript"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/mustache.js/2.3.0/mustache.min.js" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
</head>
<style>
#myDIV {
	height: 250px;
	width: 250px;
	overflow: auto;
	background-color:white;
	border: 1px solid #d8d8d8;
}
	#content {
	height: 800px;
	width: 300px;
	}
	#trans{
	height: 150px;
	background-color:white;
	border: 1px solid #d8d8d8;
	width: 350px;
	}
body{
  background-color: rgb(245,245,255);
    
    
}
</style>
<script>
function fontcolor()
{
  var fontcolor=document.getElementById("fontcolor1").value;
  document.getElementById("labelvalue").style.color =fontcolor;
  //background-image:linear-gradient(to bottom, rgba(0,0,0,0.2) 0%,rgba(0,0,0,0.1) 100%), url(/download.jpg);
}


function bgcolor() {
var color=document.getElementById("color1").value;
document.getElementById("labelvalue").style.backgroundColor =color;
}
</script>
<script>
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $interval) {
  $scope.theTime = new Date().toLocaleTimeString();
  $interval(function () {
      $scope.theTime = new Date().toLocaleTimeString();
  }, 1000);
});
</script>
<body ng-app="myApp" ng-controller="myCtrl">
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<a href="#" class="navbar-brand text-center">Note Making</a>
		</div>
	</nav>
                     
	<div class="container">
		
		
			<br><br><br>
				BgColor:
				<input type="color" name="bgcolor" id="color1"
					onchange="bgcolor();">   <center><b>{{theTime}}</b></center><br>
				 FontColor:
			<input type="color" name="fontcolor" id="fontcolor1"
					onchange="fontcolor();">
			
			
		
		<div class="row">
			<div class="col-lg-8 col-md-8 col-sm-5">
				<div class="customDiv2">
					<div  >

                        <input style="background-color:{{myCol}}" ng-model="myCol" value="{{myCol}}"><br>
						<b>Enter Your File Name:</b><input type="text" name="label" id="labelId"><br> <label>Enter Your message:</label>
						<textarea  style="background-color:{{myCol}}" rows="18" class="form-control" name="message"id="labelvalue"></textarea>
						</div><table><tr><input type="submit" value="save" id="save"/>
						<form>
						<input style="color:green;"type="reset" value="reset" /></tr> 
					</form>
					</table>
				</div>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-5">
				<input type="text" name="search" id="searchId"> 
				<input type="submit" ng-model="test" value="searching" id="searching" /><br>
				<div id="myDIV">
					<div id="content">
						<%@ include file="include.jsp" %>  
					</div>
				</div>
				<div id="popup_div">
					<div id="responseContent"> Your Do List: </div>
					<button id="btnClose">Close</button>
				</div>
				<div id="popup_div2">
					<div id="fileName"></div>
					<button id="btnClose">Close</button>
				</div>
			</div>
		
			<script id="personTpl" type="text/template">
					<div id="responseContent"> Your Do List:{{html}} </div>
</script>
			<script>
					$(function() {
						$("#popup_div").dialog({
							autoOpen : false
						});
	
						$("#popup_div").on('click', '#btnClose', function() {
							$("#popup_div").dialog("close");
						});
					});
					function myFunction() {
						var mainVal = document.getElementById("content").innerHTML;
						var btn = document.createElement("BUTTON");
						var n = document.getElementById("labelId").value;
						var t = document.createTextNode(n);
						btn.appendChild(t);
						document.body.appendChild(btn);
						btn = mainVal + "<br>" + btn + "<br>";
						document.getElementById("content").innerHTML = btn;

					}
					function showValue(label) {
						//alert(label);
						//$("#content").load();

						//alert(label);
						$.get('UserData',
								{
							label : label
						},
								function(jsonInString) {
							 //var Json=JSON.parse(jsonInString);
							//var Json=JSON.Stringify(jsonInString)
									//alert(jsonInString);
									//console.log(Json);
									//$('#responseContent').text(Json);
									$('#responseContent').text(jsonInString.message);
									//var template = $("#personTpl").html();
									//alert(template);
									//var html = Mustache.render(template,jsonInString);
									//var html = Mustache.to_html(template,jsonInString);
									//alert(template);
									//alert(jsonInString);
									//alert(html);
									//$("#responseContent").html(html);
									$("#popup_div").dialog("open");
								});
					}
					
					</script>
					<script>
					$(document).ready(function(){
					   $("#delete").click(function(){
					    	
					    	var retVal = prompt("Enter your file_name to delete: ");
					    	 alert(retVal);
					    	 if(retVal==null||retVal==""){
					    		 alert("File Name Must");
					    	 }
					    	 else{
					    		 
					    	 
					    	 $.ajax({
					    		   url: 'DeleteData?retVal='+retVal,
					    		   type: 'DELETE',
					    		   data: {retVal:retVal}, 
					    		    contentType:'application/json',  
					    		   dataType: 'text',                
					    		    success: function(JsonValue) {
					    		    	alert(JsonValue);
					    		    	$('#content').load('IncludeServlet',function(messageList){
					    					//alert(messageList);
					    					
					    				});
					    		    }
					    		    
					    		});
					    	 }
					    	 $('#content').load('IncludeServlet',function(messageList){
		    					});
					  });
					    	 });
					 </script>
					 <script>
					$(document).ready(function(){
					   $("#save").click(function(){
						   var label=$("#labelId").val();
							var message=$("#labelvalue").val();
							if(label==null||label==""){
					    		alert("File Name must");
					    	}
							else{
					    	 $.ajax({
								
					    		 url: 'MessageServlet?label='+label+'&message='+message,
					    		   type: 'GET',
					    		   data: {label:label,message:message}, 
					    		    contentType:'application/json',  
					    		   dataType: 'text',                
					    		    success: function(JsonValue) {
					    		    	alert(JsonValue);
					    		    	$('#content').load('IncludeServlet',function(messageList){
					    					//alert(messageList);
					    					
					    					
					    				});
					    		    }
					    		    
					    		});
					    	 $("#labelId").val(" ");
					    	 $("#labelvalue").val(" ");
							}
					    	 $('#content').load('IncludeServlet',function(messageList){
			    					});
					  });
					    	 });
					 </script>
					 <script>
					 $(document).ready(function(){
						   $("#updating").click(function(){
						    	var updateFile = prompt("Enter your file_name to update: ");
						    	var updateContent=prompt("Enter the content: ");
						    	//alert(updateFile);
						    	//alert(updateContent);
						    	if(updateFile==null||updateFile==""){
						    		alert("File Name must");
						    	}
						    	else{
						    	 $.ajax({
						    		   url: 'UpdateData?updateFile='+updateFile+'&updateContent='+updateContent,
						    		   type: 'PUT',
						    		   data: {updateFile:updateFile}, 
						    		    contentType:'application/json',  
						    		   dataType: 'text',                
						    		    success: function(result) {
												alert(result);
						    		    	$('#content').load('IncludeServlet',function(messageList){
						    					//alert(messageList);
						    					
						    				});
						    		    }
						    		    
						    		});
						    	}
						    	 $('#content').load('IncludeServlet',function(messageList){
			    					});
						   });
					 });
						    	
						    	
					 </script>
					 <script>
					
						 $(function() {
								$("#popup_div2").dialog({
									autoOpen : false
								});
			
								$("#popup_div2").on('click', '#btnClose', function() {
									$("#popup_div2").dialog("close");
								});
							});
						 $("#searching").click(function(){
							 var searchId=$("#searchId").val();
							 alert(searchId);
							 if(searchId==null||searchId==""){
						    		alert("File Name must");
						    	}
							 else{
							 $.ajax({
								 url: 'SearchServlet?searchId='+searchId,
								 type: 'GET',
								 data: {searchId:searchId},
								 contentType:'application/json',
								 dataType:'text',
								 success: function(data){
									 alert(data);
									 $('#fileName').text(data);
									 $('#fileName').append("<a style='float:right' target='_blank' href='UserData?label=data'>open</a>");
									// $('#fileName').append("<a style='float:right' target='_blank' href='UserData?label'>open</a>");
									 $('#fileName').append("<input style='float:right' type='button' value='open' id='openId'/>");
									 // $('#fileName').wrap('<a href="'+UserData?label=data+'">open</a>');
									// $('#fileName').text(<table>);
									// $('#fileName').text(<td>data</td>);
									// $('#fileName').text(<td><input type="button" value="open" id="openFile"/></td></table>);
								
									 $("#popup_div2").dialog("open");									 
								 }
							 });
							 
								$("#searchId").val(" ");
							 }
						 });
					
					 </script>

 <script>
					 $(document).ready(function(){
						   $("#edit").click(function(){
						    	var editFile = prompt("Enter your file_name to update: ");
						    	//var updateContent=prompt("Enter the content: ");
						    	//alert(updateFile);
						    	//alert(updateContent);
						    	if(editFile==null||editFile==""){
						    		alert("File Name must");
						    	}
						    	else{
						    	 $.ajax({
						    		   url: 'EditData?editFile='+editFile,
						    		   type: 'PUT',
						    		   data: {editFile:editFile}, 
						    		    contentType:'application/json',  
						    		   dataType: 'text',                
						    		    success: function(result) {
												//alert(result.editMessage);
												alert(result);
												 $("#labelId").val(editFile);
					    						 $("#labelvalue").val(result);
						    		    	
						    					
						    				}
						    		    });
						    	}
						    		});
						    	
						   });
					
						    	
						    	
					 </script>
					 
					 
 <script>
					 $(document).ready(function(){
						   $("#refreshing").click(function(){
						    	
							   $('#content').load('IncludeServlet',function(messageList){
		    					});
						    		    
						    		});
						    	
						   });
					
						    	
						    	
					 </script>
 <script>
					 $(document).ready(function(){
						   $("#download").click(function(){
							   var downloadFile = prompt("Enter your file_name to download: ");
							   $.ajax({
					    		   url: 'DownloadData?downloadFile='+downloadFile,
					    		   type: 'GET',
					    		   data: {downloadFile:downloadFile}, 
					    		    contentType:'application/json',  
					    		   dataType: 'text',                
					    		    success: function(result) {
											//alert(result.editMessage);
											//alert(result);
											 //$("#labelId").val(editFile);
				    						// $("#labelvalue").val(result);
					    		    	
					    					
					    				}
					    		    });
						    		    
						    		});
						    	
						   });
					
						    	
						    	
					 </script>
			
<script>
function showEdit(label){
	alert("edit: "+label);
	 $.ajax({
		   url: 'EditData?editFile='+label,
		   type: 'PUT',
		   data: {editFile:label}, 
		    contentType:'application/json',  
		   dataType: 'text',                
		    success: function(result) {
					//alert(result.editMessage);
					alert(result);
					//alert(result.editMessage);
					alert(result.length);
					 $("#labelId").val(label);
					 $("#labelvalue").val(result);
		    	
					
				}
		    });
}
function showDelete(label){
	alert("delete: "+label);
	 var r = confirm("Press ok for delete");
	    if (r == true) {
	       	 $.ajax({
		   url: 'DeleteData?retVal='+label,
		   type: 'DELETE',
		   data: {retVal:label}, 
		    contentType:'application/json',  
		   dataType: 'text',                
		    success: function(JsonValue) {
		    	alert(JsonValue);
		    	$('#content').load('IncludeServlet',function(messageList){
					//alert(messageList);
					
				});
		    }
		    
		});
}
else
	{
	$('#content').load('IncludeServlet',function(messageList){
		//alert(messageList);
		
	});
	}
}
</script>

<script>
$(document).ready(function(){
    $("#labelvalue").keyup(function(){
    	//alert("keyup");
    	var a=$("#labelvalue").val();
    	var languageName=  $("#languageName option:selected").text()
    	//alert(languageName);
    	$.ajax({
        		   url: 'TranslateServlettest?translateValue='+a+'&languageName='+languageName,
        		   type: 'GET',
        		   data: {translateValue:a}, 
        		    contentType:'application/json',  
        		   dataType: 'text',                
        		    success: function(result) {
        					$("#trans").text(result);
        		    	
        					
        				}
        		    });
    	
    	
    	});
        });
  
</script>

			<br><br> <input type="button" value="Refresh" id="refreshing" /> 
			 <input type="button" value="updating" id="updating" /> 
			
			<input type="button" value="delete" id="delete" />
		<input type="button" value="edit" id="edit" /> 
				<input type="button" value="download" id="download" /><br>
			<medium style="color:brown">Translate to:</medium>	<select id="languageName">
<option value="1">Tamil</option>
<option value="2">French</option>

</select>
				<div id="trans" style="float:right">
				
				</div>
				
		</div>
		
	</div>
	
	<div class="customDiv4">
		<a href="homemain.html"><button class="btn btn-link pull-right" type="submit">Logout <span class="glyphicon glyphicon-share"></span>
			</button>
			</a>
	</div>


</body>
</html>