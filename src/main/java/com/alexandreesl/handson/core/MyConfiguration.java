package com.alexandreesl.handson.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alexandreesl.handson.dao.ClientDAO;
import com.alexandreesl.handson.service.ClientService;

@Configuration
public class MyConfiguration {

	@Bean
	public ClientDAO getClientDAO() {
		return new ClientDAO();
	}

	@Bean
	public ClientService getClientService() {
		return new ClientService();
	}

	@Bean
	public EntityManager getEntityManager() {

		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("persistence");
		return entityManagerFactory.createEntityManager();

	}

}
