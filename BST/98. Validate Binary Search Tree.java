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
//Method 1:
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

//Method 3:
class Solution {
    public boolean isValidBST(TreeNode root) {
       return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean helper(TreeNode root, long lower, long higher){
        if(root == null) return true;
        
        return (root.val > lower 
                && root.val < higher) 
                && (helper(root.left, lower, root.val)) 
                && (helper(root.right, root.val, higher));
    }
}
