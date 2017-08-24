package com.full;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VideoServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	   
	    public VideoServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	resp.setContentType("text/plain");
	    	System.out.println("success");
	    	//resp.sendRedirect("https://www.youtube.com/watch?v=6PUNuH6gWEM");
	    	 resp.getWriter().write("https://www.youtube.com/watch?v=6PUNuH6gWEM");
	    	 
	    }

}
