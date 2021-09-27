// Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
// Output: true
// Example 2:

// Input: root1 = [1], root2 = [1]
// Output: true
// Example 3:

// Input: root1 = [1], root2 = [2]
// Output: false
// Example 4:

// Input: root1 = [1,2], root2 = [2,2]
// Output: true
// Example 5:


// Input: root1 = [1,2,3], root2 = [1,3,2]
// Output: false

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        getLeaves(root1, list1);
        getLeaves(root2, list2);
        
        return list1.equals(list2);
    }
    
    public List<Integer> getLeaves(TreeNode node, List<Integer> result){
        
        if(node != null){
           if(node.left == null && node.right == null) result.add(node.val);
           if(node.left != null) getLeaves(node.left, result);
           if(node.right != null) getLeaves(node.right,result); 
        }
        
        return result;
    }
}
