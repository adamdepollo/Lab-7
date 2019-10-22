/*
 * @Adam DePollo 10/21/19
 */
package co.grandcircus;

import java.util.Scanner;

public class Lab7 {

	public static void main(String[] args) {
		// Create a scanner and String to use to continually loop the program
		Scanner scnr = new Scanner(System.in);
		String cont = "y";

		// Create a do-while loop to continue based on user input
		do {
			// Present user with an option of validation tests
			pickTest();

			// Take user input
			int userChoice = scnr.nextInt();

			// Clear scanner
			scnr.nextLine();

			// Prompt them for input based on their test choice
			promptUser(userChoice);

			// Take user input for validation test
			String userEntry = scnr.nextLine();

			// Loop continually until user enters a valid string using validateEntry method
			do {
				//If invalid, tell user entry was invalid and take new input
				System.out.println("Whoops, invalid input! Try again:");
				userEntry = scnr.nextLine();
				continue;
			} while (!validateEntry(userChoice, userEntry));
			
			//If valid, let them know
			System.out.println("Good job, valid input!");
			System.out.println();

			// Ask user whether to continue
			System.out.println("Go again? (y/n)");
			cont = scnr.nextLine();
		} while (cont.equalsIgnoreCase("y"));

		// Close scanner
		scnr.close();

	}

	//Present user with test options
	public static void pickTest() {
		System.out.println("Which test would you like to run? (pick a number)");
		System.out.println("1. Validate Name");
		System.out.println("2. Validate Email");
		System.out.println("3. Validate Phone Number");
		System.out.println("4. Validate Date");
		System.out.println("5. Validate HTML Tag");
	}

	//Prompt user for appropriate string input based on their validation test choice
	public static void promptUser(int userChoice) {
		switch (userChoice) {
		case 1:
			System.out.println("Enter a name starting with a capital letter and less than 30 characters: ");
			break;
		case 2:
			System.out.println("Enter an email address in the name@website.url format:");
			break;
		case 3:
			System.out.println("Enter a phone number in the xxx-xxx-xxxx format:");
			break;
		case 4:
			System.out.println("Enter a date in the mm/dd/yyyy format:");
			break;
		case 5:
			System.out.println("Enter an HTML element in the <x1> </x1> format:");
			break;
		}
	}

	//Create method to validate the user's entry for proper format using RegEx
	public static boolean validateEntry(int userChoice, String userEntry) {
		boolean b = true;
		switch (userChoice) {
		case 1:
			//Name in "Name" format
			b = userEntry.matches("[A-Z]{1}[a-z]{1,29}");
			break;
		case 2:
			//email in name@website.com format
			b = userEntry.matches("[A-Za-z\\d]{5,30}\\b@\\w[A-Za-z\\d]{5,10}\\b\\.\\w[A-Za-z\\d]{1,3}");
			break;
		case 3:
			//Phone number in xxx-xxx-xxxx format
			b = userEntry.matches("\\d[111,999]\\b-\\d[111,999\\b-\\d[1111,9999]");
			break;
		case 4:
			//Date in mm/dd/yyyy format (up to 12/31/2019)
			b = userEntry.matches("\\d[1,12]\\b/\\d[1,31]\\b/\\d[0,2019]");
			break;
		case 5:
			//in <x#> <x#> format
			b = userEntry.matches("<[a-z]{1}\\d{0,1}> <\\/[a-z]{1}\\d{0,1}>");
			break;
		}
		return b;
	}
}
