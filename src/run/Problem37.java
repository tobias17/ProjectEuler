package run;

public class Problem37 implements Problem {
	@Override
	public long get() {
		int n = 10;
		int cntr = 0;
		int sum = 0;
		while (cntr < 11) {
			if (isTruncLeft(n) && isTruncRight(n)) {
				System.out.println(n);
				sum += n;
				cntr++;
			}
			n++;
		}
		return sum;
	}

	boolean isTruncLeft(int n) {
		int d = 10;
		while (true) {
			int v = n % d;
			if (!Utils.isPrime(v)) {
				return false;
			}
			if (v == n) {
				return true;
			}
			d *= 10;
		}
	}

	boolean isTruncRight(int n) {
		while (n > 0) {
			if (!Utils.isPrime(n)) {
				return false;
			}
			n /= 10;
		}
		return true;
	}
}
