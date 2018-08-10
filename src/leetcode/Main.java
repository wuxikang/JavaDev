package leetcode;

public class Main {

	public static void main(String[] args) {
		/**
		 * Shuffle Array
		 */
		 int[] array = { 0, 8, 0, 0, 3, 0, 3, 0, 0, 4, 5, 10, 0, 8, 0 };
		 LibClass lc = new LibClass();
		 lc.shuffleArray(array);
		 for (int i = 0; i <= array.length - 1; i++) {
		 System.out.print(array[i] + " ");
		 }
		/**
		 * Find Single
		 */

		 int[] arrary={2,2,3,5,3,4,7,5,4};
		 int singlenumber=lc.findSingle(arrary);
		 System.out.println("Single number is "+singlenumber);

		/**
		 * Find First Unqiue Char
		 */

		 String s="zzzzz";
		 int len=s.split(String.valueOf("z")).length;
		 System.out.println(len);
		 String testString="llovethistopic";
		 String testString1="z";
		 System.out.println("First Unique Char index of "+testString+" is "+lc.findFirstUniqueChar(testString));
		 System.out.println("First Unique Char index of "+testString1+" is "+lc.findFirstUniqueChar(testString1));

		 String str = "abccccdd";
		 System.out.println("The Longset Palindrome of " + str + " is " +
		 lc.findLongestPalindrome(str));

		String str1 = "([{{{}}}])[]";
		String str2 = "{()[]}";
		String str3 = "{([)]}";
		System.out.println(lc.isValid(str1));
		System.out.println(lc.isValid(str2));
		System.out.println(lc.isValid(str3));

		ListNode node = new ListNode(222);
		node.next = new ListNode(333);
		node.next.next = new ListNode(444);
		node.next.next.next = new ListNode(555);
		node.next.next.next.next = new ListNode(323);

		node = new ListNode(234);
		node.next = new ListNode(235);
		node.next.next = new ListNode(234);
		node.next = new ListNode(5);
		System.out.println("result is " + lc.isCycle(node));

	}

	
	

	
	

}
