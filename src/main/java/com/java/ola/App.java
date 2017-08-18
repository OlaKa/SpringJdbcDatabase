package com.java.ola;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context =  new ClassPathXmlApplicationContext("com/ola/java/beans/bean.xml");
		
		OffersDAO offersDao = (OffersDAO)context.getBean("offersDao");
		
		List <Offer> offers = offersDao.getOffers();
		
		for(Offer offer : offers){
			
			System.out.println(offer);
		}
	
		((ClassPathXmlApplicationContext)context).close();
	}

}
