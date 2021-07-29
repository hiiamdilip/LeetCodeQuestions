// We define the usage of capitals in a word to be right when one of the following cases holds:

// All letters in this word are capitals, like "USA".
// All letters in this word are not capitals, like "leetcode".
// Only the first letter in this word is capital, like "Google".
// Given a string word, return true if the usage of capitals in it is right.

// Input: word = "USA"
// Output: true
  
// Input: word = "FlaG"
// Output: false

//Method 1

import java.lang.*;
class Solution {
    public boolean detectCapitalUse(String word) {
        int noOfCapitals = 0;
        for(int i=0; i<word.length(); i++){
            if(Character.isUpperCase(word.charAt(i))) noOfCapitals++;
        }
        if(noOfCapitals == 0 || noOfCapitals == word.length()) return true;
        if(noOfCapitals == 1 && Character.isUpperCase(word.charAt(0))) return true;
        return false; 
    }
}

//Method 2

import java.lang.*;
class Solution {
    public boolean detectCapitalUse(String word) { 
        if(word.length() <=1) return true;
        
        if(Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))){
            for(int i =2; i<word.length(); i++){
                if(Character.isLowerCase(word.charAt(i))) return false;
            }  
        }else{
            for(int i =1; i<word.length(); i++){
                if(Character.isUpperCase(word.charAt(i))) return false;
            }  
        }
        return true;
    }
}
