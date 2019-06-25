/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headRes = new ListNode(0); // create head node
        ListNode res = headRes; // pointer for current node
        int carry = 0; // carry value (outside of main loop so it stays between iterations)
        while (true) {
            int val_1 = l1 != null ? l1.val : 0; // if l1 is not null, take its value, otherwise 0
            int val_2 = l2 != null ? l2.val : 0; // same for l2
            if (val_1 + val_2 + carry > 9) { // if carry + numbers to add up are more than 9
                res.val = (val_1 + val_2 + carry) % 10; // value of current node assigned
                carry = 1; // carry is now 1
            }
            else {
                res.val = val_1 + val_2 + carry; // if less than 9, then just do the sum
                carry = 0; // carry reset to zero
            }
            if (l1 != null) l1 = l1.next; // if its not null, then go to next (eventually will be null)
            if (l2 != null) l2 = l2.next; // same for l2
            if (l1 == null && l2 == null && carry == 0) break; // loop breaks once the end of both nums is reached AND carry is zero
            
            // ^ the above is to ensure correct answer in cases such as input{[1],[9]} ---> output{[0,1]}
            
            res.next = new ListNode(0); // make new next node
            res = res.next; // move pointer to next node
        }
        return headRes;
    }
}
