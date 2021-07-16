// Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

// You must write an algorithm that runs in O(n) time and uses only constant extra space.
  
// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [2,3]

//Method 1: 

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length < 1) return result;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }
            else{
                map.put(nums[i], 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()>1){
                result.add(entry.getKey());
            }
        }
        return result;
    }
}

//Method 2: 

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length < 1) return result;
        
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) -1;
            if(nums[index] < 0) result.add(index + 1);
            nums[index] = -nums[index];
        }
        
        return result;
    }
}
