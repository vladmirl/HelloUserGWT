package com.vladimir.nextstep.shared;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordCoder {

	public PasswordCoder(){
	}

	public static final String salt = "GWTuser";
	
	public static String codePassword(String pass){
		
		String password = "vova";
		try {
			MessageDigest MD = MessageDigest.getInstance("MD5");
			
			MD.update(password.getBytes(), 0, password.length());
			
			password =  new BigInteger(1, MD.digest()).toString(16);
			
			return password;
		} catch (NoSuchAlgorithmException e) {
			
			return "error";
		}
		
	}
	
	public static  String md5(char []c){
		try {
			MessageDigest MD = MessageDigest.getInstance("MD5");
			
			MD.update((new String(c)).getBytes("UTF8"));
			
			String pass = new String(MD.digest());
			
			return pass;
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			return "";
		}
		
	}
}
