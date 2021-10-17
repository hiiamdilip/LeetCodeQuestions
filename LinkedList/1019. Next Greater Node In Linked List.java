// You are given the head of a linked list with n nodes.

// For each node in the list, find the value of the next greater node. That is, for each node, find the value of the first node that is next to it and has a strictly larger value than it.

// Return an integer array answer where answer[i] is the value of the next greater node of the ith node (1-indexed). If the ith node does not have a next greater node, set answer[i] = 0.

// Example 1:

// Input: head = [2,1,5]
// Output: [5,5,0]
// Example 2:


// Input: head = [2,7,4,3,5]
// Output: [7,0,5,5,0]

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
    public int[] nextLargerNodes(ListNode head) {
       List<Integer> list = new ArrayList<>();
       List<Integer> tempList = new ArrayList<>();
    
       for(ListNode temp = head; temp != null; temp = temp.next){
           list.add(temp.val);
       }
        
       Stack<Integer> stack = new Stack();
       int[] result = new int[list.size()];
        
       for(int i = list.size() -1 ; i>=0; i--){
           while(!stack.isEmpty() && stack.peek() <= list.get(i)) stack.pop();
           
           if(stack.isEmpty())tempList.add(0);
           else tempList.add(stack.peek());
           
           stack.push(list.get(i));
       }
       
       int j =0;
       for(int i = tempList.size() -1; i>=0; i--) result[j++] = tempList.get(i);
        
       return result;  
       
    }
}
