package run;

public class Problem40 implements Problem {
	@Override
	public long get() {
		int pos = 1;
		int look = 1;
		for (int i = 1; i < 100000; i++) {
			String s = Integer.toString(i);
			if (pos + s.length() > look) {
				System.out.println(s.charAt(look - pos));
				look *= 10;
			}
			pos += s.length();
			if (look > 1000000) {
				break;
			}
		}
		return -1;
	}
}
