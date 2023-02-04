package cabbooking;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.controller.EmployeeController;
import com.revature.daoImplementation.EmployeeDaoImplementation;
import com.revature.model.AddingUserConstructor;
import com.revature.model.CabBookingConstructor;

public class Employee {
	private static Logger log = LogManager.getLogger(Employee.class);


	public static void main(String[] args) throws Exception {
			Scanner sc= new Scanner(System.in);
			log.info("Enter Email");
			String email = sc.next();
			log.info("Enter Password");
			String password =sc.next();
			EmployeeDaoImplementation emp = new EmployeeDaoImplementation();
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
			if(count ==0)
			{
				EmployeeController.controller(value);
			}

	}

}
