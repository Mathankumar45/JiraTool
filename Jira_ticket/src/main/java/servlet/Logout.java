package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Logout extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie [] coo= req.getCookies();
		 Cookie cokk=null;
		 boolean result = false;
		 
		 for(Cookie cookie : coo) {
			 
			 if(cookie.getName().equals("uname"));
			 
			 cokk=cookie;
			 result=true;
			 break;
		 }
		cokk.setMaxAge(0);
		resp.addCookie(cokk);
		//RequestDispatcher rq= null;
		
		if(result) {
			RequestDispatcher rq=req.getRequestDispatcher("Login.jsp");
			rq.forward(req, resp);
			
			
	}
	}
	
	
	
	
}
