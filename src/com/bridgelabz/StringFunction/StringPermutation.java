package com.bridgelabz.StringFunction;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class StringPermutation {

	public static void main(String[] args) {
		String str;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter String");
		str=scanner.next();
		int strLength=str.length()-1;
		//Permutation with recursion
		System.out.println("Printing Recursive Permutation");
		Utility.permutationRecursion(str, 0, strLength);
		
		System.out.println("Printing Iterative Permutation");
		Utility.permutationIterative(str);
		scanner.close();

	}

}
