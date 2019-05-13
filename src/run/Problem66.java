package run;

import java.util.ArrayList;
import java.util.TreeMap;

public class Problem66 implements Problem {

	PrimeCalculator pc;

	@Override
	public long get() {

		ArrayList<Integer> fails = new ArrayList<Integer>();
		pc = new PrimeCalculator(1000000);
		System.out.println("Finished generating primes...");
		int max = 0;
		int dAtMax = -1;

		long skipBase = 2;
		for (int D = 2; D <= 40; D++) {
			if (D == skipBase * skipBase) {
				System.out.println("Skipped: " + D);
				skipBase++;
			} else {
				boolean worked = false;
				TreeMap<Integer, Integer> mapD = pc.getPrimeFactors(D);
				if (mapD.containsKey(-1)) {
					System.out.println("could not reduce " + D + " in mapD");
					System.exit(-1);
				}
				int maxKey = -1;
				System.out.print(D + ": ");
				for (int key : mapD.keySet()) {
					for (int i = 0; i < mapD.get(key); i++) {
						System.out.print(key + ", ");
					}
					if (key > maxKey) {
						maxKey = key;
					}
				}
				// System.out.println();
				for (int x1 = maxKey; x1 < 1000000000; x1 += maxKey) {
					TreeMap<Integer, Integer> mapX1 = pc.getPrimeFactors(x1);
					if (mapX1.containsKey(-1)) {
						System.out.println("could not reduce " + x1 + " in mapX1");
						System.exit(-1);
					}

					if (doesWork(new TreeMap<Integer, Integer>(mapX1), x1 - 2, mapD)) {
						System.out.println("x: " + (x1 - 1));
						showNums(mapX1, x1 - 2);
						worked = true;
						if (x1 - 1 > max) {
							max = x1 - 1;
							dAtMax = D;
						}
						break;
					}
					if (doesWork(mapX1, x1 + 2, mapD)) {
						System.out.println("x: " + (x1 + 1));
						showNums(mapX1, x1 + 2);
						worked = true;
						if (x1 + 1 > max) {
							max = x1 + 1;
							dAtMax = D;
						}
						break;
					}

					// try {
					// Thread.sleep(10000);
					// } catch (InterruptedException e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// }
				}
				if (!worked) {
					System.out.println();
					System.out.println("Could not be found!!");
					fails.add(D);
				}
			}
		}

		for (int n : fails) {
			System.out.println("failed: " + n);
		}

		// long skipBase = 2;
		// for (int D = 13; D <= 13; D++) {
		// if (D == skipBase * skipBase) {
		// System.out.println("Skipped: " + D);
		// skipBase++;
		// } else {
		// boolean worked = false;
		// System.out.print("D: " + D + " = ");
		// TreeMap<Integer, Integer> mapD = pc.getPrimeFactors(D);
		// int maxKey = -1;
		// for (int key : mapD.keySet()) {
		// for (int i = 0; i < mapD.get(key); i++) {
		// System.out.print(key + ", ");
		// }
		// System.out.println();
		// if (key > maxKey) {
		// maxKey = key;
		// }
		// }
		// System.out.println("max: " + maxKey);
		// for (int x = maxKey; x < 1000000; x += maxKey) {
		// // System.out.println("x: " + x);
		// TreeMap<Integer, Integer> mapX1 = pc.getPrimeFactors(x);
		// System.out.print("x: " + x + " = ");
		// for (int key : mapX1.keySet()) {
		// for (int i = 0; i < mapX1.get(key); i++) {
		// System.out.print(key + ", ");
		// }
		// }
		// System.out.println();
		// if (doesWork(x - 2, mapX1, mapD, false, D)) {
		// doesWork(x - 2, mapX1, mapD, true, D);
		// worked = true;
		// if (x > max) {
		// max = x;
		// dAtMax = D;
		// }
		// mapX1 = pc.getPrimeFactors(x);
		// System.out.print("x: " + x + " = ");
		// for (int key : mapX1.keySet()) {
		// for (int i = 0; i < mapX1.get(key); i++) {
		// System.out.print(key + ", ");
		// }
		// }
		// System.out.println();
		// break;
		// }
		// if (doesWork(x + 2, mapX1, mapD, false, D)) {
		// doesWork(x + 2, mapX1, mapD, true, D);
		// worked = true;
		// if (x > max) {
		// max = x;
		// dAtMax = D;
		// }
		// mapX1 = pc.getPrimeFactors(x);
		// System.out.print("x: " + x + " = ");
		// for (int key : mapX1.keySet()) {
		// for (int i = 0; i < mapX1.get(key); i++) {
		// System.out.print(key + ", ");
		// }
		// }
		// System.out.println();
		// break;
		// }
		// }
		// if (!worked) {
		// System.out.println("Could not reach D = " + D);
		// }
		// }
		// }

		// for (int d = num; d <= num; d++) {
		// TreeMap<Integer, Integer> mapD = pc.getPrimeFactors(d);
		// int x = -1;
		// int y = -1;
		// for (int xi = 2; xi < 100000; xi++) {
		// int yi = getY(xi, d);
		// if (yi >= 0) {
		// x = xi;
		// y = yi;
		// break;
		// }
		// }
		// TreeMap<Integer, Integer> mapX1 = pc.getPrimeFactors(x - 1);
		// TreeMap<Integer, Integer> mapX2 = pc.getPrimeFactors(x + 1);
		// TreeMap<Integer, Integer> mapY = pc.getPrimeFactors(y);
		//
		// System.out.print("x-1: ");
		// for (int key : mapX1.keySet()) {
		// int val = mapX1.get(key);
		// for (int a = 0; a < val; a++) {
		// System.out.print(key + ", ");
		// }
		// }
		// System.out.println("val: " + (x - 1));
		//
		// System.out.print("x+1: ");
		// for (int key : mapX2.keySet()) {
		// int val = mapX2.get(key);
		// for (int a = 0; a < val; a++) {
		// System.out.print(key + ", ");
		// }
		// }
		// System.out.println("val: " + (x + 1));
		//
		// System.out.print("D: ");
		// for (int key : mapD.keySet()) {
		// int val = mapD.get(key);
		// for (int a = 0; a < val; a++) {
		// System.out.print(key + ", ");
		// }
		// }
		// System.out.println("val: " + d);
		//
		// System.out.print("y^2: ");
		// for (int key : mapY.keySet()) {
		// int val = mapY.get(key);
		// for (int a = 0; a < val; a++) {
		// System.out.print(key + ", " + key + ", ");
		// }
		// }
		// System.out.println("val: " + y);
		//
		// if (x > max) {
		// max = x;
		// dAtMax = d;
		// // System.out.println("New Max! " + x);
		// }
		// System.out.println();
		// }

		// ArrayList<Long> list = new ArrayList<Long>();
		// long skipBase = 2;
		// BigNumber maxX = new BigNumber();
		// int DinMax = -1;
		// for (int D = 1; D <= 1000; D++) {
		// if (D == skipBase * skipBase) {
		// System.out.println("Skipped: " + D);
		// skipBase++;
		// } else {
		// boolean worked = false;
		// BigNumber x = new BigNumber();
		// while (x.getDigitCount() < 10)
		// long y = getY(x, D);
		// if (y > 0) {
		// System.out.println(x + "s" + " - " + D + " * " + y + "s");
		// if (x > maxX) {
		// maxX = x;
		// DinMax = D;
		// }
		// worked = true;
		// break;
		// }
		// x.add(1);
		// }
		// if (!worked) {
		// list.add(D);
		// }
		// }
		// }System.out.println();System.out.println();System.out.print("{ ");for(
		//
		// long l:list)
		// {
		// System.out.print(l + ", ");
		// }System.out.println("};");System.out.println("Max x: "+maxX);

		return dAtMax;
	}

	boolean doesWork(long x, TreeMap<Integer, Integer> mapX1, TreeMap<Integer, Integer> mapD, boolean tel, int D) {
		TreeMap<Integer, Integer> mapX2 = pc.getPrimeFactors(x);

		if (tel) {
			System.out.print("D: " + D + ", " + "x1: ");
			for (int key : mapX1.keySet()) {
				for (int i = 0; i < mapX1.get(key); i++) {
					System.out.print(key + ", ");
				}
			}
			System.out.println();

			System.out.print("D: " + D + ", " + "x2: ");
			for (int key : mapX2.keySet()) {
				for (int i = 0; i < mapX2.get(key); i++) {
					System.out.print(key + ", ");
				}
			}
			System.out.println();
		}

		for (int key : mapD.keySet()) {
			if (mapX1.containsKey(key)) {
				int val = mapX1.get(key);
				if (val > 1) {
					mapX1.put(key, val - 1);
				} else {
					mapX1.remove(key);
				}
			} else if (mapX2.containsKey(key)) {
				int val = mapX2.get(key);
				if (val > 1) {
					mapX2.put(key, val - 1);
				} else {
					mapX2.remove(key);
				}
			} else {
				System.out.println("failed 1");
				return false;
			}
		}

		for (int key : mapX1.keySet()) {
			int v = mapX1.get(key);
			if (mapX2.containsKey(key)) {
				v += mapX2.get(key);
				mapX2.remove(key);
			}
			if (v % 2 != 0) {
				System.out.println("failed 2");
				return false;
			}
		}
		for (int key : mapX2.keySet()) {
			if (mapX2.get(key) % 2 != 0) {
				System.out.println("failed 3");
				return false;
			}
		}

		return true;
	}

	boolean doesWork(TreeMap<Integer, Integer> mapX1, long x2, TreeMap<Integer, Integer> mapD) {
		TreeMap<Integer, Integer> mapX2 = pc.getPrimeFactors(x2);
		if (mapX2.containsKey(-1)) {
			System.out.println("could not reduse " + x2 + " in mapX2");
			System.exit(-1);
		}

		// System.out.print("D: ");
		// for (int key : mapD.keySet()) {
		// for (int i = 0; i < mapD.get(key); i++) {
		// System.out.print(key + ", ");
		// }
		// }
		// System.out.println();
		// System.out.print("x1: ");
		// for (int key : mapX1.keySet()) {
		// for (int i = 0; i < mapX1.get(key); i++) {
		// System.out.print(key + ", ");
		// }
		// }
		// System.out.println();
		// System.out.print("x2: ");
		// for (int key : mapX2.keySet()) {
		// for (int i = 0; i < mapX2.get(key); i++) {
		// System.out.print(key + ", ");
		// }
		// }
		// System.out.println();

		for (int key : mapD.keySet()) {
			if (mapX1.containsKey(key)) {
				int val = mapX1.get(key);
				if (val > 1) {
					mapX1.put(key, val - 1);
				} else {
					mapX1.remove(key);
				}
			} else if (mapX2.containsKey(key)) {
				int val = mapX2.get(key);
				if (val > 1) {
					mapX2.put(key, val - 1);
				} else {
					mapX2.remove(key);
				}
			} else {
				return false;
			}
		}

		for (int key : mapX1.keySet()) {
			int v = mapX1.get(key);
			if (mapX2.containsKey(key)) {
				v += mapX2.get(key);
				mapX2.remove(key);
			}
			if (v % 2 != 0) {
				return false;
			}
		}
		for (int key : mapX2.keySet()) {
			if (mapX2.get(key) % 2 != 0) {
				return false;
			}
		}

		return true;
	}

	boolean doesWork2(long x, long D) {
		long leftSide = x * x - 1;
		long y = 1;
		while (true) {
			long rightSide = D * y * y;
			if (leftSide == rightSide) {
				return true;
			} else if (leftSide > rightSide) {
				return false;
			}
			y++;
		}
	}

	int getY(int x, int D) {
		int leftSide = x * x - 1;
		if (leftSide % D != 0) {
			// doesn't divide by D
			return -1;
		}
		leftSide /= D;
		int sqrt = (int) Math.sqrt(leftSide);
		if (sqrt * sqrt != leftSide) {
			// not an even root
			return -1;
		}
		return sqrt;
	}

	void showNums(TreeMap<Integer, Integer> mapX1, long x2) {
		TreeMap<Integer, Integer> mapX2 = pc.getPrimeFactors(x2);

		System.out.print("x1: ");
		for (int key : mapX1.keySet()) {
			for (int i = 0; i < mapX1.get(key); i++) {
				System.out.print(key + ", ");
			}
		}

		System.out.print("x2: ");
		for (int key : mapX2.keySet()) {
			for (int i = 0; i < mapX2.get(key); i++) {
				System.out.print(key + ", ");
			}
		}
		System.out.println();
	}
}
