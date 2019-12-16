package com.increff.employee;

import java.sql.SQLException;

import org.apache.log4j.Logger;

public class EmployeeHibernateApi {

	private static Logger logger = Logger.getLogger(EmployeeHibernateApi.class);

	// Lets hope this works !!

	public EmployeeHibernateApi() throws Exception {

	}

	public void insert() throws SQLException {
		logger.error("inserting employees");
	}

	public void select() throws SQLException {
		logger.info("selecting employees");
	}

	public void delete() throws SQLException {
		logger.info("deleting all employees");
	}

}