package com.java.ola;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/ola/java/beans/bean.xml");

		OffersDAO offersDao = (OffersDAO) context.getBean("offersDao");
		
			
		Offer updateOffer = new Offer(6,"Diana", "diana@gmail.com", "Backend developer");
		
		if(offersDao.update(updateOffer)){
			System.out.println("Object updated");
		}else{
			System.out.println("Update failed");
		}

		try {
			
			/*
			Offer offer1 = new Offer("Dave", "dave@hotmail.com", "Coding Java");
			Offer offer2 = new Offer("Karen", "karen@hotmail.com", "Coding C++");
			Offer offer3 = new Offer("Diana", "diana@hotmail.com", "Coding C#");
			
			offersDao.create(offer1);
			offersDao.create(offer2);
			offersDao.create(offer3); */
			
			//Batch job
			
			List<Offer> listOffers = new ArrayList<Offer>();
			
			listOffers.add(new Offer("Ola", "ola@gmail.com", "Java and C++ programmer"));
			listOffers.add(new Offer("Lena", "lena@gmail.com", "Angular expert"));
			
			int [] rvals = offersDao.create(listOffers);
			
			for(int i: rvals){
				System.out.println("Batch job: " + i);
			}
			
			List<Offer> offers = offersDao.getOffers();

			for (Offer offer : offers) {

				System.out.println(offer);
			}
			
			Offer offer = offersDao.getOffer(2);

			System.out.println("Get Mike: " + offer);
			
		} catch (CannotGetJdbcConnectionException ex) {
			System.out.println("Cannot get database connection.");
		} catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getClass());
		}

		((ClassPathXmlApplicationContext) context).close();
	}

}
