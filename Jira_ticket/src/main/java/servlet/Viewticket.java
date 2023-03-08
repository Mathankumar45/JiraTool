package servlet;

import java.io.IOException;
import java.util.ArrayList;

import helper.Helper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Jira;

public class Viewticket extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		ArrayList<Jira> al=Helper.Viewallticket();
		
		req.setAttribute("Jiraticket", al);
		
		RequestDispatcher rs=req.getRequestDispatcher("view.jsp");
		
		rs.forward(req, resp);
		
	}

}
