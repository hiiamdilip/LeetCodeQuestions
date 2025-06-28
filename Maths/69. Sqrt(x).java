// Given a non-negative integer x, compute and return the square root of x.

// Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

// Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.

// Example 1:

// Input: x = 4
// Output: 2
// Example 2:

// Input: x = 8
// Output: 2
// Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.

class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x==1) return x;
        int low = 2; 
        int high = x/2;
        long square;
        while(low <= high){
           int mid = low + (high -low)/2;
           square = (long) mid * mid;
           if(square == x) return mid;
           if(square > x) high = mid -1;
           else low = mid +1;
       } 
        return high;
    }
}
