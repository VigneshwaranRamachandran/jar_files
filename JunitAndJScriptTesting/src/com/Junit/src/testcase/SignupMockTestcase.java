package com.Junit.src.testcase;

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
import static org.mockito.Mockito.*;
import com.full.LoginServlet;
import com.full.SignupServlet;
import com.full.User;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;

import junit.framework.TestCase;
import static com.google.appengine.api.datastore.FetchOptions.Builder.withLimit;
import static org.junit.Assert.assertEquals;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
//import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
//import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SignupMockTestcase extends TestCase{
	
	@Mock
	 HttpServletRequest request;
	 @Mock
	 HttpServletResponse response;
	 @Mock
	 HttpSession session;
	 @Mock
	 RequestDispatcher rd;
	@Mock
	  SignupServlet signupServlet;
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
		SignupServlet l=new SignupServlet();
		assertEquals("success",l.signupValidate("l","v"));
		assertEquals("success",l.signupValidate(" "," "));
		assertEquals("fail",l.signupValidate(null,null));
		assertEquals("fail",l.signupValidate(" ",null));
		assertEquals("fail",l.signupValidate(null," "));
		}
	
	
	@SuppressWarnings("static-access")
	@Test
	 public void test1() throws Exception{
		signupServlet.doGet(request, response);
		 when(request.getParameter("loginUsername")).thenReturn("vicky1");
		  when(request.getParameter("loginPassword")).thenReturn("vicky1");
		  when(request.getRequestDispatcher("/home.jsp")).thenReturn(rd); 
		//user.loginUser("vicky1","vicky1");
		  signupServlet.signupValidate("LuserName", "LuserPassword");
		  Assert.assertEquals((request.getParameter("loginUsername")),"vicky1");
		  Assert.assertEquals((request.getParameter("loginPassword")),"vicky1");
		  Assert.assertEquals(request.getRequestDispatcher("/home.jsp"),rd); 
		 verify(signupServlet,times(1)).doGet(request,response); 
		 verify(signupServlet,times(1)).signupValidate("LuserName", "LuserPassword"); 
			}
	
}
