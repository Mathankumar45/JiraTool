<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Login.css"> 
<title>Login</title>
</head>
<body>

<% String message="";
	if(request.getAttribute("username") != null)
		message=(String)request.getAttribute("username");
%>


<form action="/Jira_ticket/Login" method="get">
  <h1>Employer Log in</h1>
  <div class="inset">
  <p>
    <label for="email">EMAIL ADDRESS</label>
    <input type="text" name="email" id="email">
  </p>
  <p>
    <label for="password">PASSWORD</label>
    <input type="password" name="passWordd" id="password">
    
    <button type="submit">Login</button>
  </p>
  <p>
    <input type="checkbox" name="remember" id="remember">
    <label for="remember">Remember me for 14 days</label>
  </p>
  </div>
  <p class="p-container">
    <a href="Register.jsp">Register</a>
  </p>
</form>

</head>     
</body>
</html>