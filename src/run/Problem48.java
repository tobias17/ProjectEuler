package run;

import java.util.ArrayList;

public class Problem48 implements Problem {
	@Override
	public long get() {
		int[] last10Digits = new int[10];
		for (int i = 1; i <= 1000; i++) {
			int[] selfPower = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 };
			for (int c = 0; c < i; c++) {

				int carry = 0;
				for (int j = 9; j >= 0; j--) {
					int result = selfPower[j] * i + carry;
					if (result >= 10) {
						carry = result / 10;
						result = result % 10;
					} else {
						carry = 0;
					}
					selfPower[j] = result;
				}

			}
			System.out.print(i + "^" + i + ": ");
			for (int k : selfPower) {
				System.out.print(k);
			}
			System.out.println();
			int carry = 0;
			for (int j = 9; j >= 0; j--) {
				int result = last10Digits[j] + selfPower[j] + carry;
				if (result > 10) {
					carry = result / 10;
					result = result % 10;
				} else {
					carry = 0;
				}
				last10Digits[j] = result;
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = last10Digits.length - 1; i >= 0; i--) {
			list.add(last10Digits[i]);
		}
		return Utils.combineDigits(list);
	}
}
