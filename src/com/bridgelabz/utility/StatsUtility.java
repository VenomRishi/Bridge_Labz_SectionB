/******************************************************************************
 *  Purpose: This is utility file which contains logic of all programs.
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   20-08-2019
 *
 ******************************************************************************/

package com.bridgelabz.utility;

import java.util.Arrays;

public class StatsUtility {
	public double max(double[] arr) {
		double max = arr[0];
		for (int i = 1; i <= arr.length-1; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	public double min(double[] arr) {
		double min = arr[0];
		for (int i = 1; i <= arr.length-1; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}

	public static double mean(double[] arr) {
		double sum = 0;
		for (int i = 0; i <= arr.length-1; i++) {
			sum = sum + arr[i];
		}
		return sum / (arr.length + 1);
	}

	public double variance(double[] arr) {

		int n = arr.length + 1;
		double mean = mean(arr);
		double[] tempArr = new double[n];
		for (int i = 0; i < arr.length; i++) {
			tempArr[i] = arr[i] - mean;

		}
		for (int i = 0; i < arr.length; i++) {
			tempArr[i] = Math.pow(Math.abs(tempArr[i]), 2);

		}

		double sumTempArr = 0;
		for (int i = 0; i < tempArr.length; i++) {
			sumTempArr += tempArr[i];
		}

		return sumTempArr / (n - 1);

	}

	public double standardDeviation(double[] arr) {
		return Math.sqrt(variance(arr));
	}

	public static double median(double[] arr) {
		// First we sort the array
		Arrays.sort(arr);
		int n = arr.length;
		// check for even case
		if (n % 2 != 0)
			return (double) arr[n / 2];

		return (double) (arr[(n - 1) / 2] + arr[n / 2]) / 2.0;
	}
}
