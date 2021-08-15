// Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

// You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

// Example 1:

// Input: num1 = "11", num2 = "123"
// Output: "134"
// Example 2:

// Input: num1 = "456", num2 = "77"
// Output: "533"
// Example 3:

// Input: num1 = "0", num2 = "0"
// Output: "0"

class Solution {
    public String addStrings(String num1, String num2) {
       int carry = 0;
       int i = num1.length()-1;
       int j = num2.length()-1;
       StringBuilder  result = new StringBuilder();
       while(i>=0 || j>=0){
           int a=0;
           int b=0;
           if(i>=0)a = Integer.parseInt(num1.substring(i,i+1));
           if(j>=0)b = Integer.parseInt(num2.substring(j,j+1));
           int sum = a+b+carry;
           
           carry = sum/10;
           sum = sum%10;
           
           result.append(sum);
           i--;
           j--;
       } 
       if(carry != 0)  result.append(carry);
        return result.reverse().toString();
    }
}
