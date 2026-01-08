Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.

class Solution {
    public int maxVowels(String s, int k) {
        int i =0;
        int count = 0;
        int result = 0;
        for(int j =0; j<s.length(); j++){
            if(isVowel(s.charAt(j))){
                count++;
            }
            if(j-i+1 == k){
                result = Math.max(count, result);
                if(isVowel(s.charAt(i))) count--;
                i++;
            }
        }
        return result;
    }
    boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
