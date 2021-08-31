// Given a string s, return the longest palindromic substring in s

// Input: s = "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.

class Solution {
    public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}

private int expandAroundCenter(String s, int left, int right) {
    if(s == null || left > right) return 0;
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
    }
    return right - left - 1;
}
}

//This is JavaBrains solution and i follow this approach;
class Solution {
    
    int resultStart;
    int resultLength;
    
    public String longestPalindrome(String s) {
        int strLength = s.length();
        
        if(strLength < 2)return s;
        
        for(int start = 0; start < strLength-1; start++){
            expandRange(s, start, start);
            expandRange(s, start, start+1);
        }  
        
        return s.substring(resultStart, resultStart + resultLength);  
    }
    
    public void expandRange(String s, int start, int end){
        while(start>=0 && end <s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        
        if(resultLength < end - start -1){
           resultStart = start +1;
           resultLength = end - start -1;
        }
    }
}
