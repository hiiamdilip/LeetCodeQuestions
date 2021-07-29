// Example 1:
// Input: head = [3,2,0,-4], pos = 1
// Output: true
// Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
  
// Example 2:
// Input: head = [1,2], pos = 0
// Output: true
// Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//Method 1:
public class Solution {
    public boolean hasCycle(ListNode head) {
       if(head == null) return false;
       Set<ListNode> set = new HashSet<>();
       while(head != null){
           if(set.contains(head)) return true;
           set.add(head);
           head = head.next;
       }
        return false;
    }
}

//Method 2:
public class Solution {
    public boolean hasCycle(ListNode head) {
      if(head == null) return false;
       ListNode fast = head;
       ListNode slow = head;
       while(fast != null && fast.next != null){
           fast = fast.next.next;
           slow = slow.next;
           if(fast == slow) return true;
       }
        return false;  
    }
}
