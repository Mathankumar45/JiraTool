package servlet;

import java.io.IOException;
import java.util.ArrayList;

import helper.Helper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class showDetails extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		ArrayList<String> al=Helper.showmail();
		req.setAttribute("user",al);
		
		RequestDispatcher db=req.getRequestDispatcher("Create_ticket.jsp");
		db.forward(req, resp);
	}

}
