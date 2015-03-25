package com.alexandreesl.handson.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alexandreesl.handson.model.Client;

@Component
public class ClientDAO {

	@Autowired
	private EntityManager entityManager;

	public Client find(long id) {

		return entityManager.find(Client.class, id);

	}

	@Transactional
	public void create(Client client) {

		entityManager.persist(client);

	}

	@Transactional
	public void update(Client client) {

		entityManager.merge(client);

	}

	@Transactional
	public void delete(Client client) {

		entityManager.remove(client);

	}

}
