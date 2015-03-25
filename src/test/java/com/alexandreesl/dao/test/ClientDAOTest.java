package com.alexandreesl.dao.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.alexandreesl.handson.core.MyConfiguration;
import com.alexandreesl.handson.dao.ClientDAO;
import com.alexandreesl.handson.model.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyConfiguration.class)
@TransactionConfiguration(defaultRollback=true)
public class ClientDAOTest extends BaseDBUnitSetup {

	@Autowired
	private ClientDAO clientDAO;

	@Test
	public void testFind() {

		Client client = clientDAO.find(1);

		assertNotNull(client);

		client = clientDAO.find(2);

		assertNotNull(client);

		client = clientDAO.find(3);

		assertNull(client);

		client = clientDAO.find(4);

		assertNull(client);

		client = clientDAO.find(5);

		assertNull(client);

	}

	@Test
	public void testInsert() {

		Client client = new Client();

		client.setName("Celina do Sim");
		client.setPhone(44657688);
		client.setSex("F");

		clientDAO.create(client);

	}

	@Test
	public void testUpdate() {

		Client client = clientDAO.find(1);

		client.setPhone(12345678);

		clientDAO.update(client);

	}

	@Test
	public void testRemove() {

		Client client = clientDAO.find(1);

		clientDAO.delete(client);

	}

}
