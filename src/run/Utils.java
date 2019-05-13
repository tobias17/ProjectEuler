package run;

import java.util.ArrayList;
import java.util.HashMap;

public class Utils {
	public static long combineDigits(ArrayList<Integer> digits) {
		long n = 0;
		long m = 1;
		for (int d : digits) {
			n += d * m;
			m *= 10;
		}
		return n;
	}

	public static long combineDigitsLong(ArrayList<Long> digits) {
		long n = 0;
		long m = 1;
		for (long d : digits) {
			n += d * m;
			m *= 10;
		}
		return n;
	}

	public static long combineDigitsReversed(ArrayList<Integer> digits) {
		long n = 0;
		long m = 1;
		for (int i = digits.size() - 1; i >= 0; i--) {
			n += digits.get(i) * m;
			m *= 10;
		}
		return n;
	}

	public static int[] convertIntArrayList(ArrayList<Integer> integers) {
		int[] ret = new int[integers.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = integers.get(i).intValue();
		}
		return ret;
	}

	public static ArrayList<Integer> generatePrimes(int max) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		for (int i = 3; i < max; i += 2) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}
		return primes;
	}

	public static int[] generatePrimesArray(int max) {
		return convertIntArrayList(generatePrimes(max));
	}

	public static ArrayList<Integer> getDistinctPrimeFactors(int n) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		if (isPrime(n)) {
			return factors;
		}
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				if (n % i == 0) {
					factors.add(i);
					while (n % i == 0) {
						n /= i;
					}
				}
			}
		}
		return factors;
	}

	public static ArrayList<Integer> getDistinctPrimeFactors(int n, int[] primes) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		if (isPrime(n)) {
			return factors;
		}
		for (int i = 0; primes[i] <= n; i++) {
			if (n % primes[i] == 0) {
				factors.add(primes[i]);
				while (n % primes[i] == 0) {
					n /= primes[i];
				}
			}
		}
		return factors;
	}

	public static boolean isPalindromic(String s) {
		if (s.length() < 1) {
			return false;
		}
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - (i + 1))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPandigital(String s) {
		return isPandigital(s, 9);
	}

	public static boolean isPandigital(String s, int l) {
		if (s.length() != 9) {
			return false;
		}
		boolean[] hasBeenUsed = new boolean[10];
		hasBeenUsed[0] = true;
		for (int i = l + 1; i < 10; i++) {
			hasBeenUsed[i] = true;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('0', 0);
		for (int i = 1; i < 10; i++) {
			map.put(Integer.toString(i).charAt(0), i);
		}
		for (int i = 0; i < 9; i++) {
			if (hasBeenUsed[map.get(s.charAt(i))]) {
				return false;
			} else {
				hasBeenUsed[map.get(s.charAt(i))] = true;
			}
		}
		return true;
	}

	public static boolean isPermutationOf(String sOrig, String sCheck) {
		if (sOrig.length() != sCheck.length()) {
			return false;
		}
		for (int i = 0; i < sOrig.length(); i++) {
			char c = sOrig.charAt(i);
			if (sCheck.indexOf(c) < 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int d = 2; d <= Math.sqrt(n); d++) {
			if (n % d == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPrime(int n, int[] primes) {
		if (n <= 1) {
			return false;
		}
		for (int i = 0; primes[i] <= Math.sqrt(n); i++) {
			if (n % primes[i] == 0) {
				return false;
			}
		}
		return true;
	}

	public static ArrayList<Integer> stripDigits(int n) {
		ArrayList<Integer> digits = new ArrayList<Integer>();
		while (n > 0) {
			digits.add(n % 10);
			n /= 10;
		}
		return digits;
	}

}
