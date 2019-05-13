package run;

public class Problem58 implements Problem {
	@Override
	public long get() {
		int[] primes = Utils.generatePrimesArray(100000);
		double perc = 1;

		int cntr = 0;
		int num = 1;
		int total = 1;
		int add = 2;
		for (int size = 3; size < 100000; size += 2) {
			total = size * 2 - 1;
			for (int i = 0; i < 4; i++) {
				num += add;
				if (Utils.isPrime(num, primes)) {
					cntr++;
				}
			}

			perc = (double) cntr / (double) total;
			System.out.println("size: " + size + ", perc: " + perc);

			if (perc < 0.1) {
				return size;
			}

			add += 2;
		}

		return -1;
	}

	int[][] generateSpiral(int size) {
		int x = (size - 1) / 2;
		int y = (size - 1) / 2;
		int moveAmnt = 0;

		int[][] spiral = new int[size][size];

		spiral[x][y] = 1;
		int cntr = 2;

		while (true) {
			moveAmnt++;
			for (int xx = 0; xx < moveAmnt; xx++) {
				x++;
				if (x >= size) {
					return spiral;
				}
				spiral[x][y] = cntr;
				cntr++;
			}
			for (int yy = 0; yy < moveAmnt; yy++) {
				y++;
				if (y >= size) {
					return spiral;
				}
				spiral[x][y] = cntr;
				cntr++;
			}
			moveAmnt++;
			for (int xx = 0; xx < moveAmnt; xx++) {
				x--;
				if (x < 0) {
					return spiral;
				}
				spiral[x][y] = cntr;
				cntr++;
			}
			for (int yy = 0; yy < moveAmnt; yy++) {
				y--;
				if (y < 0) {
					return spiral;
				}
				spiral[x][y] = cntr;
				cntr++;
			}
		}
	}
}
