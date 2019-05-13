package run;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem42 implements Problem {

	Integer[] array;

	@Override
	public long get() {
		generateTriangleNumbers();
		int cntr = 0;
		try (Scanner read = new Scanner(new File("p042_words.txt"));) {
			read.useDelimiter(",");
			ArrayList<String> words = new ArrayList<String>();
			while (read.hasNext()) {
				words.add(read.next());
			}
			Arrays.sort(array);
			for (String s : words) {
				System.out.print(s + ": ");
				int value = 0;
				for (int j = 0; j < s.length(); j++) {
					char c = s.charAt(j);
					value += (c - 64);
					System.out.print((c - 64) + " ");
				}
				System.out.print("= " + value);
				if (Arrays.binarySearch(array, value) >= 0) {
					cntr++;
					System.out.print(" - found match! " + Arrays.binarySearch(array, value));
				}
				System.out.println("");
			}
		} catch (Exception e) {
			return -1;
		}
		return cntr;
	}

	void generateTriangleNumbers() {
		ArrayList<Integer> tn = new ArrayList<Integer>();
		for (int i = 1; i < 1000; i++) {
			tn.add(i * (i + 1) / 2);
		}
		array = tn.toArray(new Integer[tn.size() - 1]);
	}

	boolean isTriangleWord() {
		return false;
	}
}
