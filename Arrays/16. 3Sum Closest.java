Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Set<Integer> sumSet = new HashSet();
        Arrays.sort(nums);

        for(int i =0; i<nums.length -2; i++){
            int left = i+1;
            int right = nums.length -1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                sumSet.add(sum);
                if(sum ==target) return sum;
                else if(sum > target){
                   right--;
                } else {
                    left++;
                }
            }
        }
        int result = nums[0] + nums[1]+ nums[2];
        for(int sum:sumSet){
            if(Math.abs(target - sum) < Math.abs(target - result)){
                result = sum;
            }
        }
        return result;
    }
}


class Solution {
    public int threeSumClosest(int[] nums, int target) {
       
        Arrays.sort(nums);
        int result = nums[0] + nums[1]+ nums[2];

        for(int i =0; i<nums.length -2; i++){
            int left = i+1;
            int right = nums.length -1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
               if(Math.abs(target - sum) < Math.abs(target - result)){
                result = sum;
            }
                if(sum ==target) return sum;
                else if(sum > target){
                   right--;
                } else {
                    left++;
                }
            }
        }
      
        return result;
    }
}
