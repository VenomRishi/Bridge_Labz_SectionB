package com.bridgelabz.library;

import com.bridgelabz.utility.StatsUtility;

public class StdStats {

	public static void main(String[] args) {
		StatsUtility utility=new StatsUtility();
		double[] arr= {10.4, 20.6, 5.6, 4.9, 8.7};
		System.out.println("MAX :"+utility.max(arr));
		System.out.println("MIN :"+utility.min(arr));
		System.out.println("MEAN :"+StatsUtility.mean(arr));
		System.out.println("VARIANCE :"+utility.variance(arr));
		System.out.println("STANDARD DEVIATION :"+utility.standardDeviation(arr));
		System.out.println("MEDIAN :"+StatsUtility.median(arr));

	}

}
