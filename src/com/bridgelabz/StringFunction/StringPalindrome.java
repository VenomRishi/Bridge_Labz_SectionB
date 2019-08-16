/******************************************************************************
 *  Purpose: Program is written for finding String Palindrome.
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

public class StringPalindrome {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String str;
		
		System.out.println("Enter String to find palidrome or not");
		str=scanner.next();
		if(!Utility.findStringPalindrome(str)) {
			System.out.println("String is palindrome");
		}else {
			System.out.println("String is not palindrome");
		}
		scanner.close();
		
	}

}
