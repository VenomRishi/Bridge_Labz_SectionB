package com.bridgelabz.BasicPrograms;

public class ReverseString {

	public static void main(String[] args) {
		String str="Hi how are you";
		String rev="";
		for(int i=str.length()-1;i>=0;i--) {
			rev=rev+str.charAt(i);
		}
		System.out.println(rev);

	}

}
