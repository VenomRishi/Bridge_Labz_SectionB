package com.bridgelabz.StringFunction;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class StringPermutation {

	public static void main(String[] args) {
		String str;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter String");
		str=scanner.next();
		
		System.out.println("Printing Iterative Permutation");
		Utility.permutationIterative(str);
		
		System.out.println("Printing Recursive Permutation");
		Utility.permutationRecursion(str, "");
		
		Utility.compareTwoPermutation();
		
		scanner.close();

	}

}
