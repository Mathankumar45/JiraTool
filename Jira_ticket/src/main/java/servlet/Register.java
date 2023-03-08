package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import helper.Helper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Register extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		PrintWriter pw=resp.getWriter();
		
		String firstname=req.getParameter("firstname");
		String lastname=req.getParameter("Lastname");
		String mobile=req.getParameter("Mobile");
		String email=req.getParameter("Email");
		String password=req.getParameter("password");
		
		boolean result=Helper.InsertUser(firstname,lastname,mobile,email,password);
		
		if(result)
			pw.print("Register succus"+ firstname);
		else
			pw.print("somthing wrong");
		
	}

}
