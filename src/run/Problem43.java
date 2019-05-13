package run;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem43 implements Problem {

	long[] checks = { 2, 3, 5, 7, 11, 13, 17 };
	long sum = 0;

	@Override
	public long get() {
		ArrayList<Long> list = new ArrayList<Long>();
		generatePandigital(list, new boolean[10], 10);
		return sum;
	}

	void generatePandigital(ArrayList<Long> digits, boolean[] used, int depth) {
		if (depth <= 0) {
			if (works(digits)) {
				sum += Utils.combineDigitsLong(digits);
			}
			return;
		}
		for (long i = 0; i < 10; i++) {
			if (!used[(int) i]) {
				boolean[] newUsed = Arrays.copyOf(used, 10);
				newUsed[(int) i] = true;
				ArrayList<Long> newDigits = new ArrayList<Long>(digits);
				newDigits.add(i);
				generatePandigital(newDigits, newUsed, depth - 1);
			}
		}
	}

	boolean works(ArrayList<Long> digits) {
		if (digits.size() != 10) {
			System.out.println("Wrong size!!!");
			return false;
		}
		for (int i = 0; i < 7; i++) {
			long num = digits.get(8 - i) * 100 + digits.get(7 - i) * 10 + digits.get(6 - i);
			if (num % checks[i] != 0) {
				return false;
			}
		}
		System.out.println(Utils.combineDigitsLong(digits));
		for (int i = 0; i < 7; i++) {
			long num = digits.get(8 - i) * 100 + digits.get(7 - i) * 10 + digits.get(6 - i);
			System.out.printf("   check %d: %d mod %d = %d\n", i + 1, num, checks[i], num % checks[i]);
		}
		return true;
	}

}
