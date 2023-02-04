package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;


import cabbooking.PropertiesClass;

public class ConnectionCheck{
	
	public static Connection sqlConnection() {
		
	
	Connection connection = null;
	

	try {
		
		Class.forName(PropertiesClass.getClassName());
	 connection= DriverManager.getConnection(PropertiesClass.getUrl(),PropertiesClass.getUserName(),PropertiesClass.getUserPassword());
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return connection;
}
}

