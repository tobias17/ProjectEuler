package run;

public class Problem52 implements Problem {
	@Override
	public long get() {
		for (long i = 10; i < 1000000000; i++) {
			if (works(i)) {
				for (int m = 1; m <= 6; m++) {
					System.out.println(i * m);
				}
				return i;
			}
		}
		return -1;
	}

	boolean works(long v) {
		String x = Long.toString(v);
		String x6 = Long.toString(v * 6);
		if (x.length() != x6.length()) {
			return false;
		}
		String x2 = Long.toString(v * 2);
		String x3 = Long.toString(v * 3);
		String x4 = Long.toString(v * 4);
		String x5 = Long.toString(v * 5);
		if (Utils.isPermutationOf(x, x2) && Utils.isPermutationOf(x, x3) && Utils.isPermutationOf(x, x4) && Utils.isPermutationOf(x, x5) && Utils.isPermutationOf(x, x6)) {
			return true;
		}
		return false;
	}
}
