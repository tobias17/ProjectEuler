package run;

import java.util.ArrayList;

public class Problem38 implements Problem {
	@Override
	public long get() {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 1; i < 10000; i++) {
			String s = Integer.toString(i);
			for (int n = 2; n < 10; n++) {
				s += Integer.toString(i * n);
				if (Utils.isPandigital(s)) {
					System.out.println("base: " + i + ", n: " + n + ", s: " + s);
					list.add(s);
					n = 10;
				}
			}
		}
		String[] array = list.toArray(new String[list.size()]);
		System.out.println("Max: " + array[array.length - 1]);
		return -1;
	}
}
