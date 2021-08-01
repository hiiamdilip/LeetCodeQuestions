// Input: head = [1,1,2]
// Output: [1,2]

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      ListNode temp = head;
      while(temp != null && temp.next != null){
          if(temp.val == temp.next.val){
              temp.next = temp.next.next;
          }else{
              temp = temp.next;
          } 
      }  
        return head;
    }
}
