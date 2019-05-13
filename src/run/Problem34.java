package run;

import java.util.ArrayList;

public class Problem34 implements Problem {

	int[] digitsFactorial = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };

	@Override
	public long get() {
		int bigsum = 0;
		for (int n = 10; n < 10000000; n++) {
			ArrayList<Integer> digits = Utils.stripDigits(n);
			int sum = 0;
			for (int i = 0; i < digits.size(); i++) {
				sum += digitsFactorial[digits.get(i)];
			}
			if (sum == n) {
				System.out.println(n);
				bigsum += n;
			}

		}
		return bigsum;
	}
}
