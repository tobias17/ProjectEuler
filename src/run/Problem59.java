package run;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem59 implements Problem {
	@Override
	public long get() {
		int masterTotal = 0;
		int[] letters;
		try (Scanner read = new Scanner(new File("p059_cipher.txt"));) {
			ArrayList<Integer> lettersList = new ArrayList<Integer>();
			read.useDelimiter(",");
			while (read.hasNextInt()) {
				lettersList.add(read.nextInt());
			}
			letters = new int[lettersList.size()];
			for (int i = 0; i < lettersList.size(); i++) {
				letters[i] = lettersList.get(i);
			}

			Scanner in = new Scanner(System.in);
			ArrayList<String> words = new ArrayList<String>();
			double thresh = 0.72;

			for (int let1 = 'g'; let1 <= 'g'; let1++) {
				for (int let2 = 'o'; let2 <= 'o'; let2++) {
					for (int let3 = 'd'; let3 <= 'd'; let3++) {
						// System.out.print((let1 + let2 + let3) + ": ");
						int l = (let1 + let2 + let3);
						String s = Character.toString((char) let1) + Character.toString((char) let2) + Character.toString((char) let3) + ": ";
						int total = 0;
						int max = 160;
						for (int i = 0; i < letters.length; i++) {
							int use = (i % 3 == 0) ? let1 : (i % 3 == 1) ? let2 : let3;
							int a = letters[i] ^ use;
							masterTotal += a;
							s += (char) a;
							if ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')) {
								total++;
							}
							// System.out.print((char) a);
						}
						if ((double) total / (double) max >= thresh) {
							words.add(s);
						}

						// in.nextLine();
						// System.out.println();
					}
				}
			}
			int d = 0;
			for (String s : words) {
				System.out.println(s);
				for (int i = 5; i < s.length(); i++) {
					d += s.charAt(i);
				}
				System.out.println(d);
			}
			System.out.println(letters[0]);
			System.out.println(letters[letters.length - 1]);

		} catch (FileNotFoundException e) {
			return -2;
		}
		return masterTotal;
	}
}
