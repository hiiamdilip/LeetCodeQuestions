// Given an integer array nums and an integer k, return the kth largest element in the array.

// Note that it is the kth largest element in the sorted order, not the kth distinct element.

// Example 1:

// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5
// Example 2:

// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
// Output: 4

class Solution {
    public int findKthLargest(int[] nums, int k) {
       Queue<Integer> queue = new PriorityQueue<>();
        for(int i : nums){
            queue.offer(i);
            if(queue.size() > k) queue.poll();
        }
        return queue.peek();
    }
}


// Input: nums = ["3","6","7","10"], k = 4
// Output: "3"
// Explanation:
// The numbers in nums sorted in non-decreasing order are ["3","6","7","10"].
// The 4th largest integer in nums is "3".

import java.math.BigInteger;
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Queue<BigInteger> queue = new PriorityQueue<>();
        
        for(String s : nums){
            queue.offer(new BigInteger(s));
            if(queue.size() > k) queue.poll();
        }
        return String.valueOf(queue.peek());
    }
}

//For Kth min
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int element : nums){
            queue.offer(element);
            if(queue.size() > k) queue.poll();
        }
        return queue.peek();
    }
}
