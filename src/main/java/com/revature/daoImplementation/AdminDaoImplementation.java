package com.revature.daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.revature.daoInterface.AdminDao;
import com.revature.model.AddingUserConstructor;
import com.revature.model.CabBookingConstructor;
import com.revature.model.CabDetailsConstructor;
import com.revature.util.ConnectionCheck;

public class AdminDaoImplementation implements AdminDao {
	static Connection connection;
	static PreparedStatement statement;
	private static Logger log = LogManager.getLogger(AdminDaoImplementation.class);

	public void addUser(AddingUserConstructor user) throws Exception {
		connection = ConnectionCheck.sqlConnection();
		String query = "insert into details(NAME,gender,age,TYPE,email,PASSWORD,mobile)values(?,?,?,?,?,?,?)";
		statement = connection.prepareStatement(query);
		statement.setString(1, user.getName());
		statement.setString(2, user.getGender());

		statement.setInt(3, user.getAge());

		statement.setString(4, user.getType());
		statement.setString(5, user.getEmail());
		statement.setString(6, user.getPassword());
		statement.setString(7, user.getMobile());

		int rows = statement.executeUpdate();

	}

	public void addCab(CabDetailsConstructor cab) throws Exception {

		connection = ConnectionCheck.sqlConnection();
		String query = "insert into cab(NAME,email,mobile,NUMBER,STATUS)values(?,?,?,?,?)";
		statement = connection.prepareStatement(query);
		statement.setString(1, cab.getName());
		statement.setString(2, cab.getEmail());
		statement.setString(3, cab.getMobile());
		statement.setInt(4, cab.getNumber());
		statement.setString(5, cab.getStatus());

		int rows = statement.executeUpdate();
	}

	public void updateCab() throws Exception {

		connection = ConnectionCheck.sqlConnection();
		PreparedStatement statement;
		String query = "select id,name,email,mobile,number,status,seat from cab";

		statement = connection.prepareStatement(query);

		ResultSet result = statement.executeQuery();
		log.info("id" + "\t" + "name" + "\t" + "email" + "\t" + "mobile" + "\t" + "number" + "\t" + "status" + "\t"
				+ "seat");
		while (result.next()) {

			log.info(result.getInt("id") + "\t" + result.getString("name") + "\t" + result.getString("email") + "\t"
					+ result.getString("mobile") + "\t" + result.getInt("number") + "\t" + result.getString("status")
					+ "\t" + result.getInt("seat"));
			System.out.println();
		}
		Scanner sc = new Scanner(System.in);
		log.info("Enter id");
		int id = sc.nextInt();
		log.info("Enter Name");
		String name = sc.next();
		log.info("Enter email");
		String email = sc.next();
		log.info("Enter mobile");
		String mobile = sc.next();
		log.info("Enter number");
		int number = sc.nextInt();
		log.info("Enter Status");
		String status = sc.next();
		log.info("Enter Seat");
		int seat = sc.nextInt();

		connection = ConnectionCheck.sqlConnection();
		String query1 = "update cab set name =?,email =?, mobile =? ,number =?,status=?,seat=? where id= ?";
		statement = connection.prepareStatement(query1);
		statement.setString(1, name);
		statement.setString(2, email);
		statement.setString(3, mobile);
		statement.setInt(4, number);
		statement.setString(5, status);
		statement.setInt(6, seat);
		statement.setInt(7, id);

		int rows = statement.executeUpdate();
		if (rows == 1) {
			log.info("Updated cab details");
		}

	}

	public void deleteCab() throws Exception {

		connection = ConnectionCheck.sqlConnection();
		PreparedStatement statement;
		String query = "select id,name,email,mobile,number,status from cab";

		statement = connection.prepareStatement(query);

		ResultSet result = statement.executeQuery();

		while (result.next()) {

			log.info("id" + "\t" + "name" + "\t" + "email" + "\t" + "mobile" + "\t" + "number" + "\t" + "status");
			log.info(result.getInt("id") + "\t" + result.getString("name") + "\t" + result.getString("email") + "\t"
					+ result.getString("mobile") + "\t" + result.getInt("number") + "\t" + result.getString("status"));
			System.out.println();
		}
		Scanner sc = new Scanner(System.in);
		log.info("Enter id");
		int id = sc.nextInt();

		connection = ConnectionCheck.sqlConnection();
		String query1 = "delete from cab where id= ?";
		statement = connection.prepareStatement(query1);
		statement.setInt(1, id);

		int rows = statement.executeUpdate();
		if (rows == 1) {
			log.info("Updated cab details");
		}
	}

	public List<CabBookingConstructor> bookedDetails() throws Exception {
		List<CabBookingConstructor> booking = new ArrayList<CabBookingConstructor>();
		connection = ConnectionCheck.sqlConnection();

		PreparedStatement statement;
		String query = "select * from Cab_booking ";

		statement = connection.prepareStatement(query);

		ResultSet result = statement.executeQuery();

		while (result.next()) {
			CabBookingConstructor cab = new CabBookingConstructor();

			cab.setEmployeeId(result.getInt("employee_id"));
			cab.setPlace(result.getString("place"));
			cab.setBooking(result.getString("booking"));
			cab.setCabNo(result.getString("cab_no"));
			booking.add(cab);
		}
		return booking;
	}

	public void arranged() throws Exception {
		connection = ConnectionCheck.sqlConnection();
		PreparedStatement statement;
		String query = "select id,name,email,mobile,number,status,seat from cab where seat < ? ";

		statement = connection.prepareStatement(query);
		statement.setInt(1, 4);

		ResultSet result = statement.executeQuery();
		log.info("id" + "\t" + "name" + "\t" + "email" + "\t" + "mobile" + "\t" + "number" + "\t" + "status" + "\t"
				+ "seat");
		while (result.next()) {

			log.info(result.getInt("id") + "\t" + result.getString("name") + "\t" + result.getString("email") + "\t"
					+ result.getString("mobile") + "\t" + result.getInt("number") + "\t" + result.getString("status")
					+ "\t" + result.getString("seat"));
			System.out.println();
		}
		Scanner sc = new Scanner(System.in);
		log.info("Enter Id");
		int id = sc.nextInt();
		log.info("Enter Cab No");
		int cab_No = sc.nextInt();
		connection = ConnectionCheck.sqlConnection();
		String query1 = "update Cab_booking set cab_no =? where employee_id= ?";
		statement = connection.prepareStatement(query1);
		statement.setInt(1, cab_No);
		statement.setInt(2, id);

		int rows = statement.executeUpdate();
		if (rows == 1) {
			log.info("Successfully arranged cab_NO");
		}

		connection = ConnectionCheck.sqlConnection();
		String query2 = "update details set cab =? where id= ?";
		statement = connection.prepareStatement(query2);
		statement.setInt(1, cab_No);
		statement.setInt(2, id);
		statement.executeUpdate();

	}

	public void login(String email, String password) throws SQLException, Exception {
		connection = ConnectionCheck.sqlConnection();
		ResultSet rs = null;
		String query = "SELECT name,type,email,password FROM details WHERE email= ? ";
		statement = connection.prepareStatement(query);
		statement.setString(1, email);
		rs = statement.executeQuery();
		String name = null;

		String mail = null;
		String Password = null;

		String type = null;

		while (rs.next()) {
			name = rs.getString("name");
			type = rs.getString("type");

			mail = rs.getString("email");
			Password = rs.getString("password");
		}
		if (mail == null) {
			throw new Exception("No Records Found");
		} else if (!type.equals("admin")) {
			throw new Exception("Enter vaild Admin Email");
		}

		else if (Password.equals(password)) {
			System.out.println("Successfully login");
			System.out.println("Hi " + name + "  Welcome Admin");

		}

		else {
			throw new Exception("Invalid Credentials");
		}
	}
}
