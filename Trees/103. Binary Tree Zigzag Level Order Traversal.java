// Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[20,9],[15,7]]
// Example 2:

// Input: root = [1]
// Output: [[1]]
// Example 3:

// Input: root = []
// Output: []

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;
        
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        s1.add(root);
        
        while(!s1.isEmpty() || !s2.isEmpty()){
           List<Integer> list1 = new ArrayList<>();
           while(!s1.isEmpty()){
              root = s1.pop();
              list1.add(root.val);
              if(root.left != null) s2.push(root.left);
              if(root.right != null) s2.push(root.right);
           } 
           if(!list1.isEmpty()) result.add(list1);
        
           List<Integer> list2 = new ArrayList<>();
           while(!s2.isEmpty()){
              root = s2.pop();
              list2.add(root.val);
              if(root.right != null) s1.push(root.right);
              if(root.left != null)  s1.push(root.left); 
           }
           if(!list2.isEmpty()) result.add(list2);
        }
        return result;
    }
}
