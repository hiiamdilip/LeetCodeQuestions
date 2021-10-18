//Implement pow(x, n), which calculates x raised to the power n (i.e. xn).

// Input: x = 2.00000, n = 10
// Output: 1024.00000
  
// Input: x = 2.00000, n = -2
// Output: 0.25000
// Explanation: 2-2 = 1/22 = 1/4 = 0.25

class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        double res = myPow(x,n/2);
        if(n%2 == 0){
            return res*res;
        }
        if(n>0)return res*res*x;
        return res*res*(1/x);
    }
}
