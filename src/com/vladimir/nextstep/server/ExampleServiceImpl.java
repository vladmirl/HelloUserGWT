package com.vladimir.nextstep.server;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

import org.hibernate.Session;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.vladimir.nextstep.client.service.ExampleService;
import com.vladimir.nextstep.shared.InfoPerson;
import com.vladimir.nextstep.shared.PasswordCoder;



@SuppressWarnings("serial")
public class ExampleServiceImpl extends RemoteServiceServlet implements ExampleService {
	
	
	public final Calendar TIME;
	 private static final Logger LOGGER = Logger.getGlobal();
	 
	
	public ExampleServiceImpl(){
		TIME = new GregorianCalendar();
	}
	
	public ExampleServiceImpl(GregorianCalendar time){
		TIME = time;
	}

	@Override
	public InfoPerson personInfo(String login, String pass) {
		
		String password = PasswordCoder.md5(pass.toCharArray()) + PasswordCoder.salt;
		
		// или  String password = PasswordCoder.codePassword(pass);
		//тогда записивать в базу соответственно по алглритму PasswordCoder.codePassword(pass);
         //  но в первом варианте пароль покороче 
		//дальше идет работа с базой данных через хибернет но эта часть у меня не запускалась (спрашивал раньше) 
		//так-как на серверной части не коннектилась библиотека хибера(в прочем как и логера и все остальные внешние библиотеки)
		// так-же юнит тесты выдают ошибку ротому что не нет достуна к базе данных
		
		
		InfoPerson personInfo = new InfoPerson();
		
		HibernateUtil util = new HibernateUtil();
	  Session session = HibernateUtil.getSessionFactory().openSession();
	  Object obj = session.load(UserInfo.class, new String(login));
	  UserInfo userInfo = (UserInfo)obj;
  	
		if(userInfo.getUserLogin().equals(login)&&userInfo.getUserPassword().equals(password)){
		
			personInfo.setUserName(userInfo.getUserName());
			personInfo.setMassege(calendar());
			return personInfo;
		 
		}else if(userInfo.getUserLogin().equals(login)&&
				!userInfo.getUserPassword().equals(password)){
		
		personInfo.setUserName("Error, incorrect password");	
		personInfo.setMassege(calendar());
		LOGGER.info("Error! entered incorrect password");
	  return personInfo;
	  
		}else if(!userInfo.getUserLogin().equals(login)&&
				userInfo.getUserPassword().equals(password)){
			
			personInfo.setUserName("Error, incorrect login");	
			personInfo.setMassege(calendar());
			LOGGER.info("Error! entered incorrect login");
			  return personInfo;
			  
		}else{
			personInfo.setUserName("Error, user not found");	
			personInfo.setMassege(calendar());
			LOGGER.info("Error! user not found");
			  return personInfo;
		}
	}
	public String calendar(){

		 if (TIME.get(Calendar.HOUR_OF_DAY) > 6 && TIME.get(Calendar.HOUR_OF_DAY) < 9 || TIME.get(Calendar.HOUR_OF_DAY) == 6) {
			 LOGGER.info("shown the morning greeting message");
			 return "morning";
			 
			 
	        } else if (TIME.get(Calendar.HOUR_OF_DAY) > 9 && TIME.get(Calendar.HOUR_OF_DAY) < 19 || TIME.get(Calendar.HOUR_OF_DAY) == 9) {
	        	LOGGER.info("shown the day greeting message");
	        	return "day";
	        	 
	        } else if (TIME.get(Calendar.HOUR_OF_DAY) > 19 && TIME.get(Calendar.HOUR_OF_DAY) < 23 || TIME.get(Calendar.HOUR_OF_DAY) == 19){
	        	LOGGER.info("shown the evening greeting message");
	        	return "evening";
	        	 
	        } else{
	        	
	        	LOGGER.info("shown the night greeting message");
	        	return "night";
		 
	        }
	    }
	}


	