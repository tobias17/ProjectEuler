package run;

public class Problem56 implements Problem {
	@Override
	public long get() {
		int max = -1;
		for (int a = 1; a < 100; a++) {
			for (int b = 1; b < 100; b++) {
				BigNumber num = new BigNumber(a);
				num.exponentiate(b);
				if (num.digitSum() > max) {
					max = num.digitSum();
				}
			}
		}
		return max;
	}
}
