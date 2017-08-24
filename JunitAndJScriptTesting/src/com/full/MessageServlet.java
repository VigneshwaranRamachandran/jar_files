package com.full;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

public class MessageServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String flag;
		String JsonValue;
		String label = req.getParameter("label");
		String message = req.getParameter("message");
		//flag = User.storeMessage(label, message);
		if(label!=null||label!=""){
		flag = User.storeMessages(label, message);
		List <Message1> messageList= User.getMessageList();
		
//		if (flag) {
//			dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
//			req.setAttribute("messageList", messageList);
//			dispatcher.forward(req, resp);
//		} 
		UsersData usersData = new UsersData();
		usersData.setMessage(flag);
		ObjectMapper mapper = new ObjectMapper();
		JsonValue=mapper.writeValueAsString(usersData);
		req.setAttribute("messageList", messageList);
		 resp.setContentType("application/json");
         resp.getWriter().write(JsonValue);
	}
	}
	//-for test case purpose only....
	public boolean messageValidate(String editFile) {
		if(editFile==null||editFile==""||editFile==" ")
		{
		return false;
	}
		else{
			
		}
		return true;
	
	}
}