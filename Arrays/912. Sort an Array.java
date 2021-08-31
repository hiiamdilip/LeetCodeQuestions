class Solution {
    public int[] sortArray(int[] nums) {
        int[] list = new int[nums.length];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int num : nums) {
            q.add(num);
        }
        
        for (int i = 0; i < nums.length; i++) {
            list[i] = q.poll();
        }
        
        return list;
    }
}
