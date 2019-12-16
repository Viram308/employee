package com.increff.employee;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class EmployeeTest {
	@Test
	public void sayHello() throws Exception {
		EmployeeApi api = new EmployeeApi();
		api.delete();
		api.insert();
		ResultSet rs=api.select();
		int i=0;
		while(rs.next()) {
			i++;
		}
		assertEquals(3,i);
		
	}
}
