package run;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem22 implements Problem {
	@Override
	public long get() {
		try {
			Scanner read = new Scanner(new File("p022_names.txt"));
			read.useDelimiter(",");
			ArrayList<String> names = new ArrayList<String>();
			while (read.hasNext()) {
				names.add(read.next());
			}
			String[] array = names.toArray(new String[names.size()]);
			Arrays.sort(array);
			long sum = 0;
			for (int i = 0; i < array.length; i++) {
				long value = 0;
				String s = array[i];
				for (int j = 0; j < s.length(); j++) {
					char c = s.charAt(j);
					value += (c - 64);
				}
				sum += value * (i + 1);
			}
			return sum;
		} catch (Exception e) {

		}
		return -1;
	}
}
