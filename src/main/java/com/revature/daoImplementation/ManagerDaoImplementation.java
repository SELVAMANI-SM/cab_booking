package com.revature.daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.revature.daoInterface.ManagerDao;
import com.revature.model.AddingUserConstructor;
import com.revature.util.ConnectionCheck;


public class ManagerDaoImplementation implements ManagerDao {
	private static Logger log = LogManager.getLogger(ManagerDaoImplementation.class);
	static Connection connection;
	static PreparedStatement statement;

	public int login(String email, String password) throws Exception {
		connection = ConnectionCheck.sqlConnection();
		ResultSet rs = null;
		String query = "SELECT id,name,type,email,password FROM details WHERE email= ? ";
		statement = connection.prepareStatement(query);
		statement.setString(1, email);
		rs = statement.executeQuery();
		String name = null;
		int id = 0;

		String mail = null;
		String Password = null;

		String type = null;

		while (rs.next()) {
			id = rs.getInt("id");
			name = rs.getString("name");
			type = rs.getString("type");

			mail = rs.getString("email");
			Password = rs.getString("password");
		}
		if (mail == null) {
			throw new Exception("No Records Found");
		} else if (!type.equals("manager")) {
			throw new Exception("Enter valid manager email");
		}

		else if (Password.equals(password)) {
			log.info("Successfully login");
			log.info("Hi " + name + " Welcome Manager");

		}

		else {
			throw new Exception("Invalid Credentials");
		}
		return id;

	}

	public AddingUserConstructor getProfile(int id) throws SQLException {
		AddingUserConstructor user = new AddingUserConstructor();

		connection = ConnectionCheck.sqlConnection();
		String query = "select * from details where id=? ";
		statement = connection.prepareStatement(query);
		statement.setInt(1, id);

		ResultSet result = statement.executeQuery();

		while (result.next()) {
			user.setId(result.getInt("id"));
			user.setName(result.getString("name"));
			user.setGender(result.getString("gender"));
			user.setAge(result.getInt("age"));
			user.setType(result.getString("type"));
			user.setEmail(result.getString("email"));
			user.setMobile(result.getString("mobile"));
		}
		return user;
	}

	public String getDetails() throws Exception {
		String name = "request";
		Connection connection;
		connection = ConnectionCheck.sqlConnection();
		PreparedStatement statement;
		String query = "select employee_id,place,booking from Cab_booking where booking = ?";

		statement = connection.prepareStatement(query);
		statement.setString(1, name);
		ResultSet result = statement.executeQuery();

		while (result.next()) {
			System.out.println();
			log.info("employee_id" + "\t" + "place" + "\t" + "booking");
			log.info(result.getInt("employee_id") + "\t" + result.getString("place") + "\t"
					+ result.getString("booking"));
			System.out.println();
			int id = result.getInt("employee_id");
			log.info(id);

			String query1 = "select id,name,age,gender,email,mobile from details where id = ?";

			statement = connection.prepareStatement(query1);
			statement.setInt(1, id);
			ResultSet results = statement.executeQuery();
			log.info("User_id" + "\t" + "name" + "\t" + "age" + "\t" + "gender" + "\t" + "email" + "\t" + "mobile");
			while (results.next()) {
				log.info(results.getInt("id") + "\t" + results.getString("name") + "\t" + results.getInt("age") + "\t"
						+ results.getString("gender") + "\t" + results.getString("email") + "\t"
						+ results.getString("mobile"));
			}

		}

		Scanner sc = new Scanner(System.in);
		log.info("Enter id");
		int id = sc.nextInt();
		log.info("Enter Approved / deny");
		String value = sc.next();
		String value1 = null;
		if (value.equals("approved")) {
			value1 = "pending";
		}

		String query1 = "update Cab_booking set booking = ?,cab_no =? where employee_id =?";
		statement = connection.prepareStatement(query1);
		statement.setString(1, value);
		statement.setString(2, value1);

		statement.setInt(3, id);

		int rows = statement.executeUpdate();
		if (rows == 1) {
			return "success";
		}
		return "not updated";
	}
}
