// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
  
// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]

//Method 1 - any sorting, here its bubble sort

class Solution {
    public void sortColors(int[] nums) {
        int temp;
        for(int i = 0; i< nums.length; i++){
            for(int j =i+1;j< nums.length; j++){
                if(nums[i] > nums[j]){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp; 
                }
            }
        }
    }
}

//Method 2 - 1 pass solution
class Solution {
    public void sortColors(int[] nums) {
        int start =0;
        int index =0;
        int end = nums.length-1;
        while( index<=end && start<end){
            if(nums[index] == 0){
                nums[index] = nums[start];
                nums[start] = 0;
                index++;
                start++;
            }else if(nums[index] == 2){
                nums[index] = nums[end];
                nums[end] = 2;
                end--;
            }else
                index++;
        }
    }
}
