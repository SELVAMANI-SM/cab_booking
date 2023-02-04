package cabbooking;


import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.controller.ManagerController;
import com.revature.daoImplementation.ManagerDaoImplementation;
import com.revature.model.AddingUserConstructor;

public class Manager {
	private static Logger log = LogManager.getLogger(Manager.class);
	public static void main(String[] args) throws Exception {
		Scanner sc= new Scanner(System.in);
		log.info("Enter Email");
		String email = sc.next();
		log.info("Enter Password");
		String password =sc.next();
		ManagerDaoImplementation emp = new ManagerDaoImplementation();
		int count=0;
		int value=0;
		try {
			value=emp.login(email, password);
			
		}
		catch(Exception e)
		{
			count++;
			log.info(e.getMessage());
		}
		if(count==0)
		{
			ManagerController.controller(value);
			}

	}
	
}
