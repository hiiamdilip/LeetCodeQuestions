// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

// Example 1:

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]
// Example 2:

// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
// Explanation: [4,9] is also accepted.

//Method 1:
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0;
        int j = 0;
        
        List<Integer> intersection = new ArrayList<Integer>();    
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j] && !intersection.contains(nums1[i])) {
                intersection.add(nums1[i]);
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }                
        }
        
        int[] result = new int[intersection.size()];
        int index = 0;
        for (int num : intersection) {
            result[index] = num;
            index++;
        }
        
        return result;
    }
}

//Method 2:

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = (length1 < length2) ? length1: length2;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        for(int i = 0; i< length1;i++){
            set1.add(nums1[i]);
        }
        for(int i = 0; i< length2;i++){
            set2.add(nums2[i]);
        }
        int k =0;
        
        Iterator iterator = set2.iterator();
        while(iterator.hasNext()){
            int a = (int)iterator.next();
            if(set1.contains(a)) set3.add(a); 
        }
        int[] result = new int[set3.size()];
        Iterator iterator2 = set3.iterator();
        while(iterator2.hasNext()){
            int d = (int)iterator2.next();
            result[k++] = d;
        }
        return result;
    }
}

// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

// Example 1:

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]
// Example 2:

// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [4,9]
// Explanation: [9,4] is also accepted.
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = nums1.length;
        int l2 = nums2.length;
        int l = (l1 > l2) ? l2 : l1 ; 
        int[] res = new int[l];
        int i=0,j=0,k = 0;
        while(i<l1 && j<l2){
            if(nums1[i] == nums2[j]){
                res[k] = nums1[i];
                i++;
                j++;
                k++;
            }
            else{
                if(nums1[i] < nums2[j]) i++;
                else j++;
            }
        }
        int[] result = new int[k];
        for(int m=0;m<k;m++){
            result[m] = res[m];
        }
        return result;
    }
}
