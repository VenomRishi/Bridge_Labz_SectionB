/******************************************************************************
 *  Purpose: Program is written for Printing Calendar by taking input month & year.
 *  		 
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   14-08-2019
 *
 ******************************************************************************/

package com.bridgelabz.StringFunction;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class Calendar {

	public static void main(String[] args) {
		Utility utility = new Utility();
		Scanner scanner = new Scanner(System.in);
		int month, year;
		boolean leapYear;
		int day, days;
		System.out.println("Enter month: ");
		month = scanner.nextInt();
		System.out.println("Enter Year: ");
		year = scanner.nextInt();
		if (utility.LeapYearValidation(year)) {
			leapYear = utility.leapYear(year);
			if (utility.checkValidationForDate(month, 1, leapYear)) {
				day = Utility.calculateDayOfWeek(1, month, year);
				days = Utility.daysOfMonth(month, leapYear);
				switch (day) {
				case 0:
					System.out.println("SUN MON TUE WED THU FRI SAT");
					for (int i = 1; i <= days; i++) {
						if (i <= 9) {
							System.out.print(i + "   ");
						} else {
							System.out.print(i + "  ");
						}
						if (i % 7 == 0) {
							System.out.println();
						}
					}
					break;
				case 1:
					System.out.println("SUN MON TUE WED THU FRI SAT");
					System.out.print("    ");
					for (int i = 1; i <= days; i++) {

						if (i <= 9) {
							System.out.print(i + "   ");
						} else {
							System.out.print(i + "  ");
						}
						if (i == 6 || i == 13 || i == 20 || i == 27) {
							System.out.println();
						}
					}
					break;
				case 2:
					System.out.println("SUN MON TUE WED THU FRI SAT");
					System.out.print("        ");
					for (int i = 1; i <= days; i++) {

						if (i <= 9) {
							System.out.print(i + "   ");
						} else {
							System.out.print(i + "  ");
						}
						if (i == 5 || i == 12 || i == 19 || i == 26) {
							System.out.println();
						}
					}
					break;
				case 3:
					System.out.println("SUN MON TUE WED THU FRI SAT");
					System.out.print("            ");
					for (int i = 1; i <= days; i++) {

						if (i <= 9) {
							System.out.print(i + "   ");
						} else {
							System.out.print(i + "  ");
						}
						if (i == 4 || i == 11 || i == 18 || i == 25) {
							System.out.println();
						}
					}
					break;
				case 4:
					System.out.println("SUN MON TUE WED THU FRI SAT");
					System.out.print("                ");
					for (int i = 1; i <= days; i++) {

						if (i <= 9) {
							System.out.print(i + "   ");
						} else {
							System.out.print(i + "  ");
						}
						if (i == 3 || i == 10 || i == 17 || i == 24) {
							System.out.println();
						}
					}
					break;
				case 5:
					System.out.println("SUN MON TUE WED THU FRI SAT");
					System.out.print("                    ");
					for (int i = 1; i <= days; i++) {

						if (i <= 9) {
							System.out.print(i + "   ");
						} else {
							System.out.print(i + "  ");
						}
						if (i == 2 || i == 9 || i == 16 || i == 23 || i == 30) {
							System.out.println();
						}
					}
					break;
				case 6:
					System.out.println("SUN MON TUE WED THU FRI SAT");
					System.out.print("                        ");
					for (int i = 1; i <= days; i++) {

						if (i <= 9) {
							System.out.print(i + "   ");
						} else {
							System.out.print(i + "  ");
						}
						if (i == 1 || i == 8 || i == 15 || i == 22 || i == 29) {
							System.out.println();
						}
					}
					break;
				}

			} else
				System.out.println("Enter valid month");
		} else
			System.out.println("Please enter valid year");
		scanner.close();

	}

}
