package run;

public class Problem27 implements Problem {
	@Override
	public long get() {
		int max = -1;
		int maxa = 0, maxb = 0;
		int maxMultResult = 0;
		for (int a = -999; a < 1000; a++) {
			for (int b = -1000; b <= 1000; b++) {
				int count = primeCount(a, b);
				if (count > max) {
					maxa = a;
					maxb = b;
					max = count;
					maxMultResult = a * b;
				}
			}
		}
		System.out.println("max: " + max + ", a=" + maxa + ", b=" + maxb);

		for (int n = 0; n <= 1000; n++) {
			int v = ((int) Math.pow(n, 2)) + maxa * n + maxb;
			System.out.println(n + ": " + v);
		}

		return maxMultResult;
	}

	boolean isPrime(int v) {
		if (v <= 1) {
			return false;
		}
		for (int d = 2; d <= Math.sqrt(v); d++) {
			if (v % d == 0) {
				return false;
			}
		}
		return true;
	}

	int primeCount(int a, int b) {
		for (int n = 0; n <= 1000; n++) {
			int v = ((int) Math.pow(n, 2)) + a * n + b;
			if (!isPrime(v)) {
				return n;
			}
		}
		return -1;
	}
}
