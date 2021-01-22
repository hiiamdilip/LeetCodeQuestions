//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<nums.length; i++){
            int comp = target - nums[i];
            if(map.containsKey(comp)){
                return new int[] {map.get(comp), i};
            }
            else{
                map.put(nums[i],i);
            }
        }
        return new int[] {-1, -1};
    }
}
