package run;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem41 implements Problem {

	ArrayList<Integer> list = new ArrayList<Integer>();

	@Override
	public long get() {
		for (int n = 9; n >= 2; n--) {
			list = new ArrayList<Integer>();
			createPandigitals(0, new boolean[9], n, n);
			for (int i = list.size() - 1; i >= 0; i--) {
				if (Utils.isPrime(list.get(i))) {
					return list.get(i);
				}
			}
		}
		return -1;
	}

	void createPandigitals(int i, boolean[] used, int depth, int max) {
		if (depth <= 0) {
			list.add(i);
			return;
		}
		for (int n = 1; n <= max; n++) {
			if (!used[n - 1]) {
				boolean[] newUsed = Arrays.copyOf(used, 9);
				newUsed[n - 1] = true;
				createPandigitals(i * 10 + n, newUsed, depth - 1, max);
			}
		}
	}
}
