package com.alexandreesl.dao.test;

import java.io.InputStream;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.hsqldb.HsqldbDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.HibernateException;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDBUnitSetup {

	private static IDatabaseConnection connection;
	private static IDataSet dataset;

	@Autowired
	protected EntityManager entityManager;

	@PostConstruct
	public void init() throws HibernateException, DatabaseUnitException,
			SQLException {

		connection = new DatabaseConnection(
				((SessionImpl) (entityManager.getDelegate())).connection());
		connection.getConfig().setProperty(
				DatabaseConfig.PROPERTY_DATATYPE_FACTORY,
				new HsqldbDataTypeFactory());

		FlatXmlDataSetBuilder flatXmlDataSetBuilder = new FlatXmlDataSetBuilder();
		flatXmlDataSetBuilder.setColumnSensing(true);
		InputStream dataSet = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("test-data.xml");
		dataset = flatXmlDataSetBuilder.build(dataSet);

		DatabaseOperation.CLEAN_INSERT.execute(connection, dataset);

	}

}
