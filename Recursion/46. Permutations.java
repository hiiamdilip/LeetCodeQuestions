Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();

        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, new ArrayList(), ans);

        return ans;
    }

    public void backtrack(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> ans){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i =0; i<nums.length; i++){
            if(used[i]) continue;

            curr.add(nums[i]);
            used[i] = true;

            backtrack(nums, used, curr, ans);
            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }
}
