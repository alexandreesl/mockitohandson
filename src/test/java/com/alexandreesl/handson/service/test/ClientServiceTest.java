package com.alexandreesl.handson.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.alexandreesl.handson.dao.ClientDAO;
import com.alexandreesl.handson.model.Client;
import com.alexandreesl.handson.service.ClientService;

public class ClientServiceTest {

	private static ClientDAO clientDAO;

	private static ClientService clientService;

	@BeforeClass
	public static void beforeClass() {

		clientService = new ClientService();

		clientDAO = Mockito.mock(ClientDAO.class);

		clientService.setClientDAO(clientDAO);

		Client client = new Client();
		client.setId(0);
		client.setName("Mocked client!");
		client.setPhone(11111111);
		client.setSex("M");

		Mockito.when(clientDAO.find(Mockito.anyLong())).thenReturn(client);

		Mockito.doThrow(new RuntimeException("error on client!"))
				.when(clientDAO).delete((Client) Mockito.any());

		Mockito.doNothing().when(clientDAO).create((Client) Mockito.any());

		Mockito.doAnswer(new Answer<Object>() {
			public Object answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();

				Client client = (Client) args[0];

				client.setName("Mocked client has changed!");

				return client;
			}
		}).when(clientDAO).update((Client) Mockito.any());

	}

	@Test
	public void testFind() {

		Client client = clientService.find(10);

		Mockito.verify(clientDAO).find(10);

		assertEquals(client.getName(), "Mocked client!");

	}

	@Test
	public void testInsert() {

		Client client = new Client();

		client.setId(3);
		client.setName("Celina do Sim");
		client.setPhone(44657688);
		client.setSex("F");

		clientService.create(client);

		Mockito.verify(clientDAO).create(client);

	}

	@Test
	public void testUpdate() {

		Client client = clientService.find(20);

		client.setPhone(12345678);

		clientService.update(client);

		Mockito.verify(clientDAO).update(client);

		assertEquals(client.getName(), "Mocked client has changed!");

	}

	@Test(expected = RuntimeException.class)
	public void testRemove() {

		Client client = clientService.find(2);

		clientService.delete(client);

	}

}
