// Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

// Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
  
// Input: s = "abccccdd"
// Output: 7
// Explanation:
// One longest palindrome that can be built is "dccaccd", whose length is 7.
  
// Input: s = "a"
// Output: 1
  
//Method 1

class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        int i =0;
        int result =0;
        Map<Character, Integer> map = new HashMap<>();
        while(i<n){
            if(map.containsKey(s.charAt(i))) map.put(s.charAt(i), map.get(s.charAt(i))+1);
            else map.put(s.charAt(i), 1);
            i++;
        }
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            result = result + (entry.getValue()/2)*2;
             if(result % 2 == 0 && entry.getValue() % 2 ==1) result += 1;
        }
        return result;
    }
}

//Method 2

class Solution {
    public int longestPalindrome(String s) {
        int[] charCounts = new int[128];
        for(char c : s.toCharArray()){
            charCounts[c]++;
        }
        int result = 0;
        for(int charCount: charCounts){
            result = result + (charCount/2)*2;
            if(result % 2 == 0 && charCount % 2 ==1) result += 1;
        }
        return result;
    }
}
