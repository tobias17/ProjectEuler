package run;

import java.util.ArrayList;

public class Problem60 implements Problem {

	ArrayList<String> list = new ArrayList<String>();
	ArrayList<Integer> min = new ArrayList<Integer>();
	int minVal = 10000;
	PrimeCalculator pc;
	int depth = 10000;
	int length;
	int[] primes;

	@Override
	public long get() {
		primes = Utils.generatePrimesArray(depth);
		pc = new PrimeCalculator(depth * depth / 10);
		length = primes.length;
		System.out.println("depth: " + depth);
		System.out.println("length: " + length);
		System.out.println("pc length: " + pc.getLength());

		System.out.println("manual check: " + works(new int[] { 2, 3, 5, 7 }));

		// for (int i1 = 0; i1 < length; i1++) {
		// for (int i2 = i1 + 1; i2 < length; i2++) {
		// for (int i3 = i2 + 1; i3 < length; i3++) {
		// for (int i4 = i3 + 1; i4 < length; i4++) {
		// for (int i5 = i4 + 1; i5 < length; i5++) {
		// if (works(new int[] { primes[i1], primes[i2], primes[i3], primes[i4],
		// primes[i5] })) {
		// list.add(Integer.toString(primes[i1] + primes[i2] + primes[i3] + primes[i4] +
		// primes[i5]) + ": " + Integer.toString(primes[i1]) + ", " +
		// Integer.toString(primes[i2]) + ", " + Integer.toString(primes[i3]) + ", " +
		// Integer.toString(primes[i4]) + ", " + Integer.toString(primes[i5]));
		// }
		// }
		// }
		// }
		// }
		// }

		gen(new ArrayList<Integer>(), 5, 0);

		System.out.println();
		for (int n : min) {
			System.out.println(n);
		}
		return minVal;
	}

	long combine(int n1, int n2) {
		long tn2 = n2;
		while (tn2 > 0) {
			n1 *= 10;
			tn2 /= 10;
		}
		return (long) n2 + (long) n1;
	}

	void gen(ArrayList<Integer> passedList, int depth, int startIndex) {
		if (depth <= 0) {
			int total = 0;
			for (int n : passedList) {
				total += n;
				System.out.print(n + ", ");
			}
			System.out.println("total: " + total);
			if (total < minVal) {
				min = passedList;
				minVal = total;
			}
			return;
		}
		for (int index = startIndex; index < primes.length; index++) {
			if (passedList.size() > 0) {
				boolean failed = false;
				for (int num : passedList) {
					long n1 = combine(num, primes[index]);
					// System.out.println("n1 = " + num + " + " + primes[index] + ": " + n1 + ",
					// isPrime: " + pc.isPrime(n1));
					long n2 = combine(primes[index], num);
					// System.out.println("n2 = " + primes[index] + " + " + num + ": " + n2 + ",
					// isPrime: " + pc.isPrime(n1));
					if (!pc.isPrime(n1) || !pc.isPrime(n2)) {
						failed = true;
					}
				}
				if (!failed) {
					ArrayList<Integer> newList = new ArrayList<Integer>(passedList);
					newList.add(primes[index]);
					gen(newList, depth - 1, index + 1);
				}
			} else {
				ArrayList<Integer> newList = new ArrayList<Integer>(passedList);
				newList.add(primes[index]);
				gen(newList, depth - 1, index + 1);
			}
		}
	}

	boolean works(int[] nums) {
		for (int i1 = 0; i1 < nums.length - 1; i1++) {
			for (int i2 = i1 + 1; i2 < nums.length; i2++) {
				if (pc.isPrime(combine(nums[i1], nums[i2])) && pc.isPrime(combine(nums[i2], nums[i1]))) {
					return false;
				}
			}
		}
		return true;
	}

}
