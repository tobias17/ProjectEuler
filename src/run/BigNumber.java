package run;

import java.util.ArrayList;

class BigNumber {
	ArrayList<Integer> digits;

	public BigNumber() {
		digits = new ArrayList<Integer>();
	}

	public BigNumber(BigNumber b) {
		this.digits = new ArrayList<Integer>(b.digits);
	}

	public BigNumber(long num) {
		digits = new ArrayList<Integer>();
		while (num > 0) {
			digits.add((int) (num % 10));
			num /= 10;
		}
	}

	public void add(BigNumber b) {
		int carry = 0;
		for (int i = 0; i < digits.size() || i < b.getDigitCount(); i++) {
			int result = carry;
			if (b.hasIndex(i)) {
				result += b.getNumAtIndex(i);
			}
			if (hasIndex(i)) {
				result += digits.get(i);
			}
			if (result >= 10) {
				carry = result / 10;
				result = result % 10;
			} else {
				carry = 0;
			}
			if (hasIndex(i)) {
				digits.set(i, result);
			} else {
				digits.add(i, result);
			}
		}
		while (carry > 0) {
			digits.add(carry % 10);
			carry /= 10;
		}
	}

	public void add(int num) {
		int result = digits.get(0) + num;
		int carry = 0;
		if (result >= 10) {
			carry = result / 10;
			result = result % 10;
		}
		digits.set(0, result);
		for (int i = 1; i < digits.size(); i++) {
			if (carry >= 10) {
				carry = result / 10;
				digits.set(i, result % 10);
			} else {
				break;
			}
		}
		while (carry > 0) {
			digits.add(carry % 10);
			carry /= 10;
		}
	}

	public void addReverse() {
		ArrayList<Integer> resultDigits = new ArrayList<Integer>();
		int carry = 0;
		for (int i = 0; i < digits.size(); i++) {
			int result = digits.get(i) + digits.get(digits.size() - 1 - i) + carry;
			if (result >= 10) {
				carry = result / 10;
				result = result % 10;
			} else {
				carry = 0;
			}
			resultDigits.add(result);
		}
		while (carry > 0) {
			resultDigits.add(carry % 10);
			carry /= 10;
		}
		digits = resultDigits;
	}

	public int digitSum() {
		int sum = 0;
		for (int n : digits) {
			sum += n;
		}
		return sum;
	}

	public void exponentiate(int exponent) {
		int base = (int) getNum();
		for (int i = 1; i < exponent; i++) {
			multiply(base);
		}
	}

	public int getDigitCount() {
		return digits.size();
	}

	public long getNum() {
		long n = 0;
		long m = 1;
		for (long d : digits) {
			n += d * m;
			m *= 10;
		}
		return n;
	}

	public int getNumAtIndex(int index) {
		return digits.get(index);
	}

	public String getString() {
		String s = "";
		for (int i = digits.size() - 1; i >= 0; i--) {
			s += Integer.toString(digits.get(i));
		}
		return s;
	}

	public boolean hasIndex(int index) {
		return index < digits.size();
	}

	public boolean isPalindromic() {
		for (int i = 0; i < digits.size() / 2; i++) {
			if (digits.get(i) != digits.get(digits.size() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public void multiply(int amnt) {
		int carry = 0;
		for (int i = 0; i < digits.size(); i++) {
			int result = digits.get(i) * amnt + carry;
			if (result >= 10) {
				carry = result / 10;
				result = result % 10;
			} else {
				carry = 0;
			}
			digits.set(i, result);
		}
		while (carry > 0) {
			digits.add(carry % 10);
			carry /= 10;
		}
	}

	public void sub(int num) {
		int result = digits.get(0) - num;
		int borrow = 0;
		if (result < 0) {
			borrow = -result / 10;
			result = -result % 10;
		}
		digits.set(0, result);
		for (int i = 1; i < digits.size(); i++) {
			if (borrow < 0) {
				borrow = -result / 10;
				digits.set(i, -result % 10);
			}
		}
		for (int i = digits.size() - 1; i >= 0; i--) {
			if (digits.get(i) == 0) {
				digits.remove(i);
			} else {
				break;
			}
		}
	}
}
