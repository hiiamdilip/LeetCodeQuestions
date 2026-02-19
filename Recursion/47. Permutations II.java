Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList();

        boolean[] used = new boolean[nums.length];

        Arrays.sort(nums);

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

            if(i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;

            used[i] = true;
            curr.add(nums[i]);
            backtrack(nums, used, curr, ans);
            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }
}
