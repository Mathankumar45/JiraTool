<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="create.css">
<title>Create Ticket</title>
</head>
<body>
<% String message="";
	if(request.getAttribute("msg") != null){
		message=(String)request.getAttribute("msg");
		message=message+"<br><a href=\"Home\" class=\"text-link\">home</a>";
	
	}
%>
<!--  
<%
String url="";
ArrayList<String> user=new ArrayList<String>();

user=(ArrayList<String>)request.getAttribute("user");

for(String str:user){
	url=url+"<option>"+str+"</option>";
}
%>
-->


<form action="/Jira_ticket/Create_ticket" method="get">

<h1>Create new ticket</h1>
<h3><%= message %></h3>

<label >Assignee:</label>
<select name="assignee" class="email2">
  <%=url %>


</select><br><br> 
<label>Reporter:</label>
<select name="reportee" class="email2">
<%=url %>
</select> <br><br>


<label>Heading:</label>
<input type="text" name="heading" placeholder="Enter Heading"><br><br>


<label for="status">status</label>

<select id="status" name="status">
  <option value="Do-To">Do-To</option>
  <option value="Analysis">Analysis</option>
  <option value="testing">Testing</option>
  <option value="Don" selected>Done</option>
</select>
<br><br>

<label>Notify:</label>
<input type="text" name="Notify" placeholder="Enter Notify"><br><br>
<%= url %>

<button type="submit" style="color: blue;">Create</button>
</form>
</body>
</html>