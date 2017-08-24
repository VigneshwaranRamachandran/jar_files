package com.Junit.src.testcase;

import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;



public class JunitCore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		org.junit.runner.Result result = JUnitCore.runClasses(AllTests.class);
		
		        for (Failure failure : result.getFailures()) {
		
		            System.out.println(failure.toString());
		           
		        }
		    System.out.println(result.wasSuccessful());

	}

}
