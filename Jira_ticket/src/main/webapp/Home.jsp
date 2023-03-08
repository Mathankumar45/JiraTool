<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Home.css">
<title>Home</title>
<body>

<h1>Welcome To Jira</h1>
<ul>
  <li><a class="text-link -active" href="showDetails">Create Ticket</a></li>
  <li><a href="Viewticket">View Ticket</a></li>
  <li><a href="contact.jsp">Contact us</a></li>
  <li><a href="Logout">Logout <% out.print(request.getAttribute("username")); %></a></li>
</ul>
</head>
</body>
</html>


