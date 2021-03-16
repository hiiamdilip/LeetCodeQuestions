//Write a function that reverses a string. The input string is given as an array of characters char[].
//Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

//Input: ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]
  
class Solution {
    public void reverseString(char[] s) {
        int i = s.length-1;
        int j = 0;
        while(j<i){
            char temp = s[j];
            s[j]=s[i];
            s[i]=temp;
            i--;
            j++;  
        }  
    }
}
