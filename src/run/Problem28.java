package run;

public class Problem28 implements Problem {

	int width = 1001;
	int height = 1001;
	int[][] spiral = new int[width][height];

	@Override
	public long get() {
		generateSpiral();
		return diagonalAddition();
	}

	long diagonalAddition() {
		// negative one to counteract the 1 in the middle being counted twice
		long sum = -1;

		for (int x = 0, y = 0; x < width && y < height; x++, y++) {
			sum += spiral[x][y];
		}
		for (int x = width - 1, y = 0; x >= 0 && y < height; x--, y++) {
			sum += spiral[x][y];
		}

		return sum;
	}

	void generateSpiral() {
		int x = (width - 1) / 2;
		int y = (height - 1) / 2;
		int moveAmnt = 0;

		spiral[x][y] = 1;
		int cntr = 2;

		while (true) {
			moveAmnt++;
			for (int xx = 0; xx < moveAmnt; xx++) {
				x++;
				if (x >= width) {
					return;
				}
				spiral[x][y] = cntr;
				cntr++;
			}
			for (int yy = 0; yy < moveAmnt; yy++) {
				y++;
				if (y >= height) {
					return;
				}
				spiral[x][y] = cntr;
				cntr++;
			}
			moveAmnt++;
			for (int xx = 0; xx < moveAmnt; xx++) {
				x--;
				if (x < 0) {
					return;
				}
				spiral[x][y] = cntr;
				cntr++;
			}
			for (int yy = 0; yy < moveAmnt; yy++) {
				y--;
				if (y < 0) {
					return;
				}
				spiral[x][y] = cntr;
				cntr++;
			}
		}
	}
}
