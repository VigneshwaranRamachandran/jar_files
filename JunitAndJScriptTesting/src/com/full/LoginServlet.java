package com.full;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//System.out.println("inside");
		boolean flag;
		RequestDispatcher dispatcher;
		String LuserName = req.getParameter("loginUsername");
		String LuserPassword = req.getParameter("loginPassword");
		if(LuserName!=null||LuserName!=""||LuserPassword!=null||LuserPassword!=""){
		flag = User.loginUser(LuserName,LuserPassword);
		List <Message1> messageList= User.getMessageList();
		//messageList= User.getMessageList();
		if (flag) {
			dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			req.setAttribute("messageList", messageList);
			dispatcher.forward(req, resp);
		} else {
			dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(req, resp);
		}
		}
	}
	//-for test case purpose only....
	public String loginValidate(String LuserName, String LuserPassword) {
		if(LuserName==null||LuserName==""||LuserPassword==null||LuserPassword=="")
		{
		return "fail";
	}
		else{
			
		}
		return "success";
	
	}
}
