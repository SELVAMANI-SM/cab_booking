package com.revature.daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.revature.daoInterface.EmployeeDao;
import com.revature.model.AddingUserConstructor;
import com.revature.model.CabBookingConstructor;
import com.revature.util.ConnectionCheck;



public class EmployeeDaoImplementation implements EmployeeDao {
	static Connection connection;
	static PreparedStatement statement;
	private static Logger log = LogManager.getLogger(EmployeeDaoImplementation.class);

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
		} else if (!type.equals("employee")) {
			throw new Exception("Enter Valid Employee email");
		}

		else if (Password.equals(password)) {
			log.info("Successfully login");
			log.info("Hi " + name + "  Welcome Employee");

		}

		else {
			throw new Exception("Invalid Credentials");
		}
		return id;
	}

	public void addBooking(CabBookingConstructor user) throws SQLException {

		connection = ConnectionCheck.sqlConnection();
		String query = "insert into Cab_booking(employee_id,place,booking)values(?,?,?)";
		statement = connection.prepareStatement(query);
		statement.setInt(1, user.getEmployeeId());
		statement.setString(2, user.getPlace());

		statement.setString(3, user.getBooking());

		int rows = statement.executeUpdate();
		log.info("No of rows inserted:" + rows);

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

	public CabBookingConstructor getDetails(int id) throws Exception {
		CabBookingConstructor cab = new CabBookingConstructor();

		connection = ConnectionCheck.sqlConnection();
		String query = "select * from Cab_booking where employee_id= ?";
		statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			cab.setEmployeeId(result.getInt("employee_id"));
			cab.setPlace(result.getString("place"));
			cab.setBooking(result.getString("booking"));
			cab.setCabNo(result.getString("cab_no"));
		}
		return cab;
	}

}
