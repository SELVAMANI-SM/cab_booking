package com.revature.daoInterface;

import java.sql.SQLException;

import com.revature.model.AddingUserConstructor;
import com.revature.model.CabBookingConstructor;


public interface EmployeeDao {
	public int login(String email, String password)throws SQLException, Exception;
	public void addBooking(CabBookingConstructor booking) throws SQLException,Exception;
	public AddingUserConstructor getProfile (int id)throws SQLException,Exception;
	public CabBookingConstructor getDetails(int id) throws Exception,Exception;
}
