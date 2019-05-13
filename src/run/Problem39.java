package run;

public class Problem39 implements Problem {
	@Override
	public long get() {
		int max = 0;
		int max_pos = -1;
		for (int p = 3; p <= 1000; p++) {
			int cntr = 0;
			for (int a = 1; a < p; a++) {
				for (int b = a; b < p && a + b < p; b++) {
					int c = p - a - b;
					if (isRightTriangle(a, b, c)) {
						System.out.printf("%d -> {%d, %d, %d}\n", p, a, b, c);
						cntr++;
					}
				}
			}
			if (cntr > max) {
				max = cntr;
				max_pos = p;
			}
		}
		return max_pos;
	}

	boolean isRightTriangle(int a, int b, int c) {
		if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
			return true;
		}
		return false;
	}
}
