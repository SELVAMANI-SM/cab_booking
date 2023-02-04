package com.revature.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.model.CabDetailsConstructor;


public class CabdetailsValidation {
	private static Logger log = LogManager.getLogger(CabdetailsValidation.class);
	static int count1 = 0;

	public static void validation(CabDetailsConstructor details) throws Exception {
		NameCheck(details.getName());
		EmailCheck(details.getEmail());
		MobileCheck(details.getMobile());
		NumberCheck(details.getNumber());
		StatusCheck(details.getStatus());
	}

	private static void StatusCheck(String status) throws Exception {
		if (status.isEmpty() || status == null) {
			throw new Exception("Enter Vaild status");
		} else {
			count1++;
		}

	}

	private static void NumberCheck(int number) throws Exception {
		if (number == 0) {
			throw new Exception("Enter valid cab Number");
		} else {
			count1++;
		}
	}

	private static void MobileCheck(String mobile) throws Exception {
		int count2 = 0;
		char[] Mobile = mobile.toCharArray();
		if (mobile.length() > 10 || mobile.length() < 10) {

			throw new Exception("Enter Only 10 Number ");

		} else
			count1++;
		for (char i : Mobile) {
			if (Character.isAlphabetic(i)) {
				// count++;
				throw new Exception("Enter Only Numeric Value");

			} else
				count2++;

		}
		if (count2 == 11) {
			count1++;
		}

	}

	private static void EmailCheck(String email) throws Exception {
		if (email.contains("@gmail.com")) {
			count1++;
		} else {
			throw new Exception("Enter Vaild email");
		}

	}

	private static void NameCheck(String name) throws Exception {

		if (name.isEmpty() || name == null) {
			throw new Exception("Enter valid Name");
		} else {
			count1++;
		}
		if (count1 == 5) {
			log.info("Succesfully cab details Added...");
		}
	}

}
