package run;

public class Problem47 implements Problem {
	@Override
	public long get() {
		int[] primes = Utils.convertIntArrayList(Utils.generatePrimes(100000));
		int cntr = 0;
		int distinctPrimes = 4;
		int inARow = 4;
		for (int i = 10; i < 100000000; i++) {
			if (Utils.getDistinctPrimeFactors(i, primes).size() == distinctPrimes) {
				cntr++;
			} else {
				cntr = 0;
			}
			if (cntr == inARow) {
				return i - inARow + 1;
			}
		}
		return -1;
	}
}
