package run;

public class Problem53 implements Problem {
	@Override
	public long get() {
		int cntr = 0;
		for (long n = 1; n <= 100; n++) {
			for (long r = 1; r <= n; r++) {
				long v = fact(n, r);
				System.out.println("testing n=" + n + ", r=" + r + ", v=" + v);
				if (v > 1000000) {
					cntr++;
				}
			}
		}
		return cntr;
	}

	long fact(long n, long r) {
		long big = Math.max(r, n - r);
		long small = Math.min(r, n - r);
		long result = 1;
		for (long i = big + 1; i <= n; i++) {
			result *= i;
			while (result > 100000000) {
				if (small <= 1) {
					return 10000000;
				}
				result /= small;
				small--;
			}
		}
		while (small > 1) {
			result /= small;
			small--;
		}
		return result;
	}
}
