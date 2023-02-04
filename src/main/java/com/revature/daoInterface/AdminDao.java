package com.revature.daoInterface;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.AddingUserConstructor;
import com.revature.model.CabBookingConstructor;
import com.revature.model.CabDetailsConstructor;


public interface AdminDao {
	public void addUser(AddingUserConstructor user) throws Exception;
	public void addCab(CabDetailsConstructor cab)throws Exception;
	public void updateCab() throws Exception;
	public void deleteCab()throws Exception;
	public List<CabBookingConstructor> bookedDetails() throws Exception;
	public void arranged () throws Exception;
	public void login(String email, String password)throws SQLException, Exception;

}
