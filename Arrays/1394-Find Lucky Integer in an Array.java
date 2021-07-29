// Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.

// Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1.

// Example 1:

// Input: arr = [2,2,3,4]
// Output: 2
// Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
  
// Method 1:class Solution {
    public int findLucky(int[] arr) {
        int luckyNumber = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }
            else{
                map.put(arr[i],1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getKey() == entry.getValue()){
                luckyNumber = entry.getKey()>luckyNumber?entry.getKey():luckyNumber;
            }
        }
        return luckyNumber;
    }
}

// Method 2:

class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[500];
        for(int i =0; i< arr .length; i++){
            freq[arr[i]]++;
        }
        for(int i = freq.length-1; i>0; i--){
            if(freq[i] == i) return freq[i];
        }
        return -1;  
    }
}
