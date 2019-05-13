package run;

public class Problem1 implements Problem {
	@Override
	public long get() {

		int a = 1;
		int sum = 0;

		while (a < 1000) {
			// do stuff
			if (a % 3 == 0 || a % 5 == 0) {
				sum = a + sum;
			}

			a = a + 1;
		}

		return sum;
	}
}
