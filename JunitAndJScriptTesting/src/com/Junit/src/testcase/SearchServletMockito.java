package com.Junit.src.testcase;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.full.SearchServlet;

import junit.framework.TestCase;

public class SearchServletMockito extends TestCase {
	@Mock
	 HttpServletRequest request;
	 @Mock
	 HttpServletResponse response;
	 @Before
	 protected void setUp() throws Exception {
	  MockitoAnnotations.initMocks(this);
	 }

	 @Test
	 public void test() throws Exception {

	  /*HttpServletRequest request = mock(HttpServletRequest.class);
	  HttpServletResponse response = mock(HttpServletResponse.class);
	  HttpSession session = mock(HttpSession.class);
	  RequestDispatcher rd=mock(RequestDispatcher.class);
	   */

	  when(request.getParameter("searchId")).thenReturn("abhinav");
	  //when(request.getParameter("password")).thenReturn("passw0rd");
	 // when(request.getParameter("rememberMe")).thenReturn("Y");
	 // when(request.getSession()).thenReturn(session);
	  //when(request.getRequestDispatcher("/HelloWorld.do")).thenReturn(rd);


	  StringWriter sw = new StringWriter();
	  PrintWriter pw = new PrintWriter(sw);
	  
	  when(response.getWriter()).thenReturn(pw);
	  
	 // new SearchServlet().doGet(request, response);
	  
	  //Verify the session attribute value
	  //verify(session).setAttribute("user", "abhinav");
	  
	  //verify(rd).forward(request, response);
	  
	//  String result = sw.getBuffer().toString().trim();

	 // System.out.println("Result: "+result);
	  
	  //assertEquals("Login successfull...", result);
}
}
