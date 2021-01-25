//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].

class Solution {
    public int reverse(int x) {
        int result = 0;
        int a;
        int k =0;
        
        if(x<0) {
            k=1;
            x = x*-1;
        }

        while(x>0){
            a = x%10;
            x = x/10;
            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && a > 7)) return 0;
            if(result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && a < -8)) return 0;
            result = result*10 + a;
        } 
        return k==0 ? result: (result*-1);
    }
}
