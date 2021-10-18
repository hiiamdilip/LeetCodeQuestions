//Given an integer n, return true if it is a power of four. Otherwise, return false.

//An integer n is a power of four, if there exists an integer x such that n == 4x.

//Input: n = 16
//Output: true
//Input: n = 5
//Output: false

//Method 1
class Solution {
    public boolean isPowerOfFour(int n) {
       if(n==0) return false;
        while(n != 1 ){
           if(n % 4 != 0) return false;
           n = n/4;
       } 
        return true;
    }
}

//Method 2
class Solution {
    public boolean isPowerOfFour(int n) {
       if(Math.log(n)/Math.log(4) %1 ==0) return true;
        else return false;
    }
}
