// Given a string s consists of some words separated by some number of spaces, return the length of the last word in the string.

// A word is a maximal substring consisting of non-space characters only.

// Example 1:

// Input: s = "Hello World"
// Output: 5
// Example 2:

// Input: s = "   fly me   to   the moon  "
// Output: 4
// Example 3:

// Input: s = "luffy is still joyboy"
// Output: 6
  
class Solution {
  public int lengthOfLastWord(String s) {
     int count = 0;
     int i = s.length()-1;
     while(s.charAt(i) == ' '){
       i--;  
     }
     while(i>=0){
         if( s.charAt(i) != ' ' ) count++;
         else return count;
         i--;
     }
     return count;
  }
}
