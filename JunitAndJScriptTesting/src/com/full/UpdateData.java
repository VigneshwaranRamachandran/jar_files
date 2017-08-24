package com.full;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;



public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateData() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String flag="";
		String JsonValue;
		String label = req.getParameter("updateFile");
		String message = req.getParameter("updateContent");
		System.out.println(label);
		System.out.println(message);
		if(label!=null||label!=""){
		flag=User.userUpdate(label,message);
		// resp.getWriter().write(flag+" file updated");
		List <Message1> messageList= User.getMessageList();
		UsersData usersData = new UsersData();
		flag=flag+" file updated";
		usersData.setMessage(flag);
		ObjectMapper mapper = new ObjectMapper();
		JsonValue=mapper.writeValueAsString(usersData);
		req.setAttribute("messageList", messageList);
		 resp.setContentType("application/json");
         resp.getWriter().write(JsonValue);
	}
	}
	//-for test case purpose only....
			public boolean UpdateValidate(String label) {
				if(label==null||label==""||label==" ")
				{
				return false;
			}
				else{
					
				}
				return true;
			
			}

}
