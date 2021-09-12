// Input: root = [1,null,2,2]
// Output: [2]

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
    public int[] findMode(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
            
        while(!stack.isEmpty() || root != null){
           if(root != null) {
               stack.push(root);
               root = root.left; 
           }else{
               root = stack.pop();
               list.add(root.val);
               root = root.right;
           }
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int element: list){
            map.put(element, map.getOrDefault(element, 0)+1);
        }
        
        ArrayList<Integer>[] bucket = new ArrayList[list.size() +1];
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
           if(bucket[entry.getValue()] ==  null) bucket[entry.getValue()] = new ArrayList<>();
           bucket[entry.getValue()].add(entry.getKey());                                       
        }
        
        ArrayList<Integer> tempList = new ArrayList<>();                                       
        for(int i = bucket.length -1 ; i>=0; i--){
            if(bucket[i] == null) continue;
            else{
               tempList.addAll(bucket[i]); 
                break;
            }
        } 
                                                        
        int[] result = new int[tempList.size()];
        int i =0;
        for(int element : tempList) result[i++] = element;
        return result;
    }
}
