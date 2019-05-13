package run;

public class Problem57 implements Problem {
	@Override
	public long get() {
		Fraction frac = new Fraction(3, 2);
		int cntr = 0;

		System.out.println(frac.num.getString() + " / " + frac.den.getString());
		for (int i = 1; i < 1000; i++) {
			BigNumber mult = new BigNumber(frac.den);
			mult.multiply(2);
			frac.den.add(frac.num);
			frac.num.add(mult);
			System.out.print(frac.num.getString() + " / " + frac.den.getString());
			if (frac.doesNumeratorHaveMoreDigits()) {
				cntr++;
				System.out.print(", more digits!");
			}
			System.out.println();
		}
		return cntr;
	}

}

class Fraction {
	public BigNumber num;
	public BigNumber den;

	public Fraction(int num, int den) {
		this.num = new BigNumber(num);
		this.den = new BigNumber(den);
	}

	public boolean doesNumeratorHaveMoreDigits() {
		System.out.print(", num: " + num.getDigitCount() + ", den: " + den.getDigitCount());
		return num.getDigitCount() > den.getDigitCount();
	}
}
