package run;

import java.util.HashSet;
import java.util.Set;

public class Problem32 implements Problem {
	@Override
	public long get() {
		Set<Integer> products = new HashSet<Integer>();
		for (int a = 1; a < 10000; a++) {
			for (int b = a; b < 10000; b++) {
				if (isPandigital(a, b, a * b)) {
					System.out.printf("a=%d, b=%d, c=%d\n", a, b, a * b);
					products.add(a * b);
				}
			}
		}
		int sum = 0;
		for (int n : products) {
			sum += n;
		}
		return sum;
	}

	boolean isPandigital(int a, int b, int c) {
		int cntr = 0;
		for (int d = 1; d <= 10000; d *= 10) {
			if (a / d != 0) {
				cntr++;
			}
			if (b / d != 0) {
				cntr++;
			}
			if (c / d != 0) {
				cntr++;
			}
		}
		if (cntr != 9) {
			return false;
		}
		boolean[] hasBeenUsed = new boolean[10];
		hasBeenUsed[0] = true;
		for (int d = 1; d <= 10000; d *= 10) {
			if (a / d != 0) {
				if (hasBeenUsed[a / d % 10]) {
					return false;
				} else {
					hasBeenUsed[a / d % 10] = true;
				}
			}
			if (b / d != 0) {
				if (hasBeenUsed[b / d % 10]) {
					return false;
				} else {
					hasBeenUsed[b / d % 10] = true;
				}
			}
			if (c / d != 0) {
				if (hasBeenUsed[c / d % 10]) {
					return false;
				} else {
					hasBeenUsed[c / d % 10] = true;
				}
			}
		}
		return true;
	}
}
