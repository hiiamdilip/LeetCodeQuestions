// Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

// Example 1:

// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "amanaplanacanalpanama" is a palindrome.
// Example 2:

// Input: s = "race a car"
// Output: false
// Explanation: "raceacar" is not a palindrome.

//Method 1:
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sbr = new StringBuilder();
        for(int i =0; i< s.length(); i++){
           if((s.charAt(i) >= 'a' && 
              s.charAt(i) <= 'z') || 
              (s.charAt(i) >= 'A' && 
              s.charAt(i) <= 'Z') || 
              (s.charAt(i) >= '0' && 
              s.charAt(i) <= '9')) sbr.append(Character.toLowerCase(s.charAt(i))); 
        }
        String newString = sbr.toString();
        int i =0; int j = newString.length()-1;
        while(i<=j){
            if(newString.charAt(i) != newString.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

//Method 2:
class Solution {
    public boolean isPalindrome(String s) {
        
        int i =0; int j = s.length()-1;
        s = s.toLowerCase();
        while(i<=j){
            char chlow = s.charAt(i);
            char chhigh = s.charAt(j);
            
            if(!isAlphaNum(chlow)) i++;
            else if(!isAlphaNum(chhigh)) j--;
            else if(chlow == chhigh){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public boolean isAlphaNum(char c){
        if((c >= 'a' && 
              c <= 'z') || 
              (c >= '0' && 
              c <= '9')) return true;
        return false;
    }
}
