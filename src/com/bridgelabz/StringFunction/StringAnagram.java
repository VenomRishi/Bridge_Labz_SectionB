/******************************************************************************
 *  Purpose: Program is written for finding String anagram.
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

public class StringAnagram {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		String str1,str2;
		
		char [] str1Arr, str2Arr;
		
		System.out.println("Enter first string: ");
		str1=scanner.next();
		System.out.println("Enter second string: ");
		str2=scanner.next();
		str1Arr=str1.toCharArray();
		str2Arr=str2.toCharArray();
		if(Utility.findStringAnagram(str1Arr,str2Arr)) {
			System.out.println("Strings are anagram");
		}else {
			System.out.println("Strings are not anagram");
		}
		scanner.close();

	}

}
