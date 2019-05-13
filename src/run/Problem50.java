package run;

import java.util.Arrays;

public class Problem50 implements Problem {
	@Override
	public long get() {
		int[] primes = Utils.convertIntArrayList(Utils.generatePrimes(1000000));
		Arrays.sort(primes);

		int max = 0;
		int maxAmnt = 0;
		for (int offset = 0; offset < 1000; offset++) {
			int currAmnt = 0;
			for (int i = 0; i + offset < primes.length; i++) {
				currAmnt += primes[i + offset];
				if (currAmnt >= 1000000) {
					break;
				}
				if (i > max && Utils.isPrime(currAmnt, primes)) {
					max = i;
					maxAmnt = currAmnt;
				}
			}
		}

		return maxAmnt;
	}
}
