/**
 * Non-funcitoning
 * This was scrapped when I fixed the print issue in attempt 2
 */

package leetCode.Prob2;

import java.util.Arrays;

public class Problem2Attempt3 {
	public static void main(String[] args) {
		System.out.println("Problem 2");
		
		//2 4 3
		int[] list1 = {2, 4, 3};
		int[] list3 = {9};
		int[] list2 = {5, 6, 4};
		ListNode l1 = ListNode.listNodeBuilder(list2);
		
		//5 6 4
		
		
		int[] list4 = {1,9,9,9,9,9,9,9,9,9};
		int[] list6 = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
		//2147483647
		ListNode l2 = ListNode.listNodeBuilder(list6);
		
		
		ListNode result = addTwoNumbers(l1, l2);
		
		System.out.println("Result = " + result);
	}
	/**
	 * Method IDEA
	 * Build 2 arrays from the values in l1 and l2
	 * Then iterate over both adding them into a new array
	 * Then build a ListNode from those values
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		//values will keep getting appended to this list
		ListNode dummy = new ListNode(0, null);
		
		
		//gets the length of the longer list
		ListNode l1Counter = l1;
		ListNode l2Counter = l2;
		
		int length = 0;
		while (l1Counter != null || l2Counter != null) {
			length++;

			if (l1Counter != null) l1Counter = l1Counter.next;
			if (l2Counter != null) l2Counter = l2Counter.next;
		}
		System.out.println("length = " + length);
		
		
		
		//moves through both lists and counts the numbers and properly applies the carry bit
		int i = 0;
		int carry = 0; //acts like a carry bit
		int sum = 0;
		int[] values = new int[length - 1];
		ListNode current = null;
		ListNode prev = null;
		while (l1 != null || l2 != null) {
			
			//print values for debugging
			System.out.println(((l2 == null) ? 0 : l2.val) + " " + ((l1 == null) ? 0 : l1.val) + " " + carry);
			sum =  ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
			if ( sum >= 10 ) { 
				 sum = sum % 10;
				 carry = 1;
			} else {
				carry = 0;
			}
			
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;

			
			current = new ListNode(sum, current);
		}
		
		
		//make an extra spot for the carry if it is still set at the very end
		if (carry != 0) {
			/*
			int[] newValues = new int[values.length + 1];
			System.arraycopy(values, 0, newValues, 0, newValues.length - 1);
			values = newValues;
			values[values.length - 1] = carry;
			*/
			current = new ListNode(carry, current);
			System.out.println("carry");
		} 
		//System.out.println(Arrays.toString(values));
		ListNode.printString(current);

		
		
		
		return dummy.next;
	}
}
