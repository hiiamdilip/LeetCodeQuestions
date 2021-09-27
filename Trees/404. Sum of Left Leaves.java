// Input: root = [3,9,20,null,null,15,7]
// Output: 24
// Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
// Example 2:

// Input: root = [1]
// Output: 0

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int sum =0;
        
        helper(root,list);
        
        for(int element: list) sum += element;
        
        return sum;
    }
    
    public void helper(TreeNode root, List<Integer> result){
        if(root != null){
            if(root.left != null) {
               helper(root.left, result);
               if(root.left.left == null && root.left.right == null) result.add(root.left.val);
            }
            if(root.right != null) helper(root.right, result);
        }
    }
}
