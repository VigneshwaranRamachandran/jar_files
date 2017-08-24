package com.full;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class SearchServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		resp.setContentType("text/plain");
//		resp.getWriter().println("Hello, world");
		String searchId = req.getParameter("searchId");
		boolean flag=User.search(searchId);
		System.out.println(flag);
		List <Message1> messageList= User.getMessageList();
		//System.out.println(messageList);
		if(flag){
			System.out.println(searchId);
			resp.setContentType("application/json");
			req.setAttribute("messageList", messageList);
	         resp.getWriter().write(searchId);
		}
//		else{
//			 resp.setContentType("application/json");
//	         resp.getWriter().write("file not found");
//		}
	}

	//-for test case purpose only....
		public boolean searchValidate(String searchId) {
			if(searchId==null||searchId==""||searchId==" ")
			{
			return false;
		}
			else{
				
			}
			return true;
		
		}
		}
