// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

// Example 1:

// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer>[] bucket = new ArrayList[nums.length +1];
        
        for(int i =0; i< nums.length; i++){
           map.put(nums[i], map.getOrDefault(nums[i],0)+1); 
        }
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(bucket[entry.getValue()] == null) bucket[entry.getValue()] = new ArrayList<>();
            bucket[entry.getValue()].add(entry.getKey());                                         
        }
                   
        int count = 0; 
        int j =0;
        int[] result = new int[k];           
                   
        for(int i = bucket.length -1; i>0; i--){
            if(bucket[i] == null) continue;
            else{
                for(int element : bucket[i]){
                   if(count == k) break;
                   result[j++] = element; 
                   count++;
                }
            }
        }
         
        return result; 
    }
}


Solution 2: Using Queueu

    class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) +1);
        }

        PriorityQueue<Integer> minHeap  = new PriorityQueue<>(
            Comparator.comparingInt(freq::get)
        );

        for(int num : freq.keySet()){
            minHeap.offer(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] result = new int[k];

        for(int i = 0 ; i<k; i++){
            result[i] = minHeap.poll();
        }
        return result;
    }
}
