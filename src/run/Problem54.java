package run;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Problem54 implements Problem {
	@Override
	public long get() {
		int cntr = 0;

		// didPlayer1Win(new String[] { "1H", "2D", "3S", "4C", "5H" }, new String[] {
		// "7C", "5H", "8D", "TD", "KS" });

		try (Scanner read = new Scanner(new File("p054_poker.txt"));) {
			ArrayList<String> turns = new ArrayList<String>();
			while (read.hasNextLine()) {
				turns.add(read.nextLine());
			}
			for (String s : turns) {
				// System.out.print("Cards:");
				Scanner cards = new Scanner(s);
				String[] player1Hand = new String[5];
				for (int i = 0; i < 5; i++) {
					player1Hand[i] = cards.next();
					// System.out.print(" " + player1Hand[i]);
				}
				String[] player2Hand = new String[5];
				for (int i = 0; i < 5; i++) {
					player2Hand[i] = cards.next();
					// System.out.print(" " + player2Hand[i]);
				}
				// System.out.print(", winner: ");
				if (didPlayer1Win(player1Hand, player2Hand)) {
					// System.out.println("player 1");
					cntr++;
				} else {
					// System.out.println("player 2");
				}
			}
		} catch (Exception e) {
			return -1;
		}
		return cntr;
	}

	boolean didPlayer1Win(String[] p1, String[] p2) {

		PokerHand p1Hand = new PokerHand(p1);
		PokerHand p2Hand = new PokerHand(p2);

		boolean p1Flush = p1[0].charAt(1) == p1[1].charAt(1) && p1[0].charAt(1) == p1[2].charAt(1) && p1[0].charAt(1) == p1[3].charAt(1) && p1[0].charAt(1) == p1[4].charAt(1);
		boolean p2Flush = p2[0].charAt(1) == p2[1].charAt(1) && p2[0].charAt(1) == p2[2].charAt(1) && p2[0].charAt(1) == p2[3].charAt(1) && p2[0].charAt(1) == p2[4].charAt(1);

		int[] p1Nums = new int[5];
		for (int i = 0; i < 5; i++) {
			char c = p1[i].charAt(0);
			if (c >= 'A' && c <= 'Z') {
				if (c == 'T') {
					p1Nums[i] = 10;
				}
				if (c == 'J') {
					p1Nums[i] = 11;
				}
				if (c == 'Q') {
					p1Nums[i] = 12;
				}
				if (c == 'K') {
					p1Nums[i] = 13;
				}
				if (c == 'A') {
					p1Nums[i] = 14;
				}
			} else {
				p1Nums[i] = c - 48;
			}
		}

		int[] p2Nums = new int[5];
		for (int i = 0; i < 5; i++) {
			char c = p2[i].charAt(0);
			if (c >= 'A' && c <= 'Z') {
				if (c == 'T') {
					p2Nums[i] = 10;
				}
				if (c == 'J') {
					p2Nums[i] = 11;
				}
				if (c == 'Q') {
					p2Nums[i] = 12;
				}
				if (c == 'K') {
					p2Nums[i] = 13;
				}
				if (c == 'A') {
					p2Nums[i] = 14;
				}
			} else {
				p2Nums[i] = c - 60;
			}
		}

		Arrays.sort(p1Nums);
		int p1Highest = p1Nums[4];
		boolean p1Straight = (p1Nums[0] == p1Nums[1] - 1 && p1Nums[0] == p1Nums[2] - 2 && p1Nums[0] == p1Nums[3] - 3 && p1Nums[0] == p1Nums[4] - 4);
		boolean p1RoyalStraight = (p1Straight && p1Nums[0] == 10);

		Arrays.sort(p2Nums);
		int p2Highest = p2Nums[4];
		boolean p2Straight = (p2Nums[0] == p2Nums[1] - 1 && p2Nums[0] == p2Nums[2] - 2 && p2Nums[0] == p2Nums[3] - 3 && p2Nums[0] == p2Nums[4] - 4);
		boolean p2RoyalStraight = (p2Straight && p2Nums[0] == 10);

		HashMap<Integer, Integer> p1Map = new HashMap<Integer, Integer>();
		for (int num : p1Nums) {
			if (!p1Map.containsKey(num)) {
				p1Map.put(num, 1);
			} else {
				p1Map.put(num, p1Map.get(num) + 1);
			}
		}
		int p1HighestStreak = 0;
		int p1SecondStreak = 0;
		for (Entry<Integer, Integer> entry : p1Map.entrySet()) {
			if (entry.getValue() > p1HighestStreak) {
				p1HighestStreak = entry.getValue();
			} else if (entry.getValue() > p1SecondStreak) {
				p1SecondStreak = entry.getValue();
			}
		}

		HashMap<Integer, Integer> p2Map = new HashMap<Integer, Integer>();
		for (int num : p2Nums) {
			if (!p2Map.containsKey(num)) {
				p2Map.put(num, 1);
			} else {
				p2Map.put(num, p2Map.get(num) + 1);
			}
		}
		int p2HighestStreak = 0;
		int p2SecondStreak = 0;
		for (Entry<Integer, Integer> entry : p2Map.entrySet()) {
			if (entry.getValue() > p2HighestStreak) {
				p2HighestStreak = entry.getValue();
			} else if (entry.getValue() > p2SecondStreak) {
				p2SecondStreak = entry.getValue();
			}
		}

		boolean p1FullHouse = p1HighestStreak == 3 && p1SecondStreak == 2;
		boolean p2FullHouse = p2HighestStreak == 3 && p2SecondStreak == 2;
		boolean p1TwoPair = p1HighestStreak == 2 && p1SecondStreak == 2;
		boolean p2TwoPair = p2HighestStreak == 2 && p2SecondStreak == 2;

		// royal stright flush
		if (p1Hand.isRoyalStraightFlush()) {
			return true;
		} else if (p2Hand.isRoyalStraightFlush()) {
			return false;
		}
		// straight flush
		else if (p1Hand.isStraightFlush() && p2Hand.isStraightFlush()) {
			System.out.println("ERROR 1");
			return true;
		} else if (p1Hand.isStraightFlush()) {
			return true;
		} else if (p2Hand.isStraightFlush()) {
			return false;
		}
		// four of a kind
		else if (p1Hand.isFourOfAKind() && p2Hand.isFourOfAKind()) {
			System.out.println("ERROR 2");
			return true;
		} else if (p1Hand.isFourOfAKind()) {
			return true;
		} else if (p2Hand.isFourOfAKind()) {
			return false;
		}
		// full house
		else if (p1Hand.isFullHouse() && p2Hand.isFullHouse()) {
			System.out.println("ERROR 3");
			return true;
		} else if (p1Hand.isFullHouse()) {
			return true;
		} else if (p2Hand.isFullHouse()) {
			return false;
		}
		// flush
		else if (p1Hand.isFlush() && p2Hand.isFlush()) {
			System.out.println("ERROR 3");
			return true;
		} else if (p1Hand.isFlush()) {
			return true;
		} else if (p2Hand.isFlush()) {
			return false;
		}
		// straight
		else if (p1Hand.isStraight() && p2Hand.isStraight()) {
			System.out.println("ERROR 4");
			return true;
		} else if (p1Hand.isStraight()) {
			return true;
		} else if (p2Hand.isStraight()) {
			return false;
		}
		// three of a kind
		else if (p1Hand.isThreeOfAKind() && p2Hand.isThreeOfAKind()) {
			System.out.println("ERROR 5");
			return true;
		} else if (p1Hand.isThreeOfAKind()) {
			return true;
		} else if (p2Hand.isThreeOfAKind()) {
			return false;
		}
		// two pairs
		else if (p1Hand.isTwoPair() && p2Hand.isTwoPair()) {
			System.out.println("ERROR 6");
			return true;
		} else if (p1Hand.isTwoPair()) {
			return true;
		} else if (p2Hand.isTwoPair()) {
			return false;
		}
		// one pair
		else if (p1Hand.isOnePair() && p2Hand.isOnePair()) {
			if (p1Hand.getHighest(2) == p2Hand.getHighest(2)) {
				if (p1Hand.getHighest(1) == p2Hand.getHighest(1)) {
					System.out.println("ERROR 7");
					return true;
				} else if (p1Hand.getHighest(1) > p2Hand.getHighest(1)) {
					return true;
				}
				return false;
			} else if (p1Hand.getHighest(2) > p2Hand.getHighest(2)) {
				return true;
			}
			return false;
		} else if (p1Hand.isOnePair()) {
			return true;
		} else if (p2Hand.isOnePair()) {
			return false;
		}
		// high card
		else if (p1Hand.getHighest(1) == p2Hand.getHighest(1)) {
			System.out.println("ERROR 8");
			return true;
		} else if (p1Hand.getHighest(1) > p2Hand.getHighest(1)) {
			return true;
		}
		return false;
	}
}

class PokerHand {
	String[] cards;
	int[] nums;
	HashMap<Integer, Integer> map;
	int highestStreak;
	int secondStreak;

	public PokerHand(String[] cards) {
		this.cards = cards;
		nums = new int[5];
		for (int i = 0; i < 5; i++) {
			char c = cards[i].charAt(0);
			if (c >= 'A' && c <= 'Z') {
				if (c == 'T') {
					nums[i] = 10;
				}
				if (c == 'J') {
					nums[i] = 11;
				}
				if (c == 'Q') {
					nums[i] = 12;
				}
				if (c == 'K') {
					nums[i] = 13;
				}
				if (c == 'A') {
					nums[i] = 14;
				}
			} else {
				nums[i] = c - 48;
			}
		}
		Arrays.sort(nums);

		map = new HashMap<Integer, Integer>();
		for (int num : nums) {
			if (!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				map.put(num, map.get(num) + 1);
			}
		}
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > highestStreak) {
				highestStreak = entry.getValue();
			} else if (entry.getValue() > secondStreak) {
				secondStreak = entry.getValue();
			}
		}
	}

	public int getHighest(int amnt) {
		int high = 0;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == amnt) {
				if (entry.getKey() > high) {
					high = entry.getKey();
				}
			}
		}
		return high;
	}

	public boolean isFlush() {
		return cards[0].charAt(1) == cards[1].charAt(1) && cards[0].charAt(1) == cards[2].charAt(1) && cards[0].charAt(1) == cards[3].charAt(1) && cards[0].charAt(1) == cards[4].charAt(1);
	}

	public boolean isFourOfAKind() {
		return highestStreak == 4;
	}

	public boolean isFullHouse() {
		return highestStreak == 3 && secondStreak == 2;
	}

	public boolean isOnePair() {
		return highestStreak == 2;
	}

	public boolean isRoyalStraightFlush() {
		return isFlush() && isStraight() && nums[0] == 10;
	}

	public boolean isStraight() {
		return (nums[0] == nums[1] - 1 && nums[0] == nums[2] - 2 && nums[0] == nums[3] - 3 && nums[0] == nums[4] - 4);
	}

	public boolean isStraightFlush() {
		return isStraight() && isFlush();
	}

	public boolean isThreeOfAKind() {
		return highestStreak == 3;
	}

	public boolean isTwoPair() {
		return highestStreak == 2 && secondStreak == 2;
	}

}

/*
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
