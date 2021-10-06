// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// Example 1:

// Input: s = "anagram", t = "nagaram"
// Output: true
// Example 2:

// Input: s = "rat", t = "car"
// Output: false

class Solution {
    public boolean isAnagram(String s, String t) {
       if(s.length() != t.length()) return false;
       char[] str1 = s.toCharArray();
       char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        //return str1.equals(str2);
        return Arrays.equals(str1,str2);
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
        counter[s.charAt(i) - 'a']++;
        counter[t.charAt(i) - 'a']--;
    }
    for (int count : counter) {
        if (count != 0) {
            return false;
        }
    }
    return true;
}
}

class Solution {
    public boolean isAnagram(String s, String t) {
        List<Character> list = new ArrayList<>();
        
        for(char c : s.toCharArray()){
            list.add(c);
        }
        
        for(char c : t.toCharArray()){
            if(list.contains(c))
                list.remove(list.indexOf(c));
            else return false;
        }
        
        return (list.size() == 0);
    }
}
