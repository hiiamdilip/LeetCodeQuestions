// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
// Example 2:

// Input: height = [1,1]
// Output: 1
// Example 3:

// Input: height = [4,3,2,1,4]
// Output: 16
// Example 4:

// Input: height = [1,2,1]
// Output: 2
class Solution {
    public int maxArea(int[] height) {
       int i = 0;
       int j = height.length-1;
       int area = 0;
       while(i < j){
          area = Math.max(area, (Math.min(height[i], height[j]) * (j-i)));
          if(height[i] < height[j]) i++;
          else j--;         
       }
        return area;
    }
}
