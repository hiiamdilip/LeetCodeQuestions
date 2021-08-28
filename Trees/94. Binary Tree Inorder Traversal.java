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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    
    public void helper(TreeNode root, List<Integer> result){
        if(root != null){
            if(root.left != null) helper(root.left,result);
            result.add(root.val); 
            if(root.right != null) helper(root.right,result);
        }
    }
}


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if( root == null) return list;
        
        Stack<TreeNode> s = new Stack<>();
        while(!s.isEmpty() || root != null){
            if(root != null){
                s.add(root);
                root = root.left;
            }else{
                root = s.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}
