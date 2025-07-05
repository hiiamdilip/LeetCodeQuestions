// Example 1:

// Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
// Output: [-1,3,-1]
// Explanation: The next greater element for each value of nums1 is as follows:
// - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
// - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
// - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
// Example 2:

// Input: nums1 = [2,4], nums2 = [1,2,3,4]
// Output: [3,-1]
// Explanation: The next greater element for each value of nums1 is as follows:
// - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
// - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        
        Stack<Integer> stack = new Stack();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i =nums2.length-1; i>=0; i--){
            while(!stack.isEmpty() && (stack.peek() <= nums2[i])){
                stack.pop();
            }
            
            if(stack.isEmpty()) map.put(nums2[i],-1);
            else map.put(nums2[i],stack.peek());
            
            stack.push(nums2[i]);
        }
        
        
        
        for(int i =0; i< nums1.length; i++){
           if(map.containsKey(nums1[i])) result[i] = map.get(nums1[i]);
           else result[i] = -1;
        }
        
        return result;
    }
}
