package run;

import java.util.ArrayList;

public class Problem35 implements Problem {
	@Override
	public long get() {
		int start = 2;
		int end = 1000000;
		int cntr = 0;
		for (int i = start; i < end; i++) {
			if (isCircularPrime(i)) {
				cntr++;
				System.out.println(i);
			}
		}
		return cntr;
	}

	boolean isCircularPrime(int n) {
		ArrayList<Integer> digits = Utils.stripDigits(n);
		for (int i = 0; i < digits.size(); i++) {
			if (!Utils.isPrime((int) Utils.combineDigits(digits))) {
				return false;
			}
			digits.add(0, digits.get(digits.size() - 1));
			digits.remove(digits.size() - 1);
		}
		return true;
	}
}
