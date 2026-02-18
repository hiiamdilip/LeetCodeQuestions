Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.
 
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList();

        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList(), ans);
        return ans;
    }

    public void backtrack(int[] candidates, int target, int idx, List<Integer> curr, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = idx; i<candidates.length;i++){
            if(i>idx && candidates[i] == candidates[i-1]) continue;
            
            int val = candidates[i];
            if(val >target) break;

            curr.add(val);
            backtrack(candidates, target - val, i+1, curr, ans);
            curr.remove(curr.size()-1);
        }
    }
}
