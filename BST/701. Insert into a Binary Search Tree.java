// Input: root = [4,2,7,1,3], val = 5
// Output: [4,2,7,1,3,5]

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        TreeNode result = new TreeNode(val);
        if(root == null) return result;
        TreeNode parent = null;
        TreeNode current = root;
        
        while(current != null){
            parent = current;
            if(val < current.val) current = current.left;
            else current = current.right;
        }  
        
        if(parent.val < val) parent.right = result;
        else parent.left = result;
        return root;
    }
}
