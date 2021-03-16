//Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
//Input: x = 123
//Output: 321

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
            result = result*10 + a;
            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
        } 
        return k==0 ? result: (result*-1);
    }
}
