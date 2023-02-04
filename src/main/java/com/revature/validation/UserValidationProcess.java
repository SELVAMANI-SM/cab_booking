package com.revature.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.model.AddingUserConstructor;





public class UserValidationProcess {

	private static Logger log = LogManager.getLogger(UserValidationProcess.class);
	static int count = 0;

	public static void UserValidation(AddingUserConstructor user) throws Exception {
		NameCheck(user.getName());
		GenderCheck(user.getGender());
		AgeCheck(user.getAge());
		TypeCheck(user.getType());
		EmailCheck(user.getEmail());
		PasswordCheck(user.getPassword());
		MobileCheck(user.getMobile());
	}

	private static void MobileCheck(String string) throws Exception {
		int count1 = 0;
		char[] Mobile = string.toCharArray();
		if (string.length() > 10 || string.length() < 10) {

			throw new Exception("Enter Only 10 Number ");

		} else
			count1++;
		for (char i : Mobile) {
			if (Character.isAlphabetic(i)) {
				// count++;
				throw new Exception("Enter Only Numeric Value");

			} else
				count1++;

		}
		if (count1 == 11) {
			count++;
		}

	}

	private static void PasswordCheck(String password) throws Exception {
		if (password.length() < 8 || password.length() > 16)
			throw new Exception("Enter Vaild PassWord");
		else
			count++;
	}

	private static void EmailCheck(String email) throws Exception {
		if (email.contains("@gmail.com")) {
			count++;
		} else
			throw new Exception("Enter Valid Email");

	}

	private static void TypeCheck(String type) throws Exception {
		if (type.equals("employee") || type.equals("manager")) {
			count++;
		} else {
			throw new Exception("Enter valid Type employee/manager");
		}

	}

	private static void AgeCheck(int age) throws Exception {
		if (age == 0 && age >= 22) {
			throw new Exception("Enter Vaild Age");
		} else {
			count++;
		}

	}

	private static void GenderCheck(String gender) throws Exception {
		if (gender == null)
			throw new Exception("Enter Vaild Gender");
		else
			count++;

	}

	private static void NameCheck(String name) throws Exception {

		if (name == null)
			throw new Exception("Enter Vaild Name");
		else
			count++;

	}
}
