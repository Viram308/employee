package com.increff.employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class EmployeeApi {
	private Connection con;
	private static final Logger logger = Logger.getLogger(EmployeeApi.class); 
	
	
	public EmployeeApi() throws SQLException, IOException, ClassNotFoundException {
		PropertyConfigurator.configure("resources/log4j.properties");
		Properties props = new Properties();
		InputStream inStream = new FileInputStream("employee.properties");
		props.load(inStream);
		Class.forName(props.getProperty("jdbc.driver"));
		con = DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.username"),
				props.getProperty("jdbc.password"));
		
	}
	public static void main(String args[]) {
		
	}
	public void insert() throws SQLException {
		logger.info("Inserting employees");
		Statement stmt = con.createStatement();
		for (int i = 0; i < 3; i++) {
			int id = i;
			String name = "name " + i;
			int age = 30 + i;
			stmt.executeUpdate("insert into employee values(" + id + ",'" + name + "'," + age + ")");
		}
		stmt.close();
	}

	public ResultSet select() throws SQLException {
		logger.info("Selecting employees");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employee");
		return rs;
//		while (rs.next()) {
//			logger.info(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getInt(3));
//		}
//		stmt.close();
	}

	public void delete() throws SQLException {
		logger.info("Deleting employees");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employee");
		List<Integer> idList = new ArrayList<Integer>();
		logger.info("Selecting employees");
		while (rs.next()) {
			idList.add(rs.getInt(1));
		}
		for (int i = 0; i < idList.size(); i++) {
			stmt.executeUpdate("delete from employee where id=" + idList.get(i));
		}
		stmt.close();
	}
}
