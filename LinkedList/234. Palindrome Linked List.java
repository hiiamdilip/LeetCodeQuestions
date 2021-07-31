// Input: head = [1,2,2,1]
// Output: true
  
// Input: head = [1,2]
// Output: false

// Method 1:
class Solution {
    public boolean isPalindrome(ListNode head) {
       if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reversed(slow);
        fast = head;
        while(slow != null){
            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;  
    }
    public ListNode reversed(ListNode head){
       ListNode next = null;
       ListNode prev = null;
       ListNode curr = head;
       ListNode temp = head;
       while(curr != null){
          next = curr.next;
          curr.next = prev;
          prev = curr;
          curr = next;  
       }
        return prev;
    }
}
