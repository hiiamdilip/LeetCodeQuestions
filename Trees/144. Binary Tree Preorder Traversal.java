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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    
    public void helper(TreeNode root, List<Integer> result){
        if(root != null){
           result.add(root.val); 
           helper(root.left, result);
           helper(root.right, result);
        }
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> s = new Stack<>();
        s.add(root);
        while( !s.isEmpty()){
           root = s.pop();
           list.add(root.val);
           if(root.right != null) s.add(root.right);
           if(root.left != null) s.add(root.left);
        }
        return list;
    }
}
