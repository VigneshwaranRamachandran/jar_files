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
import com.google.appengine.api.datastore.DatastoreService;

import junit.framework.TestCase;

public class DeleteMockTestcase extends TestCase{
	
	@Mock
	 HttpServletRequest request;
	 @Mock
	 HttpServletResponse response;
	 @Mock
	 HttpSession session;
	 @Mock
	 RequestDispatcher rd;
	@Mock
	DeleteData delete;
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
		DeleteData l=new DeleteData();
		assertTrue(l.deleteValidate("ev"));
		assertFalse(l.deleteValidate(" "));
		assertFalse(l.deleteValidate(null));
		assertFalse(l.deleteValidate(""));
		}
	
	
	@Test
	 public void test1() throws Exception{
		delete.doDelete(request, response);
		 when(request.getParameter("retVal")).thenReturn("vicky"); 
		//user.userDelete("vicky");
		  delete.deleteValidate("vicky");
		  Assert.assertEquals((request.getParameter("retVal")),"vicky");
		 verify(delete,times(1)).doDelete(request,response); 
		 verify(delete,times(1)).deleteValidate("vicky"); 
			}
	
}
