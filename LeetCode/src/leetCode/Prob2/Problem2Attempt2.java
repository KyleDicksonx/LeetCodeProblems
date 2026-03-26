/**
 * EDIT: THIS WAS UNSCRAPPED
 * I forgot to remove one of the print statements and it made the code much slower
 * This solution matches the desired 1ms runtime
 * SOLVED
 * 
 * This attempt was scrapped for being too slow
 * Attempt 3 will be making this version much faster
 * 
 */
package leetCode.Prob2;

import java.util.Arrays;

public class Problem2Attempt2 {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Problem 2");
		
		//2 4 3
		int[] list1 = {2, 4, 3};
		int[] list3 = {9};
		int[] list2 = {5, 6, 4};
		ListNode l1 = ListNode.listNodeBuilder(list3);
		
		//5 6 4
		
		
		int[] list4 = {1,9,9,9,9,9,9,9,9,9};
		int[] list6 = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
		//2147483647
		ListNode l2 = ListNode.listNodeBuilder(list6);
		
		
		ListNode result = addTwoNumbers(l1, l2);
		
		System.out.println(result);
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
		
		
		
		//Both arrays are made to be the same length for easier adding
		//build the array for l1
		int[] l1Values = new int[length]; 
		int i = 0;
		while (l1 != null) {
			l1Values[i++] = l1.val;
			l1 = l1.next;
		}
		System.out.println(Arrays.toString(l1Values));
		
		//build the array for l2
		int[] l2Values = new int[length]; 
		i = 0;
		while (l2 != null) {
			l2Values[i++] = l2.val;
			l2 = l2.next;
		}
		System.out.println(Arrays.toString(l2Values));
		
		//NOTE FOR TMR
		//THIS DOES NOT WORK AS YOU CANT CARRY NUMBERS OVER 
		//ADD A WAY TO COUNT STARTING AT LST
		//ADD A CARRY BIT
		int carry = 0; //acts like a carry bit
		int sum = 0;
		int[] values = new int[length + 1];
		for (int x = 0; x < l1Values.length; x++) {
			
			sum =  l1Values[x] + l2Values[x] + carry;
			if ( sum >= 10 ) { 
				 sum = sum % 10;
				 carry = 1;
			} else {
				carry = 0;
			}
			values[x] = sum;
		}
		if (carry != 0) {
			values[values.length - 1] = carry;
		} else {
			int[] newValues = new int[values.length - 1];
			System.arraycopy(values, 0, newValues, 0, newValues.length);
			values = newValues;
		}
		System.out.println(Arrays.toString(values));
		

		//flip the array for building

		for (int y = 0; y < values.length / 2; y++) {
            int t = values[y];
            values[y] = values[values.length - 1 - y];
            values[values.length - 1 - y] = t;
        }
		
		//build the ListNode
		ListNode current = null;
		for (int x : values) {
        	if (current == null) {
                current = new ListNode(x);
            } else {
                current = new ListNode(x, current);
            }
        }
		
		
		return current;
	}
}
