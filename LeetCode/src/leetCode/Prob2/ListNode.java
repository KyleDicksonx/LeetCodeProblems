package leetCode.Prob2;

import java.util.Arrays;
import java.util.Collections;

/**
 * A linked list
 */
public class ListNode {
	int val;
	ListNode next;
	ListNode(){}
	ListNode(int val) {this.val = val;}
	ListNode(int val, ListNode next) {this.val = val; this.next = next;}
	
	public static ListNode listNodeBuilder(int[] values) {
		
		//Collections.reverse(Arrays.asList(values));
		for (int i = 0; i < values.length / 2; i++) {
            int t = values[i];
            values[i] = values[values.length - 1 - i];
            values[values.length - 1 - i] = t;
        }
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
	
	public static void printString(ListNode l) {
		if (l == null) {
			System.out.println();
			return;
		}
		System.out.print(l.val + " ");
		printString(l.next);
	}
}
