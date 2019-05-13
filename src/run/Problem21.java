package run;

public class Problem21 implements Problem {
	@Override
	public long get() {
		int max = 10000;
		boolean[] hasBeenFound = new boolean[max];
		long sum = 0;

		for (int i = 1; i < max; i++) {
			if (!hasBeenFound[i]) {
				long divSum = divisorSum(i);
				long divSumDivSum = divisorSum(divSum);
				if (divSumDivSum == i && divSumDivSum < max && divSum != i) {
					sum += divSum + divSumDivSum;
					hasBeenFound[(int) divSum] = true;
					hasBeenFound[(int) divSumDivSum] = true;
				}
				// System.out.println(i + ": " + divSum + ", " + divSumDivSum + (divSumDivSum ==
				// i ? " - FOUND ONE!" : ""));
			} else {
				System.out.println(i + ": has been found already");
			}
		}

		return sum;
	}

	long divisorSum(long num) {
		long sum = 0;
		for (int i = 1; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				sum += i;
				if (i != Math.sqrt(num) && i != 1) {
					sum += num / i;
				}
			}
		}
		return sum;
	}
}