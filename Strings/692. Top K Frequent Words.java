// Given an array of strings words and an integer k, return the k most frequent strings.

// Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

// Example 1:

// Input: words = ["i","love","leetcode","i","love","coding"], k = 2
// Output: ["i","love"]
// Explanation: "i" and "love" are the two most frequent words.
// Note that "i" comes before "love" due to a lower alphabetical order.
// Example 2:

// Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
// Output: ["the","is","sunny","day"]
// Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
       Map<String, Integer> map = new HashMap<>();
      
       for(String s : words){
           map.put(s, map.getOrDefault(s,0)+1);
       }
        
       ArrayList<String>[] bucket = new ArrayList[words.length + 1];
        
       for(Map.Entry<String, Integer> entry : map.entrySet()){
          if(bucket[entry.getValue()] == null) bucket[entry.getValue()] = new ArrayList<>();
          bucket[entry.getValue()].add(entry.getKey());
       }
        
       List<String> list = new ArrayList<>(); 
        
       for(int i = bucket.length -1 ; i> 0; i--){
          if(bucket[i] == null) continue;
          if(list.size() == k) break;
          else{
              Collections.sort(bucket[i]);
              for(String element : bucket[i]){
                  if(list.size() == k) break;
                  list.add(element);
              }
          }
       }
        
        return list;
    }
}
