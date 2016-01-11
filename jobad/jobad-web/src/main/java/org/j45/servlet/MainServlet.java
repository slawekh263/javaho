package org.j45.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/* @EJB
	private CurrentTimeLocal ctl;
	*/

	@Override
	public void doGet(HttpServletRequest request, 
	         HttpServletResponse response)
	        throws ServletException, IOException
	  {
		   response.setContentType("text/html");
		   PrintWriter out = response.getWriter();
		   out.println("<body><div>Hello my name is Duke (Enterprise)</div>< br/>");
		   out.println("<div>And current time is: " + System.currentTimeMillis() + "</div>");
		   out.println("</div>");
		   
		   out.close();
	  }

}
