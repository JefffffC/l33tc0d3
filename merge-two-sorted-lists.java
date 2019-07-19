/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resNode = new ListNode(0);
        ListNode workingNode = resNode;
        while (l1 != null || l2 != null) {
            int addVal;
            if (l1 == null) {
                workingNode.next = l2;
                l2 = l2.next;
            }
            else if (l2 == null) {
                workingNode.next = l1;
                l1 = l1.next;
            }
            else if (l1.val < l2.val) {
                workingNode.next = l1;
                l1 = l1.next;
            }
            else {
                workingNode.next = l2;
                l2 = l2.next;
            }
            workingNode = workingNode.next;
        }
        return resNode.next;
    }
}
