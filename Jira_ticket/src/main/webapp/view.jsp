<%@page import="java.awt.Button"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pojo.Jira"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 1rem 2rem;
	text-align: center;
	border-bottom: 1px solid #ddd;
}

th {
	font-weight: normal;
	font-size: .875rem;
	color: #666;
	background: #eee;
	position: sticky;
	top: 2;
}

img {
	width: 80px;
	display: block;
	margin: 0 auto;
	margin-bottom: .5rem;
}

@media ( max-width : 500px) {
	.heading {
		display: none;
	}
	td {
		display: block;
	}
	.car-name {
		background: #eee;
	}
}

h1 {
	text-align: center;
	font-size: 2.5rem;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String tableDetails = "";

	ArrayList<Jira> J = (ArrayList<Jira>) request.getAttribute("Jiraticket");

	for (Jira jira : J) {
		tableDetails = tableDetails + "<tr>	" + "<td>" + jira.getId() + "</td>" + " <td>" + jira.getAssignee() + "</td>"
				+ " <td>" + jira.getReporter() + "</td>" + " <td>" + jira.getHead() + "</td>" + "<td>" + jira.getStatus()
				+ "</td> " + "<button type=\"button\"><a href=\"Edit?id="  +jira.getId()+"\" class=\"text-link\" >Edit</a></button>"
				+ "<br><br>" + "<button type=\"button\"><a href=\"delete?id="+jira.getId()+"\" class=\"text-link\">Delete</a></button>";
}
	%>
	<div class="table-reponsive box">
		<table id="example" class="table table-striped table-bordered">
			<thead>
			<% 
			String message ="";
			if(request.getAttribute("message")!=null){
			out.print(request.getAttribute("message"));} %>
				<tr>
					<th>ID</th>
					<th>Assignee</th>
					<th>Reporter</th>
					<th>Problem</th>
					<th>Status</th>
					<th >Option</th>
				</tr>
			</thead>
			<tbody>

				<%=tableDetails%>


			</tbody>
			
		</table>
	</div>
</body>
</html>