package run;

import java.util.ArrayList;

public class Problem30 implements Problem {
	@Override
	public long get() {
		int start = 2;
		int end = 1000000;
		int pow = 5;
		int sum = 0;
		for (int i = 2; i < end; i++) {
			ArrayList<Integer> digits = new ArrayList<Integer>();
			int n = i;
			while (n > 0) {
				digits.add(n % 10);
				n /= 10;
			}
			int digitPowSum = 0;
			for (int d : digits) {
				digitPowSum += (int) Math.pow(d, pow);
			}
			if (digitPowSum == i) {
				System.out.println(i);
				sum += i;
			}
		}
		return sum;
	}
}
