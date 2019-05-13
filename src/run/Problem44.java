package run;

import java.util.Arrays;

public class Problem44 implements Problem {

	int toGen = 10000;
	int[] pentNumbers = new int[toGen];

	@Override
	public long get() {
		for (int n = 1; n <= toGen; n++) {
			pentNumbers[n - 1] = n * (3 * n - 1) / 2;
			// System.out.println(pentNumbers[n - 1]);
		}
		int min = 1000000000;
		int minj = 0;
		int mink = 0;
		Arrays.sort(pentNumbers);
		for (int add = 1; add < toGen - 20; add++) {
			for (int j = 0, k = j + add; k < toGen; j++, k++) {
				int sum = pentNumbers[j] + pentNumbers[k];
				int diff = pentNumbers[k] - pentNumbers[j];
				if (Arrays.binarySearch(pentNumbers, sum) >= 0 && Arrays.binarySearch(pentNumbers, diff) >= 0) {
					if (Math.abs(diff) < min) {
						min = Math.abs(diff);
						minj = pentNumbers[j];
						mink = pentNumbers[k];
					}
				}
			}
		}
		System.out.println(minj);
		System.out.println(mink);
		return min;
	}
}
