package run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

class PrimeCalculator {

	int[] primes;

	public PrimeCalculator(int max) {
		ArrayList<Integer> primesList = new ArrayList<Integer>();
		primesList.add(2);
		primesList.add(3);
		for (int n = 5; n < max; n += 2) {
			boolean worked = true;
			for (int i = 0; primesList.get(i) <= Math.sqrt(n); i++) {
				if (n % primesList.get(i) == 0) {
					worked = false;
					break;
				}
			}
			if (worked) {
				primesList.add(n);
			}
		}
		primes = Utils.convertIntArrayList(primesList);
	}

	public int getLength() {
		return primes.length;
	}

	public TreeMap<Integer, Integer> getPrimeFactors(int n) {
		return getPrimeFactors((long) n);
	}

	public TreeMap<Integer, Integer> getPrimeFactors(long n) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

		if (n <= 1) {
			return map;
		}

		for (int i = 0; i < primes.length && n > 1; i++) {
			int div = primes[i];
			while (n % div == 0) {
				if (map.containsKey(div)) {
					map.put(div, map.get(div) + 1);
				} else {
					map.put(div, 1);
				}
				n /= div;
			}
		}
		if (n > 1) {
			map.put(-1, 1);
		}

		return map;
	}

	public boolean isPrime(long n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 0; primes[i] <= Math.sqrt(n); i++) {
			if (n % primes[i] == 0) {
				return false;
			}
			if (i >= primes.length - 1) {
				extend(n);
			}
		}
		return true;
	}

	private void extend(long dist) {
		ArrayList<Integer> primesList = new ArrayList<Integer>();
		for (int n = primes[primes.length - 1] + 2; n <= Math.sqrt(dist); n++) {
			boolean worked = true;
			for (int d = 2; d <= Math.sqrt(n) && worked; d++) {
				if (n % d == 0) {
					worked = false;
				}
			}
			if (worked) {
				primesList.add(n);
			}
		}
		int oldSize = primes.length;
		primes = Arrays.copyOf(primes, oldSize + primesList.size());
		for (int i = 0; i + oldSize < primes.length; i++) {
			primes[i + oldSize] = primesList.get(i);
		}
	}

}