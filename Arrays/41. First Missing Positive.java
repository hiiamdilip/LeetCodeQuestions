// Given an unsorted integer array nums, return the smallest missing positive integer.

// You must implement an algorithm that runs in O(n) time and uses constant extra space.

// Example 1:

// Input: nums = [1,2,0]
// Output: 3
// Example 2:

// Input: nums = [3,4,-1,1]
// Output: 2
// Example 3:

// Input: nums = [7,8,9,11,12]
// Output: 1

class Solution {
    public int firstMissingPositive(int[] nums) {
       Set<Integer> set = new HashSet<>();
       for(int i =0; i< nums.length;i++){
           set.add(nums[i]);
       }
        
       for(int i=1; i<= nums.length; i++){
          if(!set.contains(i)) return i;
          if(i == nums.length) return i+1;
       }
       
       return 1;
    }
}

class Solution {
    public int firstMissingPositive(int[] nums) {
       Arrays.sort(nums);
       int smallest = 1;
       for(int i =0; i<nums.length;i++){
          if(nums[i] == smallest) smallest++;
       }
        return smallest;
    }
}
