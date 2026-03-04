Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

 

Example 1:


Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
Example 2:

Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        List<Integer> sum = new ArrayList();

        dfs(root, 0, sum);

        int bestSum = Integer.MIN_VALUE;
        int bestDepth = 0;

        for(int i =0; i<sum.size(); i++){
            int currentSum = sum.get(i);

            if(currentSum > bestSum){
                bestSum = currentSum;
                bestDepth = i;
            }
        }
        return bestDepth +1;
    }

    private void dfs(TreeNode root, int depth, List<Integer> sum){
        if(root == null) return;

        if(depth >= sum.size()){
            sum.add(0);
        }

        sum.set(depth, sum.get(depth) + root.val);

        dfs(root.left, depth +1, sum);
        dfs(root.right, depth +1, sum);
    }
}
