package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Map.Entry;

public class LibClass {
/**
 * 141 
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 * @param head
 * @return
 */
	public boolean isCycle(ListNode head) {
		if(head == null || head.next == null) return false;
	       if(head.next == head) return true;
	       ListNode nextNode = head.next; 
	       head.next = head;
	       boolean isCycle = isCycle(nextNode);
	       return isCycle;
	}
	/**
	 * 20
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
	 * An input string is valid if:
	 * Open brackets must be closed by the same type of brackets.
	 * Open brackets must be closed in the correct order.
	 * 
	 * Note that an empty string is also considered valid.
	 * @param str
	 * @return
	 */
	public Boolean isValid(String str) {
		char[] chars = str.toCharArray();
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
				stack.push(chars[i]);
			} else if (stack.size() == 0 || stack.pop() != map.get(chars[i])) {
				return false;
			}
		}
		return stack.size() == 0;
	}
	
	public int findLongestPalindrome(String str) {
		char[] chars = str.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < chars.length; i++) {
			if (map.containsKey(chars[i])) {
				map.put(chars[i], map.get(chars[i]) + 1);
			} else {
				map.put(chars[i], 1);
			}
		}

		int repated = 0, single = 0;
		Set<?> set = map.entrySet();
		Iterator<?> it = set.iterator();
		while (it.hasNext()) {
			Entry<?, ?> entry = (Entry<?, ?>) it.next();
			if ((Integer) (entry.getValue()) % 2 == 1) {
				single = 1;
			}
			repated += (Integer) (entry.getValue()) / 2 * 2;
		}
		return repated + single;
	}

	public void shuffleArray(int[] array) {
		int[] zerocount = new int[array.length];
		zerocount[0] = (array[0] == 0) ? 1 : 0;
		for (int i = 1; i <= array.length - 1; i++) {
			zerocount[i] = (array[i] == 0) ? (zerocount[i - 1] + 1) : zerocount[i - 1];
			int temp = 0;
			if (zerocount[i - 1] != 0) {
				temp = array[i] + array[(i - zerocount[i - 1])];
				array[i] = temp - array[i];
				array[i - zerocount[i - 1]] = temp - array[i - zerocount[i - 1]];
				temp = 0;
			}
		}
	}

	public int findSingle(int[] array) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				map.put(array[i], 1);
			} else {
				map.put(array[i], 0);
			}
		}

		Set<?> set = map.entrySet();
		Iterator<?> it = set.iterator();
		while (it.hasNext()) {
			Entry<?, ?> entry = (Entry<?, ?>) it.next();
			if (entry.getValue().equals(0)) {
				return Integer.parseInt(entry.getKey().toString());
			}
		}
		return -1;
	}
	public String findFirstUniqueChar(String testString) {
		// TODO Auto-generated method stub
		return null;
	}

}
