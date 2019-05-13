package run;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem61 implements Problem {

	ArrayList<Integer> polygonalNumbers = new ArrayList<Integer>();
	int[][] polygonNumbers = new int[6][];
	// int INDEX_OFFSET = 3;

	@Override
	public long get() {
		genPolygonalNumbers();
		// for (int n : polygonNumbers[0]) {
		// if (n == 8128) {
		// System.out.println("found 3");
		// }
		// }
		// for (int n : polygonNumbers[1]) {
		// if (n == 8281) {
		// System.out.println("found 4");
		// }
		// }
		// for (int n : polygonNumbers[2]) {
		// if (n == 2882) {
		// System.out.println("found 5");
		// }
		// }
		// for (int i = 0; i < 6; i++) {
		// System.out.println(i + ": " + polygonNumbers[i].length);
		// }
		// for (int n : polygonNumbers[0]) {
		// System.out.println(n);
		// }

		return findCyclicalNumbers();
	}

	int findCyclicalNumbers() {
		boolean[] used = new boolean[] { true, false, false, false, false, false };
		for (int i = 0; i < polygonNumbers[0].length; i++) {
			int r = works(polygonNumbers[0][i], used, polygonNumbers[0][i]);
			if (r > 0) {
				System.out.println(polygonNumbers[0][i]);
				return r;
			}
		}
		return -1;
	}

	void genPolygonalNumbers() {
		for (int i = 0; i <= 5; i++) {
			ArrayList<Integer> nums = new ArrayList<Integer>();
			int base = 0;
			while (true) {
				int num = polygonNumber(i, base);
				if (num >= 1000) {
					if (num <= 9999) {
						nums.add(num);
					} else {
						break;
					}
				}
				base++;
			}
			polygonNumbers[i] = Utils.convertIntArrayList(nums);
		}
	}

	int polygonNumber(int sides, int n) {
		switch (sides) {
		case 0:
			return n * (n + 1) / 2;
		case 1:
			return n * n;
		case 2:
			return n * (3 * n - 1) / 2;
		case 3:
			return n * (2 * n - 1);
		case 4:
			return n * (5 * n - 3) / 2;
		case 5:
			return n * (3 * n - 2);
		}
		return -1;
	}

	int works(int n, boolean[] used, int orig) {
		boolean full = true;
		for (boolean b : used) {
			if (!b) {
				full = false;
			}
		}
		if (full) {
			// System.out.print("comparing: " + orig / 100 + " vs " + n % 100);
			if (orig / 100 == n % 100) {
				// System.out.println(", Found one!");
				return n;
			}
			// System.out.println(", Cutting!");
			return -1;
		}
		int compare = n % 100;
		for (int pi = 0; pi < used.length; pi++) {
			if (!used[pi]) {
				for (int index = 0; index < polygonNumbers[pi].length; index++) {
					// if (pi == 1 && polygonNumbers[pi][index] == 8281) {
					// System.out.println("Enter 4");
					// }
					// if (pi == 2 && polygonNumbers[pi][index] == 2882) {
					// System.out.println("Enter 5");
					// }
					if (polygonNumbers[pi][index] / 100 == compare) {
						boolean[] newUsed = Arrays.copyOf(used, used.length);
						newUsed[pi] = true;
						int r = works(polygonNumbers[pi][index], newUsed, orig);
						if (r > 0) {
							System.out.print(polygonNumbers[pi][index] + "(" + pi + "), ");
							return r + n;
						}
					}
				}
			}
		}
		return -1;
	}
}
