package com.full;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean signupValidate;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher;
		boolean flag;
		String SuserName = req.getParameter("SuserName");
		String SuserPassword = req.getParameter("SuserPassword");
		 if(SuserName!=null || SuserName!="" || SuserPassword!=null || SuserPassword!=""){
		 flag = User.createUpdateUser(SuserName, SuserPassword);
		if (flag) {
			dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(req, resp);
		} else {
			dispatcher = getServletContext().getRequestDispatcher("/signup.jsp");
			dispatcher.forward(req, resp);
		}
		 }
	}
	//-for test case purpose only....
	public String signupValidate(String SuserName,String SuserPassword) {
	
		if(SuserName==null || SuserName=="" || SuserPassword==null || SuserPassword==""){
			return "fail";
		}
		else{
			return"success";
			}
		
}
}