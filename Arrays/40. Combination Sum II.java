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
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList();
        backTrack(0,0,new ArrayList(), candidates, target, result);
        return result; 
    }
    private void backTrack(int start, int currSum, List<Integer> currCombination, int[] candidates, int target, List<List<Integer>> result){
        if(currSum ==target){
            result.add(new ArrayList<>(currCombination));
            return;
        }
        if(currSum > target){
            return;
        }
        for(int i = start; i<candidates.length; i++){
            if(i > start && candidates[i] == candidates[i-1]){
                continue;
            }
            int num = candidates[i];
            if(currSum + num <= target){
                currCombination.add(num);
                backTrack(i+1, currSum + num, currCombination, candidates, target, result);
                currCombination.remove(currCombination.size() -1);
            }
            else{
                break;
            }
        }
    }
}
