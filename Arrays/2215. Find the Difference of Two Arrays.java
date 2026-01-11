Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.

 

Example 1:

Input: nums1 = [1,2,3], nums2 = [2,4,6]
Output: [[1,3],[4,6]]
Explanation:
For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums1. Therefore, answer[1] = [4,6].
Example 2:

Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
Output: [[3],[]]
Explanation:
For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
Every integer in nums2 is present in nums1. Therefore, answer[1] = [].

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> set1 = new ArrayList();
        List<Integer> set2 = new ArrayList();

        Set<Integer> tempSet1 = new HashSet();
        Set<Integer> tempSet2 = new HashSet();
        
        for(int num : nums1){
            tempSet1.add(num);
        }

        for(int num : nums2){
            tempSet2.add(num);
        }

        for(int num : tempSet1){
            if(!tempSet2.contains(num))
               set1.add(num) ;
        }

        for(int num : tempSet2){
            if(!tempSet1.contains(num))
               set2.add(num);
        }

        List<List<Integer>> result = new ArrayList();
        result.add(set1);
        result.add(set2);

        return result;
    }
}
