package com.Junit.src.testcase;

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
import com.full.User;
import com.full.UserData;
import com.google.appengine.api.datastore.DatastoreService;

import junit.framework.TestCase;

public class UserdataMockTestCase extends TestCase{
	
	@Mock
	 HttpServletRequest request;
	 @Mock
	 HttpServletResponse response;
	 @Mock
	 HttpSession session;
	 @Mock
	 RequestDispatcher rd;
	@Mock
	UserData user;
	 
	@Mock
	 DatastoreService ds;
	 @Before
	 protected void setUp() throws Exception {
	  MockitoAnnotations.initMocks(this);
	 
	 }
	
	
	@Test
	public void test() {
		UserData l=new UserData();
		assertTrue(l.userdataValidate("ev"));
		assertFalse(l.userdataValidate(" "));
		assertFalse(l.userdataValidate(null));
		assertFalse(l.userdataValidate(""));
		}
	
	
	@Test
	 public void test1() throws Exception{
		user.doGet(request, response);
		 when(request.getParameter("label")).thenReturn("vicky"); 
		//user.userDelete("vicky");
		 user.userdataValidate("vicky");
		  Assert.assertEquals((request.getParameter("label")),"vicky");
		 verify(user,times(1)).doGet(request,response); 
		 verify(user,times(1)).userdataValidate("vicky"); 
			}
	
}
