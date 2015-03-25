package com.alexandreesl.handson.core;

import com.alexandreesl.handson.service.ClientService;

public class App {

	public static void main(String[] args) {

		ClientService service = new ClientService();

		System.out.println(service.find(1).getName());

	}

}
