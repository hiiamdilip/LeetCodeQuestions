Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        Arrays.sort(nums);

        dfs(nums, 0, curr, ans);
        return ans;
    }

    public void dfs(int[] nums, int idx, List<Integer> curr, List<List<Integer>> ans){
        ans.add(new ArrayList<>(curr));

        for(int i = idx; i<nums.length; i++){
            if(i> idx && nums[i] == nums[i-1]) continue;

            curr.add(nums[i]);
            dfs(nums, i+1, curr, ans);
            curr.remove(curr.size() -1);
        }
    }
}
