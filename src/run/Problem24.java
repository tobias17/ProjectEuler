package run;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem24 implements Problem {
	long[] array;
	int pntr = 0;
	boolean first = false;
	int max = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2;

	public Problem24() {
		array = new long[max];
	}

	@Override
	public long get() {
		gen(new ArrayList<Integer>());
		Arrays.sort(array);
		for (int i = max - 1000; i < max; i++) {
			System.out.println(array[i]);
		}
		return array[999999];
	}

	void gen(ArrayList<Integer> values) {
		if (values.size() >= 10) {
			long value = 0;
			for (int i = 0; i < values.size(); i++) {
				value += values.get(i) * Math.pow(10, i);
			}
			array[pntr] = value;
			pntr++;
			first = false;
			return;
		}
		for (int i = 0; i < 10; i++) {
			boolean notUsed = true;
			for (int num : values) {
				if (i == num) {
					if (first) {
						System.out.println("checking " + i + " against " + num + " - match found");
					}
					notUsed = false;
				} else {
					if (first) {
						System.out.println("checking " + i + " against " + num + " - ok to move on");
					}
				}
			}
			if (notUsed) {
				if (first) {
					System.out.println("moving on");
				}
				ArrayList<Integer> newValues = new ArrayList<Integer>(values);
				newValues.add(i);
				gen(newValues);
			} else {
				if (first) {
					System.out.println("skipping");
				}
			}
		}
	}
}
