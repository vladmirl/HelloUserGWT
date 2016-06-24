package com.vladimir.nextstep.shared;

import java.io.Serializable;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.vladimir.nextstep.server.UserInfo;
import com.vladimir.nextstep.shared.PasswordCoder;


@SuppressWarnings("serial")
public class DataInsertion implements Serializable  {

	public static void main(String []args) {
		
		DataInsertion dataBase = new DataInsertion();
		UserInfo ivan  = new UserInfo();
		UserInfo john  = new UserInfo();
		
		ivan.setUserName("Иван");
		ivan.setUserLogin("ivan");
		ivan.setUserPassword("secret");
		john.setUserName("John");
    	john.setUserLogin("john");
    	john.setUserPassword("smith");
		
    	//dataBase.insertInfo(ivan);
    	//dataBase.insertInfo(john);
		
		 Scanner input = new Scanner(System.in);
			System.out.println("Введите пожалуйста логин: (ivan)");
			String login = input.nextLine();
			System.out.println("Введите пожалуйста пароль: (secret)");
			String pass = input.nextLine();
			
			pass = PasswordCoder.md5(pass.toCharArray()) + PasswordCoder.salt;
			
			if(login.equals(dataBase.getInfo("ivan").getUserLogin())
			&& pass.equals(dataBase.getInfo("ivan").getUserPassword())){
				
				System.out.println("Доброго времени суток, "+dataBase.getInfo("ivan").getUserName());
			
			}else if(login.equals(dataBase.getInfo("john").getUserLogin())
			&& pass.equals(dataBase.getInfo("john").getUserPassword())){
				
				System.out.println("Доброго времени суток, "+dataBase.getInfo("john").getUserName());
				
			}else if(!login.equals(dataBase.getInfo("ivan").getUserLogin())
					&& pass.equals(dataBase.getInfo("ivan").getUserPassword())  
					|| !login.equals(dataBase.getInfo("john").getUserLogin())
					&& pass.equals(dataBase.getInfo("john").getUserPassword())){ 
				
				System.out.println("Ошибка, неправильный логин");
				
			}else if(login.equals(dataBase.getInfo("ivan").getUserLogin())
					&& ! pass.equals(dataBase.getInfo("ivan").getUserPassword())  
					|| login.equals(dataBase.getInfo("john").getUserLogin())
					&& ! pass.equals(dataBase.getInfo("john").getUserPassword())){
				
				System.out.println("Ошибка, неправильный пароль");

			}else{
				
				System.out.println("Ошибка, пользователь не существует в данной базе данных");
			}
		}
	
	 public void insertInfo(UserInfo userInfo){
		 
		 String password = PasswordCoder.md5(userInfo.getUserPassword().toCharArray())+PasswordCoder.salt;
		 userInfo.setUserPassword(password);
		 
		  try{
			    
	  	Configuration config = new Configuration();
	  	config.configure("hibernate.cfg.xml");
	  	SessionFactory SF = config.buildSessionFactory();
	  	 Session session = SF.openSession();
		    	
		    	Transaction TR = session.beginTransaction();
		    	session.save(userInfo);
		    	System.out.println("the person saved successfully");
		    	
		    	TR.commit();
		    	session.close();
		    	SF.close();
		  }catch(Throwable ex){
	  	
	  	  System.err.println("Initial SessionFactory creation failed." + ex);
		      throw new ExceptionInInitializerError(ex);
		    }
	  }

	public UserInfo getInfo(String idString){
		  
		  UserInfo userInfo;
	  	try{
	  		
	  	Configuration config = new Configuration();
	  	config.configure("hibernate.cfg.xml");
	  	SessionFactory SF = config.buildSessionFactory();
	  	Session session = SF.openSession();
	  	
	  	Object obj = session.load(UserInfo.class, new String(idString));
	  	userInfo = (UserInfo)obj;
	  	System.out.println(userInfo.getUserLogin()+userInfo.getUserName()+userInfo.getUserPassword());
	  	
	  	 }catch(Throwable ex){
		    	
		    	  System.err.println("Initial SessionFactory creation failed." + ex);
			      throw new ExceptionInInitializerError(ex);
	  	 }
	  	return userInfo;
	}
}

