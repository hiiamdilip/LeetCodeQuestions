Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] resultArray = new int[2];
        resultArray[0] = findFirst(nums, target);
        resultArray[1] = findLast(nums, target);
        return resultArray;
    }

    int findFirst(int[] nums, int target){
        int left =0;
        int right = nums.length -1;
        int first = -1;
        while(left <= right){
            int mid = left + (right -left)/ 2;
            if(nums[mid] == target){
                first = mid;
                right = mid -1;
            } else if(nums[mid] > target){
                right = mid -1;
            } else{
                left = mid+1;
            }
        }
        return first;
    }

    int findLast(int[] nums, int target){
        int left =0;
        int right = nums.length -1;
        int last = -1;
        while(left <= right){
            int mid = left + (right -left)/ 2;
            if(nums[mid] == target){
                last = mid;
                left = mid+1;
            } else if(nums[mid] > target){
                right = mid -1;
            } else{
                left = mid+1;
            }
        }
        return last;
    }
}
