// There is a malfunctioning keyboard where some letter keys do not work. All other keys on the keyboard work properly.

// Given a string text of words separated by a single space (no leading or trailing spaces) and a string brokenLetters of all distinct letter keys that are broken, return the number of words in text you can fully type using this keyboard.
  
// Example 1:

// Input: text = "hello world", brokenLetters = "ad"
// Output: 1
// Explanation: We cannot type "world" because the 'd' key is broken.
// Example 2:

// Input: text = "leet code", brokenLetters = "lt"
// Output: 1
// Explanation: We cannot type "leet" because the 'l' and 't' keys are broken.

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> brokenSet = new HashSet<>();
        boolean flag = true;
        int count =0;
        
        for(char brokenLetter : brokenLetters.toCharArray()){
            brokenSet.add(brokenLetter);
        }
        
        for(int j = 0; j<text.length(); j++ ){
            if(text.charAt(j)== ' '){
                if(flag){
                    count++;
                }
                else{
                    flag = true;
                }
            }
            if(brokenSet.contains(text.charAt(j))){
                flag = false;
            }
        }
        
        if(flag) count++;
        
        return count;
    }
}
