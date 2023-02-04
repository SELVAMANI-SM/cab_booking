package com.revature.daoInterface;

import java.sql.SQLException;

import com.revature.model.AddingUserConstructor;



public interface ManagerDao {
	
	public int login(String email, String password)throws SQLException, Exception;
	
	public AddingUserConstructor getProfile (int id)throws SQLException,Exception;
	public String getDetails() throws Exception,Exception;
	

}
