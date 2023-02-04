package com.revature.controller;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.revature.daoImplementation.EmployeeDaoImplementation;
import com.revature.model.AddingUserConstructor;
import com.revature.model.CabBookingConstructor;

public class EmployeeController {
	private static Logger log = LogManager.getLogger(EmployeeController.class);
	public static void controller(int id) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		log.info("Enter '1' for Booking Cab");
		log.info("Enter '2' for profile");
		log.info("Enter '3' for cab result");
		log.info("Enter '4' for logout");
		int value = sc.nextInt();
		switch(value)
		{
		case 1:booking(id);
		break;
			
		case 2:getProfile(id);
			break;
			
		case 3:getBookingDetails(id);
		break;
			
		case 4:log.info("Succesfully Logged Out");
		break;
		
		default : log.info("Enter vaild visible number");
		break;
		}
	}
	public static void  booking (int id) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int employeeId = id;
		log.info("Enter place : ");
		Scanner sr= new Scanner(System.in);
		String place = sr.nextLine();
		
		log.info("Enter Booking as request : ");
		String booking = sc.next();
		
		CabBookingConstructor cab = new CabBookingConstructor();
		cab.setEmployeeId(employeeId);
		cab.setPlace(place);
		cab.setBooking(booking);
		EmployeeDaoImplementation emp = new EmployeeDaoImplementation();
		emp.addBooking(cab);
		controller(id);
		
	}
	public static void getProfile (int id) throws Exception
	{
		EmployeeDaoImplementation emp = new EmployeeDaoImplementation();
		AddingUserConstructor user= new AddingUserConstructor();
		user=emp.getProfile(id);
		
		System.out.println();
		log.info("User_id"+"\t"+"name"+"\t"+"age"+"\t"+"gender"+"\t"+"email"+"\t"+"\t"+"mobile");
		log.info(user.getId()+"\t"+user.getName()+"\t"+user.getAge()+"\t"+user.getGender()+"\t"+user.getEmail()+"\t"+user.getMobile());
		System.out.println();
		controller(id);
	
		}
	public static void getBookingDetails(int id) throws Exception
	{
		EmployeeDaoImplementation emp = new EmployeeDaoImplementation();
		CabBookingConstructor cab = new CabBookingConstructor();
		cab=emp.getDetails(id);
		System.out.println();
		log.info("Employee_id"+"\t"+"Place"+"\t"+"\t"+"Booking"+"\t"+"Cab_no");
		log.info(cab.getEmployeeId()+"\t"+cab.getPlace()+"\t"+cab.getBooking()+"\t"+cab.getCabNo());
		System.out.println();
		controller(id);

	}
}
