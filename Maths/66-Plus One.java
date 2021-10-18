// Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

// The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

// You may assume the integer does not contain any leading zero, except the number 0 itself.

// Example 1:

// Input: digits = [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.

class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length == 0) return digits;
        int carry = 1;
        for(int i = digits.length -1; i>=0; i--){
            int current = digits[i];
            digits[i] = (current + carry)%10;
            carry = (current + carry)/10;
        }
        if(carry == 1){
            int[] newArray = new int[digits.length +1];
            newArray[0] = 1;
            for(int i =1;i<digits.length +1; i++){
                newArray[i]= digits[i-1];
            }
             return newArray;
        }
        return digits;
    }
}
