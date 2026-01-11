Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        Map<Integer, Integer> map2 = new HashMap();
        List<Integer> list = new ArrayList();

        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) +1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getValue();
            if(map2.containsKey(num))
                return false;
            else map2.put(num,1);
        }

        return true;
    }
}
