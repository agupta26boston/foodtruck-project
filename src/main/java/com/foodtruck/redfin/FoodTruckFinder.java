package com.foodtruck.redfin;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;

/**
 * Console Application used to find open food trucks in SF
 */
public class FoodTruckFinder {
	public static void main(String[] args) {
		SodaApiClient client = new SodaApiClient();
		FoodTruckFinder app = new FoodTruckFinder();
		
		// Set the time zone to PT
        TimeZone pacificTimeZone = TimeZone.getTimeZone("America/Los_Angeles");

		Calendar calender = Calendar.getInstance();
		calender.setTimeZone(pacificTimeZone);
		int dayOrder = SodaDataMapper.convertToDayOfWeek(calender.get(Calendar.DAY_OF_WEEK));

		int hourOfDay =  calender.get(Calendar.HOUR_OF_DAY);
		String currentTime = SodaDataMapper.convertHourFormat(hourOfDay);
		
		// Used to manage paging
		int previousOffset = 0;
		int currentOffset = 0;
		
		Scanner sc = new Scanner(System.in);
		String userInput;
		
		System.out.println("Welcome to the Food Truck Finder");
		System.out.println("------------------------------------------------------------------------------------------------------");

		do {
			previousOffset = currentOffset;
			List<FoodTruck> foodTrucks = client.getFoodTruck(currentOffset, 10, dayOrder, currentTime);
			System.out.println("\nDate: " + calender.getTime());
			
			app.printFoodTruckList(foodTrucks, currentOffset);
			currentOffset += foodTrucks.size();
			
			System.out.println("Options: 'q' quit, 'p' previous page, 'n' next page");
			System.out.print("Please enter what you would like to do next: ");

			userInput = sc.nextLine();

			// input validation 
			while (!userInput.equals("p") && !userInput.equals("n") && !userInput.equals("q")) {
				System.out.print(userInput + " is not a valid input.  Please try again: ");
				userInput = sc.nextLine();
			}

			if (userInput.equals("p")) {
				int prev = previousOffset - 10;
				currentOffset = (prev < 0) ? 0 : prev;
			} else if (userInput.equals("n")) {
				// do nothing since currentOffset has already been incremented
			}
		} while (!userInput.equals("q"));

		System.out.println("\nThank you for using Food Truck Finder.");
		sc.close();
	}

	private void printFoodTruckList(List<FoodTruck> list, int offset) {
		String format2 = String.format("%-3s %-75s %-8s", "", "Name", "Address");
		System.out.println(format2);
		System.out.println("------------------------------------------------------------------------------------------------------");

		if (list.size() == 0) {
			System.out.println("Sorry there is no more food trucks open at this time.");
		}

		for (FoodTruck f : list) {
			String format = String.format("%-3s %-75s %-8s", (offset++ + 1), f.getApplicant(),
					f.getLocation());
			System.out.println(format);
		}
		System.out.println("------------------------------------------------------------------------------------------------------");
	}

	

	
}