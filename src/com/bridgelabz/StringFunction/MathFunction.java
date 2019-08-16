package com.bridgelabz.StringFunction;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class MathFunction {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter \n1.Basic Maths\n" + "2.sqrt using newtons method\n" + "3.prime number\n"
				+ "4.factorial number\n" + "5.calculate future and present value\n" + "6.integer min max value\n" + "7.string min max value\n"
				+ "8.collinear slope and area");
		int choice;
		choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println(
					"Enter\na.harmonic number\n" + "b.sin of angle\n" + "c.cosine of angle\n" + "d.binary number");
			char option;
			option = scanner.next().charAt(0);
			switch (option) {
			case 'a':
				System.out.println("Enter number for harmonic number");
				int number = scanner.nextInt();
				Utility.PrintHarmonic(number);
				break;
			case 'b':
				System.out.println("Enter angle to find sin");
				int angle = scanner.nextInt();
				double radian = Utility.findRadiun(angle);
				double sin = Utility.findSin(radian);
				System.out.println("Sin(" + angle + ") = " + sin);
				break;
			case 'c':
				System.out.println("Enter angle to find cosine");
				int angle2 = scanner.nextInt();
				double radian2 = Utility.findRadiun(angle2);
				double cos = Utility.findSin(radian2);
				System.out.println("Cos(" + angle2 + ") = " + cos);
				break;
			case 'd':
				int decimalNumber;
				System.out.println("Enter a number");
				decimalNumber = scanner.nextInt();
				System.out.println("Binary is: " + Utility.findBinary(decimalNumber));
				break;
			}
			break;
		case 2:
			System.out.println("Enter number to find sqrt using newtons method");
			int c = scanner.nextInt();
			double epsilon = 1e-15;
			System.out.println(Utility.findSquareRootUsingNewtonsMethod(c, epsilon));
			break;
		case 3:
			System.out.println("Enter number to find prime number");
			int number2 = scanner.nextInt();

			if (Utility.isPrime(number2)) {
				System.out.println("Prime number");
			} else {
				System.out.println("Not Prime");
			}
			break;
		case 4:
			System.out.println("Enter number to find factorial");
			int number3 = scanner.nextInt();
			System.out.println(Utility.CalculateFactorial(number3));
			break;
		case 5:
			System.out.println("Calculate present and future value");
			System.out.println("Enter amount");
			int camount=scanner.nextInt();
			System.out.println("Enter interest rate");
			int r=scanner.nextInt();
			System.out.println("Enter Year:");
			int t=scanner.nextInt();
			t=t*12;
			double futureValue=Utility.futureValue(camount, r, t);
			double presentValue=Utility.presentValue(camount, r, t);
			System.out.println("Future values is: "+futureValue);
			System.out.println("Present values is: "+presentValue);;
			break;
		case 6:
			System.out.println("Printing min and max from integer array");
			//min max from integer array
			int [] numberArray= {1,6,4,2,5};
			int min=Utility.minValue(numberArray);
			System.out.println("Min from array is: "+min);
			int max=Utility.maxValue(numberArray);
			System.out.println("Max from array is: "+max);
			break;
		case 7:
			System.out.println("Printing min and max from string array");
			String[] strArr= {"Mustakim","Vicky","Wasim","Rishikesh"};
			String minString=Utility.minValue(strArr);
			String maxString=Utility.maxValue(strArr);
			System.out.println("Min String from array is: "+minString);
			System.out.println("Max String from array is: "+maxString);
			break;
		case 8:
			
		}

		scanner.close();

	}

}
