package run;

public class Problem23 implements Problem {
	@Override
	public long get() {
		int searchSize = 28123;
		boolean[] abundantNumbers = new boolean[searchSize];
		for (int i = 12; i < searchSize; i++) {
			if (getSumOfProperDivisors(i) > i) {
				abundantNumbers[i] = true;
			}
		}
		boolean[] sumOfTwoAbundantNumbers = new boolean[searchSize];
		for (int i = 12; i < searchSize; i++) {
			for (int j = i; i + j < searchSize; j++) {
				if (abundantNumbers[i] && abundantNumbers[j]) {
					sumOfTwoAbundantNumbers[i + j] = true;
				}
			}
		}
		long sum = 0;
		for (int i = 1; i < searchSize; i++) {
			if (!sumOfTwoAbundantNumbers[i]) {
				sum += i;
			}
		}
		return sum;
	}

	long getSumOfProperDivisors(long v) {
		long sum = 1;
		for (int i = 2; i <= Math.sqrt(v); i++) {
			if (v % i == 0) {
				if (Math.sqrt(v) == i) {
					sum += i;
				} else {
					sum += i + v / i;
				}
			}
		}
		return sum;
	}
}
