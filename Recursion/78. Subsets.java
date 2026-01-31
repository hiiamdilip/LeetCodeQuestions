Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        dfs(nums, 0, curr, ans);

        return ans;
    }

    public void dfs(int[] nums, int idx, List<Integer> curr, List<List<Integer>> ans){
        if(nums.length == idx){
            ans.add(new ArrayList<>(curr));
            return;
        }

        dfs(nums, idx+1, curr, ans);

        curr.add(nums[idx]);
        dfs(nums, idx+1, curr, ans);
        curr.remove(curr.size() -1);
    }
}
