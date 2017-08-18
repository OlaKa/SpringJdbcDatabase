package com.java.ola;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context =  new ClassPathXmlApplicationContext("com/ola/java/beans/bean.xml");
		
		Robot robot = (Robot)context.getBean("robot");
		
		robot.speak();
	
		((ClassPathXmlApplicationContext)context).close();
	}

}
