// Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

// The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

// You may assume the integer does not contain any leading zero, except the number 0 itself.

// Example 1:

// Input: digits = [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.


// Get the number of digits in the array
       int length = digits.length;
     
       // Iterate over the digits starting from the least significant digit (LSD)
       for (int i = length - 1; i >= 0; --i) {
           // Increase the current digit by one
           digits[i]++;
         
           // If after the increment the digit is 10, it means it should be 0, and we carry over 1.
           // But if it's not 10 after the increment, we can return the result immediately.
           digits[i] %= 10;
           if (digits[i] != 0) {
               return digits;
           }
       }
     
       // If we're here, it means that we had a carry out from the most significant digit (MSD)
       // which requires us to expand the array. Example: 999 + 1 = 1000
       int[] result = new int[length + 1];
       result[0] = 1; // Set the first element to 1, the rest are default to 0
     
       // Return the result which has an additional digit
       return result;



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
