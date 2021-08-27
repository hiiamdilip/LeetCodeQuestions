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
    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> result = new ArrayList<>();
       helper(root, result, 0);
       return result;
    }
    
    public void helper(TreeNode root, List<List<Integer>> result, int level){
        if( root == null) return;
        if(result.size() <= level) result.add(new ArrayList<Integer>());
        result.get(level).add(root.val);
        helper(root.left, result, level+1);
        helper(root.right, result, level+1);
    }
}
