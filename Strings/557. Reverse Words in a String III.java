// Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

// Example 1:

// Input: s = "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"
// Example 2:

// Input: s = "God Ding"
// Output: "doG gniD"
  
// Method 1:
class Solution {
    public String reverseWords(String s) {
        String words[] = s.split(" ");
        StringBuilder sbr = new StringBuilder();
        for(String word: words){
            StringBuffer sf = new StringBuffer(word);
            sbr.append(sf.reverse() + " ") ;
        }
        return sbr.toString().trim();
    }
}

// Method 2:
class Solution {
    public String reverseWords(String s) {
        final StringBuilder word = new StringBuilder();
        final StringBuilder result = new StringBuilder();
        for(int i =0; i< s.length(); i++){
            if(s.charAt(i) != ' '){
                word.append(s.charAt(i));
            }else {
               result.append(word.reverse()); 
               result.append(" ");
               word.setLength(0);
            }
        }
        result.append(word.reverse());
        return result.toString();
    }
}
