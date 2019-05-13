package run;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem62 implements Problem {

	int digitLength = 12;
	int threshold = 5;
	long[] cubes;
	boolean[] tested;

	@Override
	public long get() {
		generateCubes();
		System.out.println("Generated!");
		Arrays.sort(cubes);
		System.out.println("Sorted!");

		for (int i = 0; i < cubes.length; i++) {
			long l = cubes[i];
			if (!tested[i]) {
				int dl = getDigitLength(l);
				System.out.print("testing: " + l);
				int r = permAmnt(0, getDigitCountArray(l), dl, false);
				System.out.println(", res: " + r);
				if (r == threshold) {
					// System.out.println(l + ": " + r);
					permAmnt(0, getDigitCountArray(l), dl, true);
					return l;
				}
			} else {
				System.out.println("skipped: " + l);
			}
		}

		System.out.println("cube length: " + cubes.length);

		return -1;
	}

	void generateCubes() {
		long maxBase = (long) Math.sqrt(Math.pow(10, digitLength));
		ArrayList<Long> list = new ArrayList<Long>();
		for (long i = 1; i < maxBase; i++) {
			long cube = i * i * i;
			if (getDigitLength(cube) > digitLength) {
				break;
			} else if (getDigitLength(cube) == digitLength) {
				list.add(cube);
			}
		}
		cubes = new long[list.size()];
		tested = new boolean[list.size()];
		int i = 0;
		for (long l : list) {
			cubes[i++] = l;
		}
	}

	int[] getDigitCountArray(long n) {
		int[] arr = new int[10];
		while (n > 0) {
			arr[(int) (n % 10)]++;
			n /= 10;
		}
		return arr;
	}

	int getDigitLength(long n) {
		int cntr = 0;
		while (n > 0) {
			n /= 10;
			cntr++;
		}
		return cntr;
	}

	int permAmnt(long num, int[] digitCount, int depth, boolean tel) {
		if (depth <= 0) {
			// check
			// System.out.println(num);
			int i = Arrays.binarySearch(cubes, num);
			if (i >= 0) {
				tested[i] = true;
				return 1;
			}
			return 0;
		}
		int cntr = 0;
		for (int digit = 0; digit < 10; digit++) {
			if (digitCount[digit] > 0) {
				int[] newDigitCount = Arrays.copyOf(digitCount, digitCount.length);
				newDigitCount[digit]--;
				int amnt = permAmnt(num * 10 + digit, newDigitCount, depth - 1, tel);
				cntr += amnt;
				if (tel && amnt > 0 && getDigitLength(num) == digitLength - 1) {
					System.out.println(num * 10 + digit);
				}
			}
		}
		return cntr;
	}
}
