Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

Brute Force Approach:

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> finalResultList = new HashSet();
        for(int i =0; i<nums.length; i++){
            for(int j =i+1; j<nums.length; j++){
                for(int k =j+1; k<nums.length; k++){
                    if((i != j) && (i != k) && (j !=k) && (nums[i] + nums[j] + nums[k] == 0)){
                        List<Integer> result = new ArrayList();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[k]);
                        Collections.sort(result);
                        finalResultList.add(result);
                    }
                }
            }
        }
        return new ArrayList<>(finalResultList);
    }
}

Optimized solution

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        for(int i =0; i<nums.length - 2; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int left = i+1;
            int right = nums.length -1;
            int target = -1 * nums[i];
            while(left < right){
                int currentSum = nums[left] + nums[right];
                if(target == currentSum){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                } else if(target < currentSum){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return result;
    }
}

Optimized easy version to remove dulplicates

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet();
        Arrays.sort(nums);
        for(int i =0; i<nums.length - 2; i++){
            int left = i+1;
            int right = nums.length -1;
            int target = -1 * nums[i];
            while(left < right){
                int currentSum = nums[left] + nums[right];
                if(target == currentSum){
                    List<Integer> list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    left++;
                    right--;
                } else if(target < currentSum){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
