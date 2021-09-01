// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation.

// Example 1:

// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]
// Example 2:

// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        int[] finalSum = new int[nums.length];
        
        leftSum[0] = 1;
        for(int i =1; i< nums.length; i++){
            leftSum[i] = leftSum[i-1] * nums[i-1];
        }
        
        rightSum[nums.length-1] = 1;
        for(int i =nums.length-2; i>= 0; i--){
            rightSum[i] = rightSum[i+1] * nums[i+1];
        }
        
        for(int i =0; i< nums.length; i++){
            finalSum[i] = leftSum[i] * rightSum[i];
        }
        return finalSum;
        
    }
}
