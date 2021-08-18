// Given a string s, sort it in decreasing order based on the frequency of characters, and return the sorted string.

// Example 1:

// Input: s = "tree"
// Output: "eert"
// Explanation: 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
// Example 2:

// Input: s = "cccaaa"
// Output: "aaaccc"
// Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
// Note that "cacaca" is incorrect, as the same characters must be together.
// Example 3:

// Input: s = "Aabb"
// Output: "bbAa"
// Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
// Note that 'A' and 'a' are treated as two different characters.

class Solution {
    public String frequencySort(String s) {
        
       Map<Character, Integer> map = new HashMap<>();
       for(int i =0; i< s.length();i++){
           map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
       }
        
       ArrayList<Character>[] bucket = new ArrayList[s.length()+1];
       for(Map.Entry<Character, Integer> entry : map.entrySet()){
           if(bucket[entry.getValue()] == null) bucket[entry.getValue()] = new ArrayList<>();
           bucket[entry.getValue()].add(entry.getKey());
       }
        
       StringBuilder sbr = new StringBuilder();
       for(int i =bucket.length-1; i> 0; i--){
          if(bucket[i] == null) continue;
          else{
              for(char c : bucket[i]){
                 int j =0;
                 while(j<i){
                   sbr.append(c);
                   j++;
                 } 
              } 
          }
       }
        return sbr.toString();
    }
}
