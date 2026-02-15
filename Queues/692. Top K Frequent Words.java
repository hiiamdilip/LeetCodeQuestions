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
        
       ArrayList<String> result = new ArrayList<>();
        int count = 0;

        for(int i = bucket.length-1; i>=0; i--){
            if(bucket[i] == null) continue;
            else{
                Collections.sort(bucket[i]);
                for(String word : bucket[i]){
                    if(count == k) break;
                    result.add(word);
                    count++;
                }
            }
        }

        return result;
    }
}

Solution 2 : Using Priority Queue

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();

        for(String s : words){
            freq.put(s, freq.getOrDefault(s, 0) +1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>(
            (a,b) -> {
                int fa = freq.get(a);
                int fb = freq.get(b);

                if(fa != fb) return fa -fb;
                return b.compareTo(a);
            }
        );

        for(String w : freq.keySet()){
            minHeap.offer(w);
            if(minHeap.size() > k) minHeap.poll();
        }

        List<String> result = new ArrayList();

        for(int i =0; i<k; i++){
            result.add(minHeap.poll());
        }

        Collections.reverse(result);

        return result;
    }
}
