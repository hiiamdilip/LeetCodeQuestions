Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Input: heights = [2,4]
Output: 4


class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        int[] right = new int[n];
        int[] left = new int[n];
        Stack<Integer> stack = new Stack();
        
        //right smaller
        for(int i = n-1; i>=0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            if(stack.isEmpty()) right[i] = n;
            else right[i] = stack.peek();
            stack.push(i);
        }

        while(!stack.isEmpty()) stack.pop();

        //left smaller
        for(int i = 0; i<n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            if(stack.isEmpty()) left[i] = -1;
            else left[i] = stack.peek();
            stack.push(i);
        }
        
        for(int i =0; i<n; i++) {
            int width = right[i] - left[i] -1;
            int currArea = heights[i] * width;
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }
}
