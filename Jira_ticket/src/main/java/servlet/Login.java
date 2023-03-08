package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import helper.Helper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Login extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		resp.setContentType("text/html");
		RequestDispatcher rs=null;
		
		PrintWriter pw=resp.getWriter();
		
		String reqname=req.getParameter("email");
		String reqpass=req.getParameter("passWordd");
		String result=Helper.loginUser(reqname,reqpass);
		
	     req.setAttribute("username",result );
	    
		if(result.isEmpty()) {
			rs=req.getRequestDispatcher("Login.jsp");
			pw.print("<h1 style=\"color:red;\">sorry user not found try again!</h1>");
		    rs.include(req, resp);
		    
		}
			
		
		else {
			Cookie coo=new Cookie("uname", result+123);
			resp.addCookie(coo);
			rs=req.getRequestDispatcher("Home.jsp");
			rs.forward(req, resp);
			 
		}
	}
}
