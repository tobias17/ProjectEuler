package run;

import java.util.ArrayList;

public class Problem25 implements Problem {
	@Override
	public long get() {
		ArrayList<Integer> num1 = new ArrayList<Integer>();
		ArrayList<Integer> num2 = new ArrayList<Integer>();
		num1.add(1);
		num2.add(1);
		long cntr = 3;
		while (true) {
			ArrayList<Integer> num3 = new ArrayList<Integer>();
			int carry = 0;
			for (int i = 0; i < num2.size(); i++) {
				int val = 0;
				if (i >= num1.size()) {
					val = num2.get(i) + carry;
				} else {
					val = num1.get(i) + num2.get(i) + carry;
				}
				if (val >= 10) {
					carry = val / 10;
					val = val % 10;
				} else {
					carry = 0;
				}
				num3.add(val);
			}
			if (carry > 0) {
				num3.add(carry);
			}
			if (num3.size() >= 1000) {
				return cntr;
			}
			num1 = num2;
			num2 = num3;
			cntr++;
		}
	}
}
