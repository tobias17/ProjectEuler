package run;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem29 implements Problem {
	@Override
	public long get() {
		int start = 2;
		int end = 100;
		Set<Double> numbers = new HashSet<Double>();
		for (int a = start; a <= end; a++) {
			for (int b = start; b <= end; b++) {
				double v = Math.pow(a, b);
				numbers.add(v);
			}
		}
		Double[] array = numbers.toArray(new Double[numbers.size()]);
		Arrays.sort(array);
		for (double n : array) {
			System.out.println(n);
		}
		return numbers.size();
	}
}
