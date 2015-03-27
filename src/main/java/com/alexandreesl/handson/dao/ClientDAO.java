package com.alexandreesl.handson.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alexandreesl.handson.model.Client;

@Component
public class ClientDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(readOnly = true)
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
