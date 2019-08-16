/******************************************************************************
 *  Purpose: Program is written for finding Day Of The Week using static method.
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

public class DayOfWeek {
	public static void main(String[] args) {
		Utility utility=new Utility();
		Scanner scanner=new Scanner(System.in);
		int day,month,year,d1;
		boolean leapYear,isValidDate;
		System.out.println("Enter Day: ");
		day=scanner.nextInt();
		System.out.println("Enter Month: ");
		month=scanner.nextInt();
		System.out.println("Enter Year: ");
		year=scanner.nextInt();
		leapYear=utility.leapYear(year);//false
		isValidDate=utility.checkValidationForDate(month, day, leapYear);
		if(isValidDate) {
			d1=Utility.calculateDayOfWeek(day,month,year);
			
			switch(d1) {
				case 0:
					System.out.println("Day is Sunday");
					break;
				case 1:
					System.out.println("Day is Monday");
					break;
				case 2:
					System.out.println("Day is Tuesday");
					break;
				case 3:
					System.out.println("Day is Wednesday");
					break;
				case 4:
					System.out.println("Day is Thursday");
					break;
				case 5:
					System.out.println("Day is Friday");
					break;
				case 6:
					System.out.println("Day is Saturday");
					break;
			}
		}else {
			System.out.println("Invalid Date");
		}
		
		
		scanner.close();
	}	


}
