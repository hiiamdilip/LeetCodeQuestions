Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

Example 1:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
Example 2:

Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList();
        if(root == null) return result;

        List<Integer> path = new ArrayList();

        dfs(root, targetSum, path, result);
        return result; 
    }

    public void dfs(TreeNode root, int remaining, List<Integer> path, List<List<Integer>> result){
        if(root == null) return;

        path.add(root.val);
        remaining -= root.val;

        if(root.left == null && root.right == null){
            if(remaining == 0){
                result.add(new ArrayList<>(path));
            }
        } else{
            dfs(root.left, remaining, path, result);
            dfs(root.right, remaining, path, result);
        }

        path.remove(path.size() - 1);
    }
}
