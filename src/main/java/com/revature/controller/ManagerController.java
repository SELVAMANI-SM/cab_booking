package com.revature.controller;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daoImplementation.ManagerDaoImplementation;
import com.revature.model.AddingUserConstructor;

public class ManagerController {
	private static Logger log = LogManager.getLogger(ManagerController.class);

	public static void controller(int id) throws Exception {
		Scanner sc = new Scanner(System.in);
		log.info("Enter '1' for approve / deny");
		log.info("Enter '2' for profile");
		log.info("Enter '3' for logout");
		int value = sc.nextInt();
		switch (value) {
		case 1:
			GetBookingDetails(id);
			break;

		case 2:
			getProfile(id);
			break;

		case 3:
			log.info("Succesfully Logged Out");
			break;

		default:
			log.info("Enter vaild visible number");
			controller(id);
			break;

		}
	}

	public static void GetBookingDetails(int id) throws Exception {
		ManagerDaoImplementation emp = new ManagerDaoImplementation();
		String result = emp.getDetails();
		System.out.println();
		log.info(result);
		System.out.println();
		controller(id);
	}

	public static void getProfile(int id) throws Exception {
		ManagerDaoImplementation emp = new ManagerDaoImplementation();
		AddingUserConstructor user = new AddingUserConstructor();
		user = emp.getProfile(id);

		System.out.println();
		log.info("User_id" + "\t" + "name" + "\t" + "age" + "\t" + "gender" + "\t" + "email" + "\t" + "mobile");
		log.info(user.getId() + "\t" + user.getName() + "\t" + user.getAge() + "\t" + user.getGender() + "\t"
				+ user.getEmail() + "\t" + user.getMobile());
		System.out.println();
		controller(id);
	}

}
