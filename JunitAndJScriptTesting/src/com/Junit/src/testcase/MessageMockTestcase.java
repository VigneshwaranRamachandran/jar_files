package com.Junit.src.testcase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.full.DeleteData;
import com.full.MessageServlet;
import com.full.User;
import com.google.appengine.api.datastore.DatastoreService;

import junit.framework.TestCase;

public class MessageMockTestcase extends TestCase{
	
	@Mock
	 HttpServletRequest request;
	 @Mock
	 HttpServletResponse response;
	 @Mock
	 HttpSession session;
	 @Mock
	 RequestDispatcher rd;
	@Mock
	MessageServlet message;
	@Mock
	  User user; 
	@Mock
	 DatastoreService ds;
	 @Before
	 protected void setUp() throws Exception {
	  MockitoAnnotations.initMocks(this);
	 
	 }
	
	
	@Test
	public void test() {
		MessageServlet m=new MessageServlet();
		assertTrue(m.messageValidate("ev"));
		assertFalse(m.messageValidate(" "));
		assertFalse(m.messageValidate(null));
		assertFalse(m.messageValidate(""));
		}
	
	
	@Test
	 public void test1() throws Exception{
		message.doGet(request, response);
		 when(request.getParameter("label")).thenReturn("vicky"); 
		 when(request.getParameter("message")).thenReturn("hi am vicky"); 
		//user.storeMessage("vicky",hi am vicky);
		  message.messageValidate("vicky");
		  Assert.assertEquals((request.getParameter("label")),"vicky");
		  Assert.assertEquals((request.getParameter("message")),"hi am vicky");
		 verify(message,times(1)).doGet(request,response); 
		 verify(message,times(1)).messageValidate("vicky"); 
			}
	
}
