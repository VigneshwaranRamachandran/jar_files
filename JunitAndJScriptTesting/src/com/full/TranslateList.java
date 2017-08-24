package com.full;

import java.util.ArrayList;
import java.util.List;

public class TranslateList {
static List<String> list = new ArrayList<String>();
static String returnValues="";
static String finalValues="";
	public static void addListvalue(String translateValue) {
		// TODO Auto-generated method stub
		list.add(translateValue);
		}
	public static String retriveValue() {
		// TODO Auto-generated method stub
		for(int i=0;i<list.size();i++){
			returnValues=(String)list.get(i);
			finalValues=finalValues.concat(returnValues+" ");
		}
		return finalValues;
	}

	
}
