// Input: root = [2,1,3]
// Output: true

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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double smallest = - Double.MAX_VALUE;
        
        while(!stack.isEmpty() || root != null){
           if(root != null) {
              stack.push(root); 
              root = root.left;
           } else{
              root = stack.pop();
              if(root.val <= smallest) return false;
              smallest = root.val;
              root = root.right;
           }
        }
        return true;
    }
}

// Method 2
// do inorder traversal which should ideally give sorted array for BST, if array is not sorted then return false
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        while(!stack.isEmpty() || root != null){
           if(root != null) {
              stack.push(root); 
              root = root.left;
           } else{
              root = stack.pop();
              list.add(root.val);
              root = root.right;
           }
        }
        
        for(int i = 1; i< list.size(); i++){
            if(list.get(i-1) >= list.get(i)) return false;
        }
        return true;
    }
}
