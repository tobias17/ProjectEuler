package run;

public class Problem63 implements Problem {
	@Override
	public long get() {
		int cntr = 0;
		for (int pow = 1; pow < 1000; pow++) {
			for (int base = 1; base < 1000; base++) {
				BigNumber num = new BigNumber(base);
				num.exponentiate(pow);
				if (num.getDigitCount() == pow) {
					System.out.println(num.getString() + ", cntr: " + ++cntr);
				}
			}
		}
		return cntr;
	}

	int getDigitLength(long n) {
		int cntr = 0;
		while (n > 0) {
			n /= 10;
			cntr++;
		}
		return cntr;
	}
}
