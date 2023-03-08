package servlet;

import java.io.IOException;
import java.util.ArrayList;

import helper.Helper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Jira;

//@WebServlet ("/Edit")
public class Edit extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		int id=0;
		id=Integer.parseInt( req.getParameter("id"));
		ArrayList<Jira> a1= Helper.Update( id);
		 Jira  ji=a1.get(0);
		 
		 req.setAttribute("Details", ji);
		 ArrayList<String> al=Helper.showmail();
		 
		 req.setAttribute("name", al);
		 RequestDispatcher rq=req.getRequestDispatcher("Update.jsp");
		 rq.forward(req, resp);
	}

}
