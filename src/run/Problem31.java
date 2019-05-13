package run;

public class Problem31 implements Problem {

	int[] coinAmnt = { 2, 5, 10, 20, 50, 100, 200 };

	@Override
	public long get() {
		return calcAmount(0, 6);
	}

	int calcAmount(int amnt, int coinIndex) {
		if (coinIndex <= -1) {
			return 1;
		}
		int cntr = 0;
		for (int c = 0; amnt + c * coinAmnt[coinIndex] <= 200; c++) {
			cntr += calcAmount(amnt + c * coinAmnt[coinIndex], coinIndex - 1);
		}
		return cntr;
	}
}
