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
import com.full.UpdateData;
import com.full.User;
import com.google.appengine.api.datastore.DatastoreService;

import junit.framework.TestCase;

public class UpdateMockTestcase extends TestCase{
	
	@Mock
	 HttpServletRequest request;
	 @Mock
	 HttpServletResponse response;
	 @Mock
	 HttpSession session;
	 @Mock
	 RequestDispatcher rd;
	@Mock
	UpdateData update;
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
		UpdateData m=new UpdateData();
		assertTrue(m.UpdateValidate("ev"));
		assertFalse(m.UpdateValidate(" "));
		assertFalse(m.UpdateValidate(null));
		assertFalse(m.UpdateValidate(""));
		}
	
	
	@Test
	 public void test1() throws Exception{
		update.doPut(request, response);
		 when(request.getParameter("updateFile")).thenReturn("vicky"); 
		 when(request.getParameter("updateContent")).thenReturn("hi am vicky"); 
		//user.userUpdate("vicky",hi am vicky);
		  update.UpdateValidate("vicky");
		  Assert.assertEquals((request.getParameter("updateFile")),"vicky");
		  Assert.assertEquals((request.getParameter("updateContent")),"hi am vicky");
		 verify(update,times(1)).doPut(request,response); 
		 verify(update,times(1)).UpdateValidate("vicky"); 
			}
	
}
