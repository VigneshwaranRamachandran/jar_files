package com.full;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.util.Properties;  

import javax.mail.*;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  
//@SuppressWarninsgs("serial")
public class JspServletServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/plain");
		//resp.getWriter().println("Hello, world");
		String index = req.getParameter("loginUsername");
		//Properties props = new Properties(); 
		resp.getWriter().println("WELCOME :"+index);
		
	}
}
