/**
 * THIS ATTEMPT IS SCRAPPED FOR OVERFLOWING VALUES
 * A new attempt is needed that will not run into overflowing integers
 * I plan to handle each digit separately for as long as possible
 * See Problem2Attempt2.java for my 2nd and hopefully final attempt
 */

package leetCode.Prob2;

public class Problem2 {
	/**
	 * The main is commented out to avoid issues
	 * @param args
	 */
	/*
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
		
		System.out.println(result);
	}*/
	
	
	/**
	 * NOTE: This dosent work for large numbers because of overflowing numbers
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		System.out.println(l1);
		System.out.println(l2);
		System.out.println("---");
		
        //build number 1
        int loop = 0;
        int l1Value = 0;
        while (l1 != null) {
            l1Value += (loop == 0) ? l1.val : l1.val * Math.pow(10, loop);
            System.out.println("l1Value = " + l1Value);
            l1 = l1.next;
            loop++;
        }
        System.out.println("---");
        
        //build number 2
        loop = 0;
        long l2Value = 0;
        while (l2 != null) {
            l2Value += (loop == 0) ? l2.val : l2.val *  Math.pow(10, loop);
            System.out.println("l2Value = " + l2Value);
            l2 = l2.next;
            loop++;
        }

        //sum numbers
        long totalValue = l1Value + l2Value;
        System.out.println(totalValue);

        //rebuild new linked list using mod 10 for last digit
        ListNode current = null;
        
        int[] values = new int[String.valueOf(totalValue).length()];
        int i = values.length - 1;
        while (totalValue > 0) {
        	values[i--] = (int) (totalValue % 10);
        	totalValue = totalValue / 10;
        }
        System.out.println(values[0]);
        for (int x : values) {
        	if (current == null) {
                current = new ListNode(x);
            } else {
                current = new ListNode(x, current);
            }
        }
        
        
        /*
        while (totalValue > 0) {
            //start from the last smallest digit that appears at the end of the list
            //and build the list backwards from there
        	System.out.println(totalValue % 10);
            if (current == null) {
                current = new ListNode(totalValue % 10);
            } else {
                current = new ListNode(totalValue % 10, current);
            }

            //take off the last digit
            totalValue = totalValue / 10;

            //prev = current;
        }
		*/



        return current;
    }
}
