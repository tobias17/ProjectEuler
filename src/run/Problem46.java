package run;

import java.util.ArrayList;

public class Problem46 implements Problem {
	@Override
	public long get() {
		int searchSize = 1000000;

		ArrayList<Integer> primesList = Utils.generatePrimes(searchSize);
		int[] primes = Utils.convertIntArrayList(primesList);

		for (int n = 33; n < searchSize; n += 2) {
			if (!Utils.isPrime(n, primes)) {
				boolean works = false;
				for (int i = 0; primes[i] < n && !works; i++) {
					int diff = (n - primes[i]);
					int sqrt = (int) Math.sqrt(diff / 2);
					if (Math.pow(sqrt, 2) * 2 == diff) {
						works = true;
					}
					System.out.printf("n: %d, primes[i]: %d, diff: %d, sqrt: %d, works: %b\n", n, primes[i], diff, sqrt, works);
				}
				if (!works) {
					return n;
				}
			}
		}
		return -1;
	}
}
