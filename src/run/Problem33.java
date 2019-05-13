package run;

public class Problem33 implements Problem {
	@Override
	public long get() {
		int sumnum = 1, sumden = 1;
		;
		for (int numerator = 10; numerator < 100; numerator++) {
			for (int denomenator = numerator + 1; denomenator < 100; denomenator++) {
				if (numerator / 10 != numerator % 10 || denomenator / 10 != denomenator % 10) {
					double d1 = (double) numerator / (double) denomenator;
					double d2 = (double) (numerator / 10) / (double) (denomenator % 10);
					if (d1 == d2 && numerator % 10 == denomenator / 10) {
						System.out.printf("%d / %d", numerator, denomenator);
						int n = numerator, d = denomenator;
						for (int i = 2; i < 100; i++) {
							while (n % i == 0 && d % i == 0) {
								n /= i;
								d /= i;
							}
						}
						System.out.printf(" -> %d / %d\n", n, d);
						sumnum *= n;
						sumden *= d;
					}
				}
			}
		}
		for (int i = 2; i < 100; i++) {
			while (sumnum % i == 0 && sumden % i == 0) {
				sumnum /= i;
				sumden /= i;
			}
		}
		return sumden;
	}
}
