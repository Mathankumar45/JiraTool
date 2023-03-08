package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.catalina.ant.jmx.JMXAccessorQueryTask;

import helper.Helper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/delete")
public class Delet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=0;
		resp.setContentType("text/html");
			id=Integer.parseInt(req.getParameter("id")) ;
		String msg="";  //PrintWriter pw = resp.getWriter();
		boolean result=false;
		if(id!=0) 
		result=Helper.deleteid(id);
		   // pw.print("Succus");
			RequestDispatcher rq=req.getRequestDispatcher("/Viewticket");
			if(result)
			msg="Delete succuss";
		else
			msg="plese try again";
		
		   req.setAttribute("message", msg);
		   rq.forward(req,resp);
	}
	
	}

