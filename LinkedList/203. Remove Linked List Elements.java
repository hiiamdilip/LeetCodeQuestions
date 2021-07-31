// Input: head = [1,2,6,3,4,5,6], val = 6
// Output: [1,2,3,4,5]

//Method 1:
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode tmp = head;
        while(tmp.next != null){
            if(tmp.next.val == val){
                tmp.next = tmp.next.next;
            }
            else tmp = tmp.next;
        }
        if(head.val == val) return head.next;
        return head;
    }
}

//Method 2: 
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        
        if(head.val ==val){
            return removeElements(head.next, val);
        }
        head.next = removeElements(head.next, val);
        return head;
    }
}
