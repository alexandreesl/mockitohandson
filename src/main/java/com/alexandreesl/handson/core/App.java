package com.alexandreesl.handson.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.alexandreesl.handson.service.ClientService;

public class App {

	public static void main(String[] args) {

		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfiguration.class);


		ClientService service = (ClientService) ctx.getBean(ClientService.class);

		System.out.println(service.find(1).getName());
		
		System.out.println(service.find(3).getName());
		
		System.out.println(service.find(5).getName());
		
		ctx.close();

		System.exit(0);

	}

}
