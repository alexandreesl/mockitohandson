package com.alexandreesl.handson.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.alexandreesl.handson.model.Client;
import com.alexandreesl.handson.service.ClientService;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfiguration.class);

		ClientService service = (ClientService) context
				.getBean(ClientService.class);

		System.out.println(service.find(1).getName());

		System.out.println(service.find(3).getName());

		System.out.println(service.find(5).getName());

		Client client = new Client();

		client.setId(6);
		client.setName("Celina do Sim");
		client.setPhone(44657688);
		client.setSex("F");

		service.create(client);

		System.out.println(service.find(6).getName());

		System.exit(0);

	}

}
