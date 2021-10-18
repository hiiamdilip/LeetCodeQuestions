// Given a positive integer num, write a function which returns True if num is a perfect square else False.

// Follow up: Do not use any built-in library function such as sqrt.

// Example 1:

// Input: num = 16
// Output: true
// Example 2:

// Input: num = 14
// Output: false

class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        int low = 0;
        int high = num/2;
        long square;
        while(low <= high){
            int mid = low + (high-low)/2;
            square = (long)mid*mid;
            if(square == num) return true;
            if(square > num) high = mid -1;
            else low = mid + 1;
        }
        return false;  
    }
}
