package cabbooking;



import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.controller.AdminController;
import com.revature.daoImplementation.AdminDaoImplementation;



public class Admin {
	private static Logger log = LogManager.getLogger(Admin.class);

	public static void main(String[] args) throws Exception {
		Scanner sc= new Scanner(System.in);
		log.info("Enter Email");
		String email = sc.next();
		log.info("Enter Password");
		String password =sc.next();
		AdminDaoImplementation emp = new AdminDaoImplementation();
		int count=0;
		try {
			emp.login(email, password);
			
		}
		catch(Exception e)
		{
			count++;
			log.info(e.getMessage());
		}
		if(count ==0)
		{
			AdminController.controller();
			
		}

	}
	
	
}


