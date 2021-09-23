// Input: root = [1,2,3,null,5,null,4]
// Output: [1,3,4]
// Example 2:

// Input: root = [1,null,3]
// Output: [1,3]
// Example 3:

// Input: root = []
// Output: []

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
           if(root == null) return new ArrayList<>();
   
           Queue<TreeNode> queue1 = new LinkedList();
           Queue<TreeNode> queue2 = new LinkedList();

           List<Integer> result = new ArrayList<>();
           boolean isLast = false;

           queue1.add(root);

           while(!queue1.isEmpty() || !queue2.isEmpty()){
                while(!queue2.isEmpty()){
                    if(queue2.size() == 1) isLast = true;
                    TreeNode element = queue2.poll();
                    if(isLast) {
                        result.add(element.val);
                        isLast = false;
                    }
                    if(element.left != null)queue1.add(element.left);
                    if(element.right != null)queue1.add(element.right);
                } 
                while(!queue1.isEmpty()){
                    if(queue1.size() == 1) isLast = true;
                    TreeNode element = queue1.poll();
                    if(isLast) {
                        result.add(element.val);
                        isLast = false;
                    }
                    if(element.left != null)queue2.add(element.left);
                    if(element.right != null)queue2.add(element.right);
                }
           }

           return result;
    }
}
