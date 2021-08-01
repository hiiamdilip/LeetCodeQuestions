// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]
// Explanation: 342 + 465 = 807.

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode temp = l3;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int val1 = 0;
            int val2 = 0;
            if(l1 != null){
                val1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                val2 = l2.val;
                l2 = l2.next;
            }
            int finalValue = val1 + val2 + carry;
            temp.next = new ListNode(finalValue % 10);
            temp = temp.next;
            carry = finalValue/10;
        }
        return l3.next;
    }
}
