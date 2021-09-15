// Example 1:

// Input: n = 1
// Output: true
// Explanation: 20 = 1
// Example 2:

// Input: n = 16
// Output: true
// Explanation: 24 = 16
// Example 3:

// Input: n = 3
// Output: false
// Example 4:

// Input: n = 4
// Output: true
// Example 5:

// Input: n = 5
// Output: false

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
    
        while(n != 1){
           if(n % 2 != 0)return false;
           n = n/2;
        }
        return true;
    }
}
