package com.full;

import java.util.HashMap;
import java.util.Map;

public class Translate {

	static Map<String,String> map=new HashMap<String,String>();  
	public static String getTrans(String EnglishName){
		map.put("hi","vanakkam");
		 map.put("good","nalla");
		 map.put("morning","kalai");
		 map.put("am","nan");
		 map.put("fine","nalam");
		 map.put("how", "yepadi");
		 map.put("are", "ullai");
		 map.put("you","nee");
		 map.put("what","yenna");
		 map.put("is", "irru");
		 map.put("name", "peyar");
		 map.put("your","ungal");

	if(map.containsKey(EnglishName)){
		return map.get(EnglishName);
	}
	else{
		return EnglishName;
	}
	}
	public static String getTransinFrench(String EnglishName) {
		map.put("hi","salut");
		 map.put("good","bon");
		 map.put("morning","matin");
		 map.put("am","Je");
		 map.put("fine","fin");
		 map.put("how", "comment");
		 map.put("are", "sont");
		 map.put("you","vous");
		 map.put("what","quelle");
		 map.put("is", "est");
		 map.put("name", "prénom");
		 map.put("your","votre");
	if(map.containsKey(EnglishName)){
		return map.get(EnglishName);
	}
	else{
		return EnglishName;
	}
	}
}