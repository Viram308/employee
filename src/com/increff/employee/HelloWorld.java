package com.increff.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "increff", "password1234");
		insert(con);
		select(con);
		//delete(con);
		//select(con);
		con.close();
	}

	private static void insert(Connection con) throws SQLException {
		System.out.println("Inserting employees");
		Statement stmt = con.createStatement();
		for (int i = 0; i < 3; i++) {
			int id=i;
			String name="name "+i;
			int age=30+i;
			stmt.executeUpdate("insert into employee values(" + id +",'" + name +"'," + age+")");
		}
		stmt.close();
	}

	private static void select(Connection con) throws SQLException {
		System.out.println("Selecting employees");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employee");
		System.out.println("Selecting employees");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getInt(3));
		}
		stmt.close();
	}

	private static void delete(Connection con) throws SQLException {
		System.out.println("Deleting employees");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employee");
		List<Integer> idList=new ArrayList<Integer>();
		System.out.println("Selecting employees");
		while (rs.next()) {
			idList.add(rs.getInt(1));
		}
		for(int i=0;i<idList.size();i++) {
			stmt.executeUpdate("delete from employee where id="+idList.get(i));
		}
		stmt.close();
	}
}
