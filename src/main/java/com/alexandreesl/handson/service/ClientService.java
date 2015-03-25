package com.alexandreesl.handson.service;

import com.alexandreesl.handson.dao.ClientDAO;
import com.alexandreesl.handson.model.Client;

public class ClientService {

	private ClientDAO clientDAO;

	public ClientService() {
		this.clientDAO = new ClientDAO();
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
