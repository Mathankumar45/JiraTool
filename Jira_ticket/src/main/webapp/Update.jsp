<%@page import="pojo.Jira"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Update.css">
<title>Edit Ticket</title>
</head>
<body>
<% 
String message="";
if(request.getAttribute("msg")!=null){
	message=(String)request.getAttribute("msg");
	message=message +"<a href=\"Home\" class=\"text-link\">home</a>";
}

Jira j=(Jira)request.getAttribute("Details");
	int id=j.getId();
	String assignee=j.getAssignee();
	String repoter=j.getReporter();
	String heading=j.getHead();
	String status=j.getStatus();
	String notify=j.getNotify();
	
	String usl="";
	ArrayList<String> ul=new ArrayList<String>();
	ul=(ArrayList<String>)request.getAttribute("name");
	
	for(String str : ul){
		usl=usl+"<option>"+str+"</option>";
	}
%>

	

<form method="get" action="/Jira_ticket/Update">
<div class="box">
<h1>Update ticket</h1>
<h3><%= message %></h3>
<input type="hidden" name="id" value="<%= id %>">

<label>Assignee:</label>
<select name="assignee" class="email2">
<%= usl %>
</select> 

<label>Reporter:</label>
<select name="reportee" class="email2">
<%= usl %>
</select> 

<label >Problem:</label>
<input type="text" value="<%= heading %>" name="problem" placeholder="Problem Description" onFocus="field_focus(this, 'email');" onblur="field_blur(this, 'email');" class="email" required="required"/>
<br><br>


<label >Status:</label>
<select name="status" id="status" class="email2">
  <option name="Do-To" >Do-To</option>
  <option name="Analysis">Analysis</option>
  <option name="testing">testing</option>
    <option name="Done">Done</option>
</select>

<label >Notify:</label>
<select name="notify" class="email2">
<%= usl %>
</select> 


<button class="btn" type="submit">Update</button> 


  
</div> <!-- End Box -->
  
</form>
</body>
</html>