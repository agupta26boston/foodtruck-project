package com.foodtruck.redfin;

import java.util.Calendar;

/**
 * Used to convert to Soda Mapped Values.  This is used in relation to the Soda API Client
 * and the expected query data types.  
 */
public class SodaDataMapper {
	/**
	 * Return the expected Soda Data Format for hour of day
	 * @param hourOfDay - The hour of day
	 * @return String representation of the hour of day (ex. 09:00)
	 */
	public static String convertHourFormat(int hourOfDay) {
		return 	((hourOfDay < 10) ? "0" + hourOfDay : hourOfDay) + ":00";
	}

	/**
	 * Used to convert a Calendar Day Of the Week to the Socrata's Endpoint
	 * Day of the week.  
	 * @param dayOfWeek - Calendar value for the day of the week (Ex. Friday, Tuesday)
	 * @return an int value representing the Socrata's value of the day of the week
	 */
	public static int convertToDayOfWeek(int dayOfWeek) {
		int dayOrder = -1;
		switch (dayOfWeek) {
		case Calendar.MONDAY: {
			dayOrder = 1;
			break;
		}
		case Calendar.TUESDAY: {
			dayOrder = 2;
			break;
		}
		case Calendar.WEDNESDAY: {
			dayOrder = 3;
			break;
		}
		case Calendar.THURSDAY: {
			dayOrder = 4;
			break;
		}
		case Calendar.FRIDAY: {
			dayOrder = 5;
			break;
		}
		case Calendar.SATURDAY: {
			dayOrder = 6;
			break;
		}
		case Calendar.SUNDAY: {
			dayOrder = 0;
			break;
		}
		}

		return dayOrder;
	}
}