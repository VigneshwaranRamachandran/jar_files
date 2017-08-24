package com.Junit.src.testcase;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.full.LoginServlet;
import com.full.User;
import com.google.appengine.api.datastore.DatastoreService;

import junit.framework.TestCase;

public class LoginMockTestcase extends TestCase{
	
	@Mock
	 HttpServletRequest request;
	 @Mock
	 HttpServletResponse response;
	 @Mock
	 HttpSession session;
	 @Mock
	 RequestDispatcher rd;
	@Mock
	  LoginServlet loginServlet;
	@InjectMocks
	  User user; 
	@Inject
	 DatastoreService ds;
	 @Before
	 protected void setUp() throws Exception {
	  MockitoAnnotations.initMocks(this);
	 
	 }
	
	
	@Test
	public void test() {
		LoginServlet l=new LoginServlet();
		assertEquals("success",l.loginValidate("l","v"));
		assertEquals("success",l.loginValidate(" "," "));
		assertEquals("fail",l.loginValidate(null,null));
		assertEquals("fail",l.loginValidate(" ",null));
		assertEquals("fail",l.loginValidate(null," "));
		}
	
	
	@SuppressWarnings("static-access")
	@Test
	 public void test1() throws Exception{
		 loginServlet.doGet(request, response);
		 when(request.getParameter("loginUsername")).thenReturn("vicky1");
		  when(request.getParameter("loginPassword")).thenReturn("vicky1");
		  when(request.getRequestDispatcher("/home.jsp")).thenReturn(rd); 
		  
		// user.loginUser("vicky1","vicky1");
		  loginServlet.loginValidate("LuserName", "LuserPassword");
		  Assert.assertEquals((request.getParameter("loginUsername")),"vicky1");
		  Assert.assertEquals((request.getParameter("loginPassword")),"vicky1");
		  Assert.assertEquals(request.getRequestDispatcher("/home.jsp"),rd); 
		 verify(loginServlet,times(1)).doGet(request,response); 
		 verify(loginServlet,times(1)).loginValidate("LuserName", "LuserPassword"); 
			}
	
}
