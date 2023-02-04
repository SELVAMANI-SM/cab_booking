package com.revature.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daoImplementation.AdminDaoImplementation;
import com.revature.model.AddingUserConstructor;
import com.revature.model.CabBookingConstructor;
import com.revature.model.CabDetailsConstructor;
import com.revature.validation.CabdetailsValidation;
import com.revature.validation.UserValidationProcess;

public class AdminController {
	private static Logger log = LogManager.getLogger(AdminController.class);

	public static void controller() throws Exception {
		Scanner sc = new Scanner(System.in);
		log.info("Enter '1' for AddUser");
		log.info("Enter '2' for AddCab");
		log.info("Enter '3' for UpdateCab");
		log.info("Enter '4' for DeleteCab");
		log.info("Enter '5' for BookedDetails");
		log.info("Enter '6' for ArrangedCab");
		log.info("Enter '7' for logout");
		int value = sc.nextInt();
		switch (value) {
		case 1:
			AddUser();
			break;

		case 2:
			addingCab();
			break;

		case 3:
			updateCab();
			break;

		case 4:
			deleteCab();
			break;

		case 5:
			bookedDeatils();
			break;
		case 6:
			arranged();
			break;

		case 7:
			log.info("Successfully logged out");
			break;

		default:
			log.info("Enter only  visible number ");
			break;
		}
	}

	public static void AddUser() throws Exception {
		Scanner sc = new Scanner(System.in);
		log.info("Enter Name : ");
		String name = sc.nextLine();
		log.info("Enter Gender : ");
		String gender = sc.next();
		log.info("Enter Age : ");
		int age = sc.nextInt();
		log.info("Enter Type : ");
		String type = sc.next();
		log.info("Enter email : ");
		String email = sc.next();
		log.info("Enter password : ");
		String password = sc.next();
		log.info("Enter mobile : ");
		String mobile = sc.next();
		AddingUserConstructor user = new AddingUserConstructor();
		user.setName(name);
		user.setGender(gender);
		user.setAge(age);
		user.setType(type);
		user.setEmail(email);
		user.setPassword(password);
		user.setMobile(mobile);

		int count = 0;
		try {
			UserValidationProcess.UserValidation(user);

		} catch (Exception e) {
			log.info("Once again ADD user details");
			count++;
			log.error("ERROR : " + e.getMessage());
			AddUser();
		}
		if (count == 0) {
			AdminDaoImplementation dao = new AdminDaoImplementation();
			dao.addUser(user);

			log.info("Succesfully added details");
		}
		controller();

	}

	public static void addingCab() throws Exception {
		Scanner sc = new Scanner(System.in);
		log.info("Enter Name : ");
		String name = sc.next();
		log.info("Enter Email : ");
		String email = sc.next();
		log.info("Enter Mobile : ");
		String mobile = sc.next();
		log.info("Enter Number : ");
		int number = sc.nextInt();
		log.info("Enter Status : ");
		String status = sc.next();

		CabDetailsConstructor cab = new CabDetailsConstructor();
		cab.setName(name);
		cab.setEmail(email);
		cab.setMobile(mobile);
		cab.setNumber(number);
		cab.setStatus(status);
		int count = 0;
		try {
			CabdetailsValidation.validation(cab);

		} catch (Exception e) {
			log.info("Once again ADD Cab details");
			count++;
			log.error("ERROR : " + e.getMessage());
			addingCab();
		}
		if (count == 0) {

			AdminDaoImplementation dao = new AdminDaoImplementation();
			dao.addCab(cab);
			log.info("Succesfully added details");
		}
		controller();
	}

	public static void updateCab() throws Exception {
		AdminDaoImplementation dao = new AdminDaoImplementation();
		dao.updateCab();
		controller();
	}

	public static void deleteCab() throws Exception {
		AdminDaoImplementation dao = new AdminDaoImplementation();
		dao.deleteCab();
		controller();
	}

	public static void bookedDeatils() throws Exception {
		AdminDaoImplementation dao = new AdminDaoImplementation();
		List<CabBookingConstructor> cabbook = new ArrayList<CabBookingConstructor>();
		cabbook = dao.bookedDetails();
		System.out.println();

		log.info("employee_id" + "\t" + "place" + "\t" + "booking" + "\t" + "cab_No");
		for (CabBookingConstructor cab : cabbook) {
			log.info(cab.getEmployeeId() + "\t" + cab.getPlace() + "\t" + cab.getBooking() + "\t" + cab.getCabNo());
		}

		System.out.println();
		controller();
	}

	public static void arranged() throws Exception {
		AdminDaoImplementation dao = new AdminDaoImplementation();
		dao.arranged();
		controller();
	}
}
