package run;

public class Problem55 implements Problem {
	@Override
	public long get() {
		int cntr = 0;
		for (int n = 1; n < 10000; n++) {
			BigNumber num = new BigNumber(n);
			// System.out.println(num.getNum());
			boolean b = true;
			for (int i = 0; i < 50 && b; i++) {
				num.addReverse();
				// System.out.println(num.getNum());
				if (num.isPalindromic()) {
					b = false;
				}
			}
			if (b) {
				cntr++;
			}
		}
		return cntr;
	}
}
