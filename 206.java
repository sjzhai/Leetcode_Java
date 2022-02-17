/*
206. Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the reversed list.

--------------------------------------------------------------------------------------------
Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []

Constraints:
The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000

--------------------------------------------------------------------------------------------

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        return recursiveList(null, head);
    }

    private ListNode recursiveList(ListNode pre, ListNode curr){
        if(curr == null){
            return pre;
        }
        ListNode next = curr.next; //new node point to the main linked-list next node
        curr.next = pre; // next node of main linked-list point to prev node
        return recursiveList(curr, next);
    }
}