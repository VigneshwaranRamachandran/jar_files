package com.full;


import java.io.IOException;
import javax.servlet.http.*;



import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("serial")
public class TranslateServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		String EnglishName = req.getParameter("translateValue");
		String translateValue=Translate.getTrans(EnglishName);
//		TranslateList.addListvalue(translateValue);
//		String finalValue=TranslateList.retriveValue();
//		 resp.getWriter().write(finalValue);
		resp.getWriter().write(translateValue);
		}
}
