package servlet;

import java.io.IOException;

import helper.Helper;
import helper.Mailhelper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Update extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id")) ;
		String Assignee=req.getParameter("assignee");
		String Repoter=req.getParameter("reportee");
		String Heading=req.getParameter("heading");
		String Status=req.getParameter("status");
		String Notify=req.getParameter("Notify");
		
		boolean sendEmail=false;
				if(("Dev Done").equalsIgnoreCase(Status))
			sendEmail=true;
		
		if(sendEmail) {
			System.out.println("inside mail block");
			Mailhelper.sendEmailForNotifyMailId(id,Notify);
			}
		
		boolean result=Helper.edit(Assignee,Repoter,Heading,Status,Notify,id);
		
		RequestDispatcher rs=null;
		rs=req.getRequestDispatcher("/Viewticket");
		
		
		
		if(result) {
			req.setAttribute("msg", "Succuss");
		}
		else
			req.setAttribute("msg", "Wrong");
		
		    rs.include(req, resp);
	}

}
