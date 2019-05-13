package run;

public class Problem36 implements Problem {
	@Override
	public long get() {
		// System.out.println(Integer.toString(585));
		// Utils.isPalindromic(Integer.toString(585));
		// System.out.println(Integer.toString(585, 2));
		// Utils.isPalindromic(Integer.toString(585, 2));
		int sum = 0;
		for (int i = 1; i < 1000000; i++) {
			if (Utils.isPalindromic(Integer.toString(i)) && Utils.isPalindromic(Integer.toString(i, 2))) {
				System.out.println(i);
				sum += i;
			}
		}
		return sum;
	}
}
