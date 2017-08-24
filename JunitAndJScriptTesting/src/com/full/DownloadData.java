package com.full;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DownloadData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DownloadData() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String responeseContent;
		String downloadFile = req.getParameter("downloadFile");
		responeseContent=User.userData(downloadFile);
		Download.download(downloadFile);
		
		

		        //Extract some request parameters, fetch your data and generate your document

		        String fileName = "myfile.txt";
		        resp.setContentType("application/pdf");
		        resp.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
		        
		     
	}

	
}
