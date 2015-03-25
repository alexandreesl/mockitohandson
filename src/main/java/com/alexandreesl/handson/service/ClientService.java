package com.alexandreesl.handson.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alexandreesl.handson.dao.ClientDAO;
import com.alexandreesl.handson.model.Client;

@Component
public class ClientService {

	@Autowired
	private ClientDAO clientDAO;

	public ClientDAO getClientDAO() {
		return clientDAO;
	}

	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}

	public Client find(long id) {

		return clientDAO.find(id);

	}

	public void create(Client client) {

		clientDAO.create(client);

	}

	public void update(Client client) {

		clientDAO.update(client);

	}

	public void delete(Client client) {

		clientDAO.delete(client);

	}

}
