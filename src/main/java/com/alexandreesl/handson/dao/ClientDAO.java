package com.alexandreesl.handson.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.alexandreesl.handson.model.Client;

public class ClientDAO {

	private EntityManager entityManager;

	public ClientDAO() {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("persistence");
		this.entityManager = entityManagerFactory.createEntityManager();
	}

	public Client find(long id) {

		return entityManager.find(Client.class, id);

	}

	public void create(Client client) {

		entityManager.persist(client);

	}

	public void update(Client client) {

		entityManager.merge(client);

	}

	public void delete(Client client) {

		entityManager.remove(client);

	}

}
