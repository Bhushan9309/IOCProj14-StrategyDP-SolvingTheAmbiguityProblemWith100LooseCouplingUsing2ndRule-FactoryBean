package com.nt.main;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.IEngine;
import com.nt.sbeans.Vehicle;

//Main Method Class
public class StrategyDPTest {

	public static void main(String[] args)
	{
		//create IOC Container Using Try Block  with Resources 
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);)
		{
			//get target spring bean class object reference variable
			   Vehicle v1 = ctx.getBean("vehicle",Vehicle.class);
			   //invoke business method 
			    v1.journey("Hyderabad", "Goa");
			    
			    System.out.println("===========================================");
			    IEngine engine = ctx.getBean("engineFactory",IEngine.class);
			    System.out.println("Class Name : : "+engine.getClass());
			    System.out.println("Bean Ids : : "+ Arrays.toString(ctx.getBeanDefinitionNames()));
			   
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
