package com.vladimir.nextstep;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import com.vladimir.nextstep.server.ExampleServiceImpl;

public class ExampleServiceImplTest {

	 private static final Logger logger = Logger.getLogger(ExampleServiceImplTest.class);
	 

	    @Test
	    public void MorningStartTest() {
	    	 ExampleServiceImpl event = new  ExampleServiceImpl();
	    	 ExampleServiceImpl currentEvent = new  ExampleServiceImpl(new GregorianCalendar(event.TIME.get(Calendar.YEAR),
	                event.TIME.get(Calendar.MONTH), event.TIME.get(Calendar.DAY_OF_MONTH), 6, 00, 00));
	        Assert.assertEquals("morning", currentEvent.personInfo("", "").getMassege());
	        logger.info("TEST");
	    }
	    @Test
	    public void DayStartTest() {
	    	 ExampleServiceImpl event = new  ExampleServiceImpl();
	    	 ExampleServiceImpl currentEvent = new  ExampleServiceImpl(new GregorianCalendar(event.TIME.get(Calendar.YEAR),
	                event.TIME.get(Calendar.MONTH), event.TIME.get(Calendar.DAY_OF_MONTH), 9, 00, 00));
	        Assert.assertEquals("day", currentEvent.personInfo("", "").getMassege());
	        logger.info("TEST");
	    }

	    @Test
	    public void EveningStartTest() {
	    	 ExampleServiceImpl event = new  ExampleServiceImpl();
	    	 ExampleServiceImpl currentEvent = new  ExampleServiceImpl(new GregorianCalendar(event.TIME.get(Calendar.YEAR),
	                event.TIME.get(Calendar.MONTH), event.TIME.get(Calendar.DAY_OF_MONTH), 19, 00, 00));
	        Assert.assertEquals("evening", currentEvent.personInfo("", "").getMassege());
	        logger.info("TEST");
	    }

	    @Test
	    public void NightStartTest() {
	    	 ExampleServiceImpl event = new  ExampleServiceImpl();
	    	 ExampleServiceImpl currentEvent = new  ExampleServiceImpl(new GregorianCalendar(event.TIME.get(Calendar.YEAR),
	                event.TIME.get(Calendar.MONTH), event.TIME.get(Calendar.DAY_OF_MONTH), 23, 00, 00));
	        Assert.assertEquals("night", currentEvent.personInfo("", "").getMassege());
	        logger.info("TEST");
	    }

	    @Test
	    public void NightEndTest() {
	    	 ExampleServiceImpl event = new  ExampleServiceImpl();
	    	 ExampleServiceImpl currentEvent = new  ExampleServiceImpl(new GregorianCalendar(event.TIME.get(Calendar.YEAR),
	                event.TIME.get(Calendar.MONTH), event.TIME.get(Calendar.DAY_OF_MONTH), 5, 59, 59));
	        Assert.assertEquals("night", currentEvent.personInfo("", "").getMassege());
	        logger.info("TEST");
	    }

	    @Test
	    public void EveningEndTest() {
	    	 ExampleServiceImpl event = new  ExampleServiceImpl();
	    	 ExampleServiceImpl currentEvent = new  ExampleServiceImpl(new GregorianCalendar(event.TIME.get(Calendar.YEAR),
	                event.TIME.get(Calendar.MONTH), event.TIME.get(Calendar.DAY_OF_MONTH), 22, 59, 59));
	        Assert.assertEquals("evening", currentEvent.personInfo("", "").getMassege());
	        logger.info("TEST");
	    }

	    @Test
	    public void DayEndTest() {
	    	 ExampleServiceImpl event = new  ExampleServiceImpl();
	    	 ExampleServiceImpl currentEvent = new  ExampleServiceImpl(new GregorianCalendar(event.TIME.get(Calendar.YEAR),
	                event.TIME.get(Calendar.MONTH), event.TIME.get(Calendar.DAY_OF_MONTH), 18, 59, 59));
	        Assert.assertEquals("day", currentEvent.personInfo("", "").getMassege());
	        logger.info("TEST");
	    }

	    @Test
	    public void MorningEndTest() {
	    	 ExampleServiceImpl event = new  ExampleServiceImpl();
	    	 ExampleServiceImpl currentEvent = new  ExampleServiceImpl(new GregorianCalendar(event.TIME.get(Calendar.YEAR),
	                event.TIME.get(Calendar.MONTH), event.TIME.get(Calendar.DAY_OF_MONTH), 8, 59, 59));
	        Assert.assertEquals("morning", currentEvent.personInfo("", "").getMassege());
	        logger.info("TEST");
	    }

	    @Test
	    public void BeginMorningTest() {
	    	 ExampleServiceImpl event = new  ExampleServiceImpl();
	    	 ExampleServiceImpl currentEvent = new  ExampleServiceImpl(new GregorianCalendar(event.TIME.get(Calendar.YEAR),
	                event.TIME.get(Calendar.MONTH), event.TIME.get(Calendar.DAY_OF_MONTH), 6, 00, 01));
	        Assert.assertEquals("morning", currentEvent.personInfo("", "").getMassege());
	        logger.info("TEST");
	    }

	    @Test
	    public void BeginDayTest() {
	    	 ExampleServiceImpl event = new  ExampleServiceImpl();
	    	 ExampleServiceImpl currentEvent = new  ExampleServiceImpl(new GregorianCalendar(event.TIME.get(Calendar.YEAR),
	                event.TIME.get(Calendar.MONTH), event.TIME.get(Calendar.DAY_OF_MONTH), 9, 00, 01));
	        Assert.assertEquals("day", currentEvent.personInfo("", "").getMassege());
	        logger.info("TEST");
	    }

	    @Test
	    public void BeginEveningTest() {
	    	 ExampleServiceImpl event = new  ExampleServiceImpl();
	    	 ExampleServiceImpl currentEvent = new  ExampleServiceImpl(new GregorianCalendar(event.TIME.get(Calendar.YEAR),
	                event.TIME.get(Calendar.MONTH), event.TIME.get(Calendar.DAY_OF_MONTH), 19, 00, 01));
	        Assert.assertEquals("evening", currentEvent.personInfo("", "").getMassege());
	        logger.info("TEST");
	    }

	    @Test
	    public void BeginNightTest() {
	    	 ExampleServiceImpl event = new  ExampleServiceImpl();
	    	 ExampleServiceImpl currentEvent = new  ExampleServiceImpl(new GregorianCalendar(event.TIME.get(Calendar.YEAR),
	                event.TIME.get(Calendar.MONTH), event.TIME.get(Calendar.DAY_OF_MONTH), 23, 00, 01));
	        Assert.assertEquals("night", currentEvent.personInfo("", "").getMassege());
	        logger.info("TEST");
	    }
	 
	    /*@Test
	    public void getPeriod_test() {
	    	ExampleServiceImpl event = new  ExampleServiceImpl();
	        if (event.personInfo("","").equals( "morning")) {
	            Assert.assertEquals("morning", event.personInfo("", ""));
	            logger.info("TEST");
	        } else if (event.personInfo("","").equals( "day")) {
	            Assert.assertEquals("day", event.personInfo("", ""));
	            logger.info("TEST");
	        } else if (event.personInfo("","").equals( "evening")) {
	            Assert.assertEquals("evening", event.personInfo("", ""));
	            logger.info("TEST");
	        } else if (event.personInfo("","").equals( "night")) {
	            Assert.assertEquals("night", event.personInfo("", ""));
	            logger.info("TEST");
	        } else {
	            Assert.fail("Incorrect Time Error!");
	            logger.info("Incorrect Time Error!");
	        }
	    }*/
	    
}
