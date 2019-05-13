package run;

public class Problem49 implements Problem {
	@Override
	public long get() {
		int[] primes = Utils.convertIntArrayList(Utils.generatePrimes(1000));

		for (int n = 1000; n < 5000; n++) {
			for (int a = 3330; a < 3334 && n + a * 2 < 10000; a++) {
				if (Utils.isPrime(n, primes) && Utils.isPrime(n + a, primes) && Utils.isPrime(n + a * 2, primes)) {
					String s1 = Integer.toString(n);
					String s2 = Integer.toString(n + a);
					String s3 = Integer.toString(n + a * 2);
					if (Utils.isPermutationOf(s1, s1) && Utils.isPermutationOf(s1, s3)) {
						System.out.println(s1 + " " + s2 + " " + s3);
					}
				}
			}
		}

		return -1;
	}
}
