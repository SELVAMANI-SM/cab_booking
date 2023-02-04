package com.revature.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.model.CabBookingConstructor;



public class CabBookingValidation {
	private static Logger log = LogManager.getLogger(CabBookingValidation.class);
	static int count = 0;

	public static void validation(CabBookingConstructor cab) {
		EmployeeIdCheck(cab.getEmployeeId());
		PlaceCheck(cab.getPlace());
		BookingCheck(cab.getBooking());
	}

	private static void BookingCheck(String booking) {

		if (booking.isEmpty() || booking == null) {
			log.warn("Enter Booking As Request ");
		} else {
			count++;
		}
	}

	private static void PlaceCheck(String place) {

		if (place.isEmpty() || place == null) {
			log.warn("Enter valid place ");
		} else {
			count++;
		}
	}

	private static void EmployeeIdCheck(int employeeId) {
		if (employeeId == 0) {
			log.warn("Enter valid Employee ID ");
		} else {
			count++;
		}
		if (count == 3) {
			log.info("Succesfully applied for cab booking");
		}

	}
}
