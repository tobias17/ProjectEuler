package run;

import java.util.Arrays;

public class Problem45 implements Problem {

	int toGen = 10000000;
	long[] triangle = new long[toGen];
	long[] pentagonal = new long[toGen];
	long[] hexagonal = new long[toGen];

	@Override
	public long get() {
		for (long n = 1; n <= toGen; n++) {
			triangle[(int) n - 1] = n * (n + 1) / 2;
			pentagonal[(int) n - 1] = n * (3 * n - 1) / 2;
			hexagonal[(int) n - 1] = n * (2 * n - 1);
		}
		Arrays.sort(triangle);
		Arrays.sort(pentagonal);
		Arrays.sort(hexagonal);
		for (int i = 285; i < toGen; i++) {
			if (Arrays.binarySearch(pentagonal, triangle[i]) >= 0 && Arrays.binarySearch(hexagonal, triangle[i]) >= 0) {
				return triangle[i];
			}
		}
		return -1;
	}
}
