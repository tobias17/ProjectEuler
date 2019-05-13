package run;

import java.util.ArrayList;

public class Problem51 implements Problem {

	int primeAmnt = 8;
	int[] primes = Utils.generatePrimesArray(100000);

	@Override
	public long get() {
		for (int digitsLong = 5; digitsLong < 10; digitsLong++) {
			for (int digitsToReplace = 1; digitsToReplace < digitsLong; digitsToReplace++) {
				if (generateDigits(digitsLong, digitsToReplace, new ArrayList<Integer>())) {
					return 1;
				}
			}
		}
		// ArrayList list = new ArrayList<Integer>();
		// list.add(-1);
		// list.add(2);
		// list.add(-1);
		// list.add(3);
		// list.add(-1);
		// list.add(3);
		return -1;
	}

	boolean generateDigits(int digitsLong, int digitsToReplace, ArrayList<Integer> digits) {
		if (digitsLong <= 0) {
			for (int digit : digits) {
				if (digit == -1) {
					System.out.print("*");
				} else {
					System.out.print(digit);
				}
			}
			int v = replacementAmount(digits, false);
			System.out.println(", amnt: " + v);
			if (v >= primeAmnt) {
				replacementAmount(digits, true);
				return true;
			}
			return false;
		}
		for (int i = -1; i < 10; i++) {
			if (i == -1 && digitsToReplace <= 0) {
				// no more replace digits remaining
			} else if (i != -1 && digitsToReplace == digitsLong) {
				// no more normal digits remaining
			} else if (i == 0 && digits.size() == 0) {
				// must be a 'digitsLong' sized number
			} else {
				ArrayList<Integer> newDigits = new ArrayList<Integer>(digits);
				newDigits.add(i);
				if (generateDigits(digitsLong - 1, digitsToReplace - (i == -1 ? 1 : 0), newDigits)) {
					return true;
				}
			}
		}
		return false;
	}

	int replacementAmount(ArrayList<Integer> digits, boolean telemetry) {
		int cntr = 0;
		for (int n = 1; n < 10; n++) {
			ArrayList<Integer> newDigits = new ArrayList<Integer>(digits);
			for (int i = 0; i < newDigits.size(); i++) {
				if (newDigits.get(i) == -1) {
					newDigits.set(i, n);
				}
			}
			long v = Utils.combineDigitsReversed(newDigits);
			if (telemetry) {
				System.out.print(v + ", is prime: ");
			}
			if (Utils.isPrime((int) v, primes)) {
				cntr++;
				if (telemetry) {
					System.out.println("yes");
				}
			} else if (telemetry) {
				System.out.println("no");
			}
		}
		return cntr;
	}
}
