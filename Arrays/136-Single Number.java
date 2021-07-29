// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

// You must implement a solution with a linear runtime complexity and use only constant extra space.

// Example 1:

// Input: nums = [2,2,1]
// Output: 1
// Example 2:

// Input: nums = [4,1,2,1,2]
// Output: 4
// Example 3:

// Input: nums = [1]
// Output: 1
  
// Method 1:
class Solution {
    public int singleNumber(int[] nums) {
       Set temp = new HashSet<>();
        int sum =0;
        int setSum =0;
        for(int i =0; i<nums.length;i++){
            temp.add(nums[i]);
            sum = sum + nums[i];
        }
        Iterator<Integer> itr = temp.iterator();
        
        
        while(itr.hasNext()){
            setSum = setSum + itr.next();
        }
        return (2*setSum - sum);
        
        
    }
}

// Method 2:
class Solution {
    public int singleNumber(int[] nums) {
        int a =0;
        for(int i:nums){
            a ^= i;
        }
        return a;
    }
}
