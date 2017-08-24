package com.full;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

//import com.google.appengine.repackaged.com.google.protobuf.contrib.Utf8ByteString.Writer;
//import com.darwinsys.spdf.PDF;  
//import com.darwinsys.spdf.Page;  
//import com.darwinsys.spdf.Text;  
//import com.darwinsys.spdf.MoveTo;  


public class Download {

	public static String download(String value)
	{
		BufferedWriter bw = null;
		Writer writer = null;
	      try {
		 String mycontent = "This String would be written" +
		    " to the specified File";
	         //Specify the file name and path here
		 File file = new File("C:/myfile.txt");
		  if (!file.exists()) {
		     file.createNewFile();
		  }
		//  PDF p = new PDF(out); 
//	  writer = new BufferedWriter(new OutputStreamWriter(
//          new FileOutputStream("myfile.txt"), "utf-8"));
//		    writer.write(value);
		  FileInputStream fin = new FileInputStream("c:\\test\\java.jpg");  
		  FileInputStream fileInputStream = new FileInputStream("pdfFile");
			//OutputStream responseOutputStream = response.getOutputStream();
	      } catch (IOException ioe) {
		   ioe.printStackTrace();
		} finally {
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
		return value;
		
		
		
		
	}

}
