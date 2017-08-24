package com.full;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TranslateServlettest  extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
	 String EnglishName = req.getParameter("translateValue");
		String languageName  = req.getParameter("languageName");
		String finalValue="";
		String arr[]=EnglishName.split(" ");
		if(languageName.equals("Tamil")){
		for(int i=0;i<arr.length;i++){
			String translateValue=Translate.getTrans(arr[i]);
			finalValue=finalValue+" "+translateValue;
		}
		}else{
		for(int i=0;i<arr.length;i++){
			String translateValue=Translate.getTransinFrench(arr[i]);
			finalValue=finalValue+" "+translateValue;
		}
		}
		resp.getWriter().write(finalValue);
}
}