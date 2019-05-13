package run;

import java.util.ArrayList;

public class Problem26 implements Problem {
	@Override
	public long get() {
		int max = -1;
		ArrayList<Integer> list;
		for (int num = 900; num < 1000; num++) {
			list = new ArrayList<Integer>();
			int rem = 10;
			for (int i = 1; i < 1000000000; i++) {
				list.add(rem / num % 10);
				rem = rem % num * 10;
				int rl = repeatingLength(list);
				if (rl > 0) {
					System.out.println(num + ": " + rl);
					if (rl > max) {
						max = rl;
					}
					break;
				}
			}
		}
		return max;
	}

	private int repeatingLength(ArrayList<Integer> list) {
		int repeatingSections = 4;
		int lastIndex = list.size() - 1;
		int width = 1;
		while (width * repeatingSections <= list.size()) {
			boolean works = true;
			for (int i = 0; i < width; i++) {
				int v = list.get(lastIndex - i);
				for (int j = 1; j < repeatingSections; j++) {
					if (list.get(lastIndex - i - (j * width)) != v) {
						works = false;
					}
				}
			}
			if (works) {
				return width;
			}
			width++;
		}
		return -1;
	}
}
