/******************************************************************************
 *  Purpose: This is utility file which contains logic of all programs.
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   20-08-2019
 *
 ******************************************************************************/


package com.bridgelabz.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LibUtility {
	private static Random random; // pseudo-random number generator
	private static long seed; // pseudo-random number generator seed

	// static initializer
	static {
		// this is how the seed was set in Java 1.4
		seed = System.currentTimeMillis();
		random = new Random(seed);
	}

	// don't instantiate
	private LibUtility() {
	}

	/**
	 * Sets the seed of the pseudo-random number generator. This method enables you
	 * to produce the same sequence of "random" number for each execution of the
	 * program. Ordinarily, you should call this method at most once per program.
	 *
	 * @param s the seed
	 */
	public static void setSeed(long s) {
		seed = s;
		random = new Random(seed);
	}

	/**
	 * Returns the seed of the pseudo-random number generator.
	 *
	 * @return the seed
	 */
	public static long getSeed() {
		return seed;
	}

	/**
	 * Returns a random real number uniformly in [0, 1).
	 *
	 * @return a random real number uniformly in [0, 1)
	 */
	public static double uniform() {
		return random.nextDouble();
	}

	/**
	 * Returns a random integer uniformly in [0, n).
	 * 
	 * @param n number of possible integers
	 * @return a random integer uniformly between 0 (inclusive) and {@code n}
	 *         (exclusive)
	 * @throws IllegalArgumentException if {@code n <= 0}
	 */
	public static int uniform(int n) {
		if (n <= 0)
			throw new IllegalArgumentException("argument must be positive: " + n);
		return random.nextInt(n);
	}

	/**
	 * Returns a random long integer uniformly in [0, n).
	 * 
	 * @param n number of possible {@code long} integers
	 * @return a random long integer uniformly between 0 (inclusive) and {@code n}
	 *         (exclusive)
	 * @throws IllegalArgumentException if {@code n <= 0}
	 */
	public static long uniform(long n) {
		if (n <= 0L)
			throw new IllegalArgumentException("argument must be positive: " + n);

		// https://docs.oracle.com/javase/8/docs/api/java/util/Random.html#longs-long-long-long-
		long r = random.nextLong();
		long m = n - 1;

		// power of two
		if ((n & m) == 0L) {
			return r & m;
		}

		// reject over-represented candidates
		long u = r >>> 1;
		while (u + m - (r = u % n) < 0L) {
			u = random.nextLong() >>> 1;
		}
		return r;
	}

	///////////////////////////////////////////////////////////////////////////
	// STATIC METHODS BELOW RELY ON JAVA.UTIL.RANDOM ONLY INDIRECTLY VIA
	// THE STATIC METHODS ABOVE.
	///////////////////////////////////////////////////////////////////////////

	/**
	 * Returns a random real number uniformly in [0, 1).
	 * 
	 * @return a random real number uniformly in [0, 1)
	 * @deprecated Replaced by {@link #uniform()}.
	 */
	@Deprecated
	public static double random() {
		return uniform();
	}

	/**
	 * Returns a random integer uniformly in [a, b).
	 * 
	 * @param a the left endpoint
	 * @param b the right endpoint
	 * @return a random integer uniformly in [a, b)
	 * @throws IllegalArgumentException if {@code b <= a}
	 * @throws IllegalArgumentException if {@code b - a >= Integer.MAX_VALUE}
	 */
	public static int uniform(int a, int b) {
		if ((b <= a) || ((long) b - a >= Integer.MAX_VALUE)) {
			throw new IllegalArgumentException("invalid range: [" + a + ", " + b + ")");
		}
		return a + uniform(b - a);
	}

	/**
	 * Returns a random real number uniformly in [a, b).
	 * 
	 * @param a the left endpoint
	 * @param b the right endpoint
	 * @return a random real number uniformly in [a, b)
	 * @throws IllegalArgumentException unless {@code a < b}
	 */
	public static double uniform(double a, double b) {
		if (!(a < b)) {
			throw new IllegalArgumentException("invalid range: [" + a + ", " + b + ")");
		}
		return a + uniform() * (b - a);
	}

	/**
	 * Returns a random boolean from a Bernoulli distribution with success
	 * probability <em>p</em>.
	 *
	 * @param p the probability of returning {@code true}
	 * @return {@code true} with probability {@code p} and {@code false} with
	 *         probability {@code 1 - p}
	 * @throws IllegalArgumentException unless {@code 0} &le; {@code p} &le;
	 *                                  {@code 1.0}
	 */
	public static boolean bernoulli(double p) {
		if (!(p >= 0.0 && p <= 1.0))
			throw new IllegalArgumentException("probability p must be between 0.0 and 1.0: " + p);
		return uniform() < p;
	}

	/**
	 * Returns a random boolean from a Bernoulli distribution with success
	 * probability 1/2.
	 * 
	 * @return {@code true} with probability 1/2 and {@code false} with probability
	 *         1/2
	 */
	public static boolean bernoulli() {
		return bernoulli(0.5);
	}

	/**
	 * Returns a random real number from a standard Gaussian distribution.
	 * 
	 * @return a random real number from a standard Gaussian distribution (mean 0
	 *         and standard deviation 1).
	 */
	public static double gaussian() {
		// use the polar form of the Box-Muller transform
		double r, x, y;
		do {
			x = uniform(-1.0, 1.0);
			y = uniform(-1.0, 1.0);
			r = x * x + y * y;
		} while (r >= 1 || r == 0);
		return x * Math.sqrt(-2 * Math.log(r) / r);

		// Remark: y * Math.sqrt(-2 * Math.log(r) / r)
		// is an independent random gaussian
	}

	/**
	 * Returns a random real number from a Gaussian distribution with mean &mu; and
	 * standard deviation &sigma;.
	 * 
	 * @param mu    the mean
	 * @param sigma the standard deviation
	 * @return a real number distributed according to the Gaussian distribution with
	 *         mean {@code mu} and standard deviation {@code sigma}
	 */
	public static double gaussian(double mu, double sigma) {
		return mu + sigma * gaussian();
	}

	/**
	 * Returns a random integer from a geometric distribution with success
	 * probability <em>p</em>. The integer represents the number of independent
	 * trials before the first success.
	 * 
	 * @param p the parameter of the geometric distribution
	 * @return a random integer from a geometric distribution with success
	 *         probability {@code p}; or {@code Integer.MAX_VALUE} if {@code p} is
	 *         (nearly) equal to {@code 1.0}.
	 * @throws IllegalArgumentException unless {@code p >= 0.0} and {@code p <= 1.0}
	 */
	public static int geometric(double p) {
		if (!(p >= 0)) {
			throw new IllegalArgumentException("probability p must be greater than 0: " + p);
		}
		if (!(p <= 1.0)) {
			throw new IllegalArgumentException("probability p must not be larger than 1: " + p);
		}
		// using algorithm given by Knuth
		return (int) Math.ceil(Math.log(uniform()) / Math.log(1.0 - p));
	}

	/**
	 * Returns a random integer from a Poisson distribution with mean &lambda;.
	 *
	 * @param lambda the mean of the Poisson distribution
	 * @return a random integer from a Poisson distribution with mean {@code lambda}
	 * @throws IllegalArgumentException unless {@code lambda > 0.0} and not infinite
	 */
	public static int poisson(double lambda) {
		if (!(lambda > 0.0))
			throw new IllegalArgumentException("lambda must be positive: " + lambda);
		if (Double.isInfinite(lambda))
			throw new IllegalArgumentException("lambda must not be infinite: " + lambda);
		// using algorithm given by Knuth
		// see http://en.wikipedia.org/wiki/Poisson_distribution
		int k = 0;
		double p = 1.0;
		double expLambda = Math.exp(-lambda);
		do {
			k++;
			p *= uniform();
		} while (p >= expLambda);
		return k - 1;
	}

	/**
	 * Returns a random real number from the standard Pareto distribution.
	 *
	 * @return a random real number from the standard Pareto distribution
	 */
	public static double pareto() {
		return pareto(1.0);
	}

	/**
	 * Returns a random real number from a Pareto distribution with shape parameter
	 * &alpha;.
	 *
	 * @param alpha shape parameter
	 * @return a random real number from a Pareto distribution with shape parameter
	 *         {@code alpha}
	 * @throws IllegalArgumentException unless {@code alpha > 0.0}
	 */
	public static double pareto(double alpha) {
		if (!(alpha > 0.0))
			throw new IllegalArgumentException("alpha must be positive: " + alpha);
		return Math.pow(1 - uniform(), -1.0 / alpha) - 1.0;
	}

	/**
	 * Returns a random real number from the Cauchy distribution.
	 *
	 * @return a random real number from the Cauchy distribution.
	 */
	public static double cauchy() {
		return Math.tan(Math.PI * (uniform() - 0.5));
	}

	/**
	 * Returns a random integer from the specified discrete distribution.
	 *
	 * @param probabilities the probability of occurrence of each integer
	 * @return a random integer from a discrete distribution: {@code i} with
	 *         probability {@code probabilities[i]}
	 * @throws IllegalArgumentException if {@code probabilities} is {@code null}
	 * @throws IllegalArgumentException if sum of array entries is not (very nearly)
	 *                                  equal to {@code 1.0}
	 * @throws IllegalArgumentException unless {@code probabilities[i] >= 0.0} for
	 *                                  each index {@code i}
	 */
	public static int discrete(double[] probabilities) {
		if (probabilities == null)
			throw new IllegalArgumentException("argument array is null");
		double EPSILON = 1.0E-14;
		double sum = 0.0;
		for (int i = 0; i < probabilities.length; i++) {
			if (!(probabilities[i] >= 0.0))
				throw new IllegalArgumentException("array entry " + i + " must be nonnegative: " + probabilities[i]);
			sum += probabilities[i];
		}
		if (sum > 1.0 + EPSILON || sum < 1.0 - EPSILON)
			throw new IllegalArgumentException("sum of array entries does not approximately equal 1.0: " + sum);

		// the for loop may not return a value when both r is (nearly) 1.0 and when the
		// cumulative sum is less than 1.0 (as a result of floating-point roundoff
		// error)
		while (true) {
			double r = uniform();
			sum = 0.0;
			for (int i = 0; i < probabilities.length; i++) {
				sum = sum + probabilities[i];
				if (sum > r)
					return i;
			}
		}
	}

	/**
	 * Returns a random integer from the specified discrete distribution.
	 *
	 * @param frequencies the frequency of occurrence of each integer
	 * @return a random integer from a discrete distribution: {@code i} with
	 *         probability proportional to {@code frequencies[i]}
	 * @throws IllegalArgumentException if {@code frequencies} is {@code null}
	 * @throws IllegalArgumentException if all array entries are {@code 0}
	 * @throws IllegalArgumentException if {@code frequencies[i]} is negative for
	 *                                  any index {@code i}
	 * @throws IllegalArgumentException if sum of frequencies exceeds
	 *                                  {@code Integer.MAX_VALUE} (2<sup>31</sup> -
	 *                                  1)
	 */
	public static int discrete(int[] frequencies) {
		if (frequencies == null)
			throw new IllegalArgumentException("argument array is null");
		long sum = 0;
		for (int i = 0; i < frequencies.length; i++) {
			if (frequencies[i] < 0)
				throw new IllegalArgumentException("array entry " + i + " must be nonnegative: " + frequencies[i]);
			sum += frequencies[i];
		}
		if (sum == 0)
			throw new IllegalArgumentException("at least one array entry must be positive");
		if (sum >= Integer.MAX_VALUE)
			throw new IllegalArgumentException("sum of frequencies overflows an int");

		// pick index i with probabilitity proportional to frequency
		double r = uniform((int) sum);
		sum = 0;
		for (int i = 0; i < frequencies.length; i++) {
			sum += frequencies[i];
			if (sum > r)
				return i;
		}

		// can't reach here
		assert false;
		return -1;
	}

	/**
	 * Returns a random real number from an exponential distribution with rate
	 * &lambda;.
	 * 
	 * @param lambda the rate of the exponential distribution
	 * @return a random real number from an exponential distribution with rate
	 *         {@code lambda}
	 * @throws IllegalArgumentException unless {@code lambda > 0.0}
	 */
	public static double exp(double lambda) {
		if (!(lambda > 0.0))
			throw new IllegalArgumentException("lambda must be positive: " + lambda);
		return -Math.log(1 - uniform()) / lambda;
	}

	/**
	 * Rearranges the elements of the specified array in uniformly random order.
	 *
	 * @param a the array to shuffle
	 * @throws IllegalArgumentException if {@code a} is {@code null}
	 */
	public static void shuffle(Object[] a) {
		validateNotNull(a);
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int r = i + uniform(n - i); // between i and n-1
			Object temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	/**
	 * Rearranges the elements of the specified array in uniformly random order.
	 *
	 * @param a the array to shuffle
	 * @throws IllegalArgumentException if {@code a} is {@code null}
	 */
	public static void shuffle(double[] a) {
		validateNotNull(a);
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int r = i + uniform(n - i); // between i and n-1
			double temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	/**
	 * Rearranges the elements of the specified array in uniformly random order.
	 *
	 * @param a the array to shuffle
	 * @throws IllegalArgumentException if {@code a} is {@code null}
	 */
	public static void shuffle(int[] a) {
		validateNotNull(a);
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int r = i + uniform(n - i); // between i and n-1
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	/**
	 * Rearranges the elements of the specified array in uniformly random order.
	 *
	 * @param a the array to shuffle
	 * @throws IllegalArgumentException if {@code a} is {@code null}
	 */
	public static void shuffle(char[] a) {
		validateNotNull(a);
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int r = i + uniform(n - i); // between i and n-1
			char temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	/**
	 * Rearranges the elements of the specified subarray in uniformly random order.
	 *
	 * @param a  the array to shuffle
	 * @param lo the left endpoint (inclusive)
	 * @param hi the right endpoint (exclusive)
	 * @throws IllegalArgumentException if {@code a} is {@code null}
	 * @throws IllegalArgumentException unless
	 *                                  {@code (0 <= lo) && (lo < hi) && (hi <= a.length)}
	 * 
	 */
	public static void shuffle(Object[] a, int lo, int hi) {
		validateNotNull(a);
		validateSubarrayIndices(lo, hi, a.length);

		for (int i = lo; i < hi; i++) {
			int r = i + uniform(hi - i); // between i and hi-1
			Object temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	/**
	 * Rearranges the elements of the specified subarray in uniformly random order.
	 *
	 * @param a  the array to shuffle
	 * @param lo the left endpoint (inclusive)
	 * @param hi the right endpoint (exclusive)
	 * @throws IllegalArgumentException if {@code a} is {@code null}
	 * @throws IllegalArgumentException unless
	 *                                  {@code (0 <= lo) && (lo < hi) && (hi <= a.length)}
	 */
	public static void shuffle(double[] a, int lo, int hi) {
		validateNotNull(a);
		validateSubarrayIndices(lo, hi, a.length);

		for (int i = lo; i < hi; i++) {
			int r = i + uniform(hi - i); // between i and hi-1
			double temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	/**
	 * Rearranges the elements of the specified subarray in uniformly random order.
	 *
	 * @param a  the array to shuffle
	 * @param lo the left endpoint (inclusive)
	 * @param hi the right endpoint (exclusive)
	 * @throws IllegalArgumentException if {@code a} is {@code null}
	 * @throws IllegalArgumentException unless
	 *                                  {@code (0 <= lo) && (lo < hi) && (hi <= a.length)}
	 */
	public static void shuffle(int[] a, int lo, int hi) {
		validateNotNull(a);
		validateSubarrayIndices(lo, hi, a.length);

		for (int i = lo; i < hi; i++) {
			int r = i + uniform(hi - i); // between i and hi-1
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	// throw an IllegalArgumentException if x is null
	// (x can be of type Object[], double[], int[], ...)
	private static void validateNotNull(Object x) {
		if (x == null) {
			throw new IllegalArgumentException("argument is null");
		}
	}

	// throw an exception unless 0 <= lo <= hi <= length
	private static void validateSubarrayIndices(int lo, int hi, int length) {
		if (lo < 0 || hi > length || lo > hi) {
			throw new IllegalArgumentException("subarray indices out of bounds: [" + lo + ", " + hi + ")");
		}
	}
	
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
	 * @return min from string
	 */
	public static String minValue(String[] strArr) {
		String temp;
		for (int i = 0; i < strArr.length; i++) {
			for (int j = i + 1; j < strArr.length; j++) {
				if (strArr[j].compareTo(strArr[i]) < 0) {
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
	 * @return max from string
	 */
	public static String maxValue(String[] strArr) {
		String temp;
		int strArrLength = strArr.length;
		for (int i = 0; i < strArr.length; i++) {
			for (int j = i + 1; j < strArr.length; j++) {
				if (strArr[j].compareTo(strArr[i]) < 0) {
					temp = strArr[j];
					strArr[j] = strArr[i];
					strArr[i] = temp;
				}
			}
		}
		return strArr[strArrLength - 1];
	}

	/**
	 * Purpose: to find collinear slope or not
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 * @return
	 */
	public static boolean checkCollinearUsingSlope(int x1, int y1, int x2, int y2, int x3, int y3) {
		double slopeAB, slopeBC, slopeAC;
		slopeAB = (y2 - y1) / (x2 - x1);
		slopeBC = (y3 - y2) / (x3 - x2);
		slopeAC = (y3 - y1) / (x3 - x1);
		if (slopeAB == slopeBC) {
			if (slopeAB == slopeAC) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Purpose: to find collinear triangle or not
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 * @return
	 */
	public static boolean checkCollinearUsingArea(int x1, int y1, int x2, int y2, int x3, int y3) {
		int calculateTriangleCollinear;
		calculateTriangleCollinear = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);

		if (calculateTriangleCollinear == 0)
			return true;

		return false;
	}
	


}
