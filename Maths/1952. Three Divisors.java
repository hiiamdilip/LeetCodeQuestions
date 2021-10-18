// Given an integer n, return true if n has exactly three positive divisors. Otherwise, return false.

// An integer m is a divisor of n if there exists an integer k such that n = k * m.

// Example 1:

// Input: n = 2
// Output: false
// Explantion: 2 has only two divisors: 1 and 2.
// Example 2:

// Input: n = 4
// Output: true
// Explantion: 4 has three divisors: 1, 2, and 4.

class Solution {
    public boolean isThree(int n) {
        if(n <=3 ) return false;
        int count = 2;
        for(int i = 2; i<= n/2; i++){
            if(count > 3) return false;
            if(n%i == 0) count++;
        } 
        return (count==3);
    }
}

//Method 2:
// Here the question says to check whether the number has 3 divisors or not. So the number is clearly a square of any prime. As then only it will have 3 divisors. The 3 divisors will be 1 , n and the prime number.
// E.g n=49 , so the divisors are 1,7,and 49. You don't have other divsors for this. So the approach is to find if the number's sqaure root is prime or not.
class Solution {
    public boolean isThree(int n) {
        if(n<4 ) return false;
        int res = (int)Math.sqrt(n);
        for(int i=2;i*i<n;i++){
            if(res%i ==0) return false;
        }
        return true;
}}
