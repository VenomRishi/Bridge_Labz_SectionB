package com.bridgelabz.StringFunction;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class MathFunction {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter \n1.Basic Maths\n" + "2.sqrt using newtons method\n" + "3.prime number\n"
				+ "4.factorial number\n" + "5.calculate future value\n" + "6.calculate present value\n"
				+ "7.min value\n" + "8.max value\n" + "9.collinear slope and area");
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
			
			if(Utility.isPrime(number2)) {
				System.out.println("Prime number");
			}else {
				System.out.println("Not Prime");
			}
			break;
		case 4:
			System.out.println("Enter number to find factorial");
			int number3 = scanner.nextInt();			
			System.out.println(Utility.CalculateFactorial(number3));
			break;
		case 5:
			
			break;

		}

		scanner.close();

	}

}
