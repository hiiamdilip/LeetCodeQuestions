// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

// Example 1:

// Input: nums = [1,2,3,1]
// Output: true
// Example 2:

// Input: nums = [1,2,3,4]
// Output: false
// Example 3:

// Input: nums = [1,1,1,3,3,4,3,2,4,2]
// Output: true
  
// Method 1:

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > 1) return true;
        }
        return false;
    }
}

// Method 2:
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int i =0; i<nums.length; i++){
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);  
        }
        return false;
    }
}
