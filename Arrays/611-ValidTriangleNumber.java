// Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
 
// Input: nums = [2,2,3,4]
// Output: 3
// Explanation: Valid combinations are: 
// 2,3,4 (using the first 2)
// 2,3,4 (using the second 2)
// 2,2,3

//Method 1 - Brute force

class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i =0; i<n;i++){
            for(int j = i+1; j<n;j++){
                for(int k =j+1;k<n;k++){
                    if(nums[i] + nums[j] > nums[k] &&
                      nums[i] + nums[k] > nums[j] &&
                      nums[k] + nums[j] > nums[i]){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

//Method 2

class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        if(nums.length < 3) return count;
        Arrays.sort(nums);
        for(int i =2; i< nums.length; i++){
            int left = 0;
            int right = i-1;
            while(left < right){
                if(nums[left] + nums[right] > nums[i]){
                   count += (right-left);
                   right--;
                }
                else{
                    left++;
                }
            }
        }
        return count;
    }
}
