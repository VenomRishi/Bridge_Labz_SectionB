/******************************************************************************
 *  Purpose: This is utility file which contains logic of all programs.
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   13-08-2019
 *  @updated 14-08-2019
 *
 ******************************************************************************/

package com.bridgelabz.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Utility {

	/**
	 * Purpose: Method is written for finding String Anagram
	 * 
	 * @param str1Arr input from user
	 * @param str2Arr input from user
	 * @return true true if anagram else return false
	 */
	public static boolean findStringAnagram(char[] str1Arr, char[] str2Arr) {
		if (str1Arr.length != str2Arr.length) {
			return false;
		} else {
			Arrays.sort(str1Arr);
			Arrays.sort(str2Arr);
			for (int i = 0; i < str1Arr.length; i++) {
				if (str1Arr[i] != str2Arr[i]) {
					return false;
				}
			}
			return true;
		}

	}

	/**
	 * Purpose: Method is written for finding String Palindrom
	 * 
	 * @param str input from user
	 * @return true if String is palindrome else return false
	 */
	public static boolean findStringPalindrome(String str) {
		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}
		if (str != rev) {
			return false;
		} else
			return true;
	}

	/**
	 * Purpose: Method is written for Leap Year validation input accept from 1582 to
	 * 9999
	 * 
	 * @param year input is taken from user
	 * @return if leap year then true else false
	 */
	public boolean LeapYearValidation(int year) {
		if (year >= 1582 && year <= 9999)
			return true;
		return false;

	}

	/**
	 * Purpose: Method is written for Given Year is Leap Year or Not
	 * 
	 * @param year input is taken from user
	 * @return if leap year then true else false
	 */
	public boolean leapYear(int year) {

		if (year % 4 == 0 || year % 400 == 0 && year % 100 != 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Purpose: Method is written for Checking Validation leap Year or not and by
	 * Calendar wise it will give days back to method where definition is there
	 * 
	 * @param year input is taken from user
	 * @return if leap year then true else false
	 */
	public boolean checkValidationForDate(int month, int day, boolean leapYear) {

		switch (month) {
		case 1:
			if (day > 0 && day <= 31) {
				return true;
			} else {
				return false;
			}
		case 2:
			if (leapYear) {
				if (day > 0 && day <= 29) {
					return true;
				} else {
					return false;
				}

			} else {
				if (day > 0 && day <= 28) {
					return true;
				} else {
					return false;
				}
			}

		case 3:
			if (day > 0 && day <= 31) {
				return true;
			} else {
				return false;
			}
		case 4:
			if (day > 0 && day <= 30) {
				return true;
			} else {
				return false;
			}
		case 5:
			if (day > 0 && day <= 31) {
				return true;
			} else {
				return false;
			}
		case 6:
			if (day > 0 && day <= 30) {
				return true;
			} else {
				return false;
			}
		case 7:
			if (day > 0 && day <= 31) {
				return true;
			} else {
				return false;
			}
		case 8:
			if (day > 0 && day <= 31) {
				return true;
			} else {
				return false;
			}
		case 9:
			if (day > 0 && day <= 30) {
				return true;
			} else {
				return false;
			}
		case 10:
			if (day > 0 && day <= 31) {
				return true;
			} else {
				return false;
			}
		case 11:
			if (day > 0 && day <= 30) {
				return true;
			} else {
				return false;
			}
		case 12:
			if (day > 0 && day <= 31) {
				return true;
			} else {
				return false;
			}
		default:
			System.out.println("Please enter valid input");
		}
		return false;

	}

	/**
	 * Purpose: To Calculate Day Of a Week
	 * 
	 * @param day   input 1
	 * @param month input taken from user
	 * @param year  input taken from user
	 * @return dayOfWeek return day for week like Monday Tuesday
	 */
	public static int calculateDayOfWeek(int day, int month, int year) {
		int y1, x, m, d1;
		y1 = year - (14 - month) / 12;
		x = y1 + (y1 / 4) - (y1 / 100) + (y1 / 400);
		m = month + 12 * ((14 - month) / 12) - 2;
		d1 = (day + x + 31 * m / 12) % 7;
		return d1;
	}

	/**
	 * Purpose: Method will return how much days are there for month
	 * 
	 * @param month    input from user
	 * @param leapYear if leap year 29 days else 28 days
	 * @return days how much days are there for month
	 */
	public static int daysOfMonth(int month, boolean leapYear) {

		switch (month) {
		case 1:
			return 31;
		case 2:
			if (leapYear)
				return 29;
			else
				return 28;
		case 3:
			return 31;
		case 4:
			return 30;
		case 5:
			return 31;
		case 6:
			return 30;
		case 7:
			return 31;
		case 8:
			return 31;
		case 9:
			return 30;
		case 10:
			return 31;
		case 11:
			return 30;
		case 12:
			return 31;
		}
		return 0;

	}

	/**
	 * Purpose: find permutation using iteration
	 * 
	 * @param str
	 */
	static List<String> listPermutationIterative = new ArrayList<String>();

	public static void permutationIterative(String str) {

		// convert string to a character array (Since String is immutable)
		char[] chars = str.toCharArray();

		// Weight index control array
		int[] p = new int[str.length()];

		// i, j represents upper and lower bound index resp. for swapping
		int i = 1, j = 0;

		// Print given string, as only its permutations will be printed later
		System.out.print(str);
		listPermutationIterative.add(str);
		while (i < str.length()) {
			if (p[i] < i) {
				// if i is odd then j = p[i], otherwise j = 0
				j = (i % 2) * p[i];

				// swap(a[j], a[i])
				swap(chars, i, j);

				// Print current permutation
				System.out.print(" " + String.valueOf(chars));
				listPermutationIterative.add(String.valueOf(chars));
				p[i]++; // increase index "weight" for i by one
				i = 1; // reset index i to 1
			}
			// otherwise p[i] == i
			else {
				// reset p[i] to zero
				p[i] = 0;

				// set new index value for i (increase by one)
				i++;
			}
		}
	}

	/**
	 * Purpose: function to swap two characters in a character array
	 * 
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void swap(char[] arr, int i, int j) {
		char c = arr[i];
		arr[i] = arr[j];
		arr[j] = c;
	}

	/**
	 * Purpose: find permutation using recursion
	 * 
	 * @param str input from user
	 * @param ans empty string passed for computation
	 */
	static List<String> listPermutationRecursion = new ArrayList<String>();

	public static void permutationRecursion(String str, String ans) {

		// If string is empty
		if (str.length() == 0) {
			System.out.print(ans + " ");
			listPermutationRecursion.add(ans);
			return;
		}

		for (int i = 0; i < str.length(); i++) {

			// ith character of str
			char ch = str.charAt(i);

			// Rest of the string after excluding
			// the ith character
			String temp = str.substring(0, i) + str.substring(i + 1);

			// Recurvise call
			permutationRecursion(temp, ans + ch);
		}

	}

	public static void compareTwoPermutation() {
		Collections.sort(listPermutationIterative);
		// System.out.println(listPermutationIterative);
		Collections.sort(listPermutationRecursion);
		// System.out.println(listPermutationRecursion);
		if (listPermutationIterative.equals(listPermutationRecursion))
			System.out.println("Two permutation is equal");
		else
			System.out.println("Two permutation is not equal");
	}

//	mathematical function
	/**
	 * Purpose: Method for printing Harmonic series
	 * 
	 * @param number input from user
	 */
	public static void PrintHarmonic(int number) {
		System.out.print("H=");
		for (int i = 1; i <= number; i++) {
			if (i != number) {
				System.out.print("1/" + i);
				System.out.print(" + ");
			} else {
				System.out.print("1/" + i);
			}

		}

	}

	/**
	 * Purpose: To Perform Trigonometry operation on the basis of degree it will
	 * give radians
	 * 
	 * @param degree input is taken from user
	 * @return returns radian of that degree
	 */
	public static double findRadiun(int degree) {
		return Math.toRadians(degree);
	}

	/**
	 * Purpose: To find sin of trigonometry
	 * 
	 * @param radiun radian is taken from previous method
	 * @return returns sin of that radian
	 */
	public static double findSin(double radiun) {
		return Math.sin(radiun);
	}

	/**
	 * Purpose: To find cos of trigonometry
	 * 
	 * @param radiun radian is taken from previous method
	 * @return returns cos of that radian
	 */
	public static double findCos(double radiun) {
		return Math.cos(radiun);
	}

	/**
	 * Purpose: To find binary
	 * 
	 * @param radiun radian is taken from previous method
	 * @return returns cos of that radian
	 */
	public static String findBinary(int decimalNumber) {
		int mod;

		String x = "";
		if (decimalNumber > 255) {
			System.out.println("Enter Number between 1 to 255");
		} else {

			while (decimalNumber > 0) {
				mod = decimalNumber % 2;
				x = mod + "" + x;
				decimalNumber = decimalNumber / 2;
			}

		}
		return x;
	}

	/**
	 * Purpose: Finding Square root using newton's method
	 * 
	 * @param c input from user
	 * @return square root value of number using newton's method
	 */
	public static double findSquareRootUsingNewtonsMethod(int c, double epsilon) {
		double t;
		t = c;
//		epsilon=1*(Math.pow(10, -15));

		while (Math.abs(t - c / t) > epsilon * t) {
			t = (c / t + t) / 2.0;
		}
		return t;
	}

	/**
	 * Purpose: For finding prime number
	 * 
	 * @param number input from user
	 * @return true or false depending upon prime number or not
	 */
	public static boolean isPrime(int number) {
		if (number == 0 || number == 1) {
			return false;
		} else {
			for (int i = 2; i <= number / 2; i++) {
				if (number % i == 0) {
					return false;
				}
			}
			return true;
		}

	}

	/**
	 * Purpose: Find Factorial
	 * 
	 * @param number input taken from user
	 * @return fact factorial of number
	 */
	public static long CalculateFactorial(int number) {
		int fact = 1;
		for (int i = 1; i <= number; i++) {
			fact *= i;
		}
		return fact;
	}

	/**
	 * Purpose: compute future value depend upon cash, interest rate and tenure
	 * 
	 * @param c input from user
	 * @param r input from user
	 * @param t input from user
	 * @return return future value
	 */
	public static double futureValue(int c, int r, int t) {
		return c * Math.pow(1 + r, t);
	}

	/**
	 * Purpose: compute present value depend upon cash, interest rate and tenure
	 * 
	 * @param c input from user
	 * @param r input from user
	 * @param t input from user
	 * @return return present value
	 */
	public static double presentValue(int c, int r, int t) {
		return Math.pow(c / (1 + r), t);
	}

	/**
	 * Purpose: to find min value from array
	 * 
	 * @param numArr array from user
	 * @return min value
	 */
	public static int minValue(int[] numArr) {
		int temp = numArr[0] < numArr[1] ? numArr[0] : numArr[1];
		for (int i = 2; i < numArr.length; i++) {
			temp = temp < numArr[i] ? temp : numArr[i];
		}
		return temp;
	}

	/**
	 * Purpose: to find max value from array
	 * 
	 * @param numArr array from user
	 * @return max value
	 */
	public static int maxValue(int[] numArr) {
		int temp = numArr[0] > numArr[1] ? numArr[0] : numArr[1];
		for (int i = 2; i < numArr.length; i++) {
			temp = temp > numArr[i] ? temp : numArr[i];
		}
		return temp;
	}
	/**
	 * Purpose: return min value from string
	 * 
	 * @param strArr input from user
	 * @return	min from string
	 */
	public static String minValue(String[] strArr) {
		String temp;
		for(int i=0;i<strArr.length;i++) {
			for(int j=i+1;j<strArr.length;j++) {
				if(strArr[j].compareTo(strArr[i])<0) {
					temp = strArr[j];
					strArr[j] = strArr[i];
					strArr[i] = temp;
				}
			}
		}
		return strArr[0];
	}

	/**
	 * Purpose: return max value from string
	 * 
	 * @param strArr input from user
	 * @return	max from string
	 */
	public static String maxValue(String[] strArr) {
		String temp;
		int strArrLength=strArr.length;
		for(int i=0;i<strArr.length;i++) {
			for(int j=i+1;j<strArr.length;j++) {
				if(strArr[j].compareTo(strArr[i])<0) {
					temp = strArr[j];
					strArr[j] = strArr[i];
					strArr[i] = temp;
				}
			}
		}
		return strArr[strArrLength-1];
	}
	
	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 * @return
	 */
	public static boolean checkCollinearUsingSlope(int x1,int y1,int x2,int y2,int x3,int y3) {
		double slopeAB,slopeBC,slopeAC;
		slopeAB=(y2-y1)/(x2-x1);
		slopeBC=(y3-y2)/(x3-x2);
		slopeAC=(y3-y1)/(x3-x1);
		if(slopeAB==slopeBC) {
			if(slopeAB==slopeAC) {
				return true;
			}
		}
		return false;
	}

}
