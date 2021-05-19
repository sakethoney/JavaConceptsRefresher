package com.main.regularexpresssion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTester {
	
	
	public static void main(String[] args) {
		
		boolean t = validateLetters("1888");
		System.out.println("t "+ t);
		
	}

	public static boolean validateLetters(String txt) {

	    //String regx = "[a-zA-Z]+\\.?";
		String regx = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
	    Pattern pattern = Pattern.compile(regx);
	    Matcher matcher = pattern.matcher(txt);
	    return matcher.find();

	}
}
