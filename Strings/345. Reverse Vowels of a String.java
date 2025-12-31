Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

Example 1:

Input: s = "IceCreAm"

Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:

Input: s = "leetcode"

Output: "leotcede"

class Solution {
    public String reverseVowels(String s) {
        char[] words = s.toCharArray();
        int i = 0;
        int j = s.length() -1;
        String vowels = "aeiouAEIOU";
        while(i < j){
            while((i < j) && vowels.indexOf(words[i]) == -1) i++;
            while((i < j) && vowels.indexOf(words[j]) == -1) j--;
            
            char temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;
            j--;
            
        }
        return new String(words);
    }
}
