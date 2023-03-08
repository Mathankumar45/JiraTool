package create;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import helper.Helper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Create_ticket extends HttpServlet {
	//public static void createticket() {
		//Scanner sc=new Scanner(System.in);
		
		//ArrayList<Create_ticket> al=new ArrayList<>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		//String resid=req.getParameter("id");
		String resAssinee=req.getParameter("assignee");
		String resrepoter=req.getParameter("reportee");
		String resheading=req.getParameter("heading");
		String resstatus=req.getParameter("status");
		String resnotify=req.getParameter("Notify");
		
		boolean result=Helper.createticket(resAssinee,resrepoter,resheading,resstatus,resnotify);
		
		RequestDispatcher rd=req.getRequestDispatcher("/showDetails");
		
		if(result) {
			req.setAttribute("msg", "successfully created please go back to Home page!");
		pw.print("succuss");
		
		}
		else {
			req.setAttribute("msg", "somthing went wrong!");
		
			pw.print("faild");
		}
		rd.forward(req, resp);
	}
		
	
		
		
		
	}


