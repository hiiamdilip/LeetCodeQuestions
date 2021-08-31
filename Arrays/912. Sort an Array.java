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


class Solution {
    public List<Integer> sortArray(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i : nums){
            result.add(i);
        }
        mergeSort(result, 0, result.size()-1);
        return result;
    }
    public List<Integer> mergeSort(List<Integer> result, int low, int high){
       if(low < high){
           int mid = low + (high-low)/2;
           mergeSort(result, low, mid);
           mergeSort(result, mid+1, high);
           merge(result, low, mid, mid+1, high);   
       }
        return result;
    }
     public void merge(List<Integer> result, int low, int mid, int mid2, int high){
        List<Integer> temp = new ArrayList<>();
        int index1 = low;
        int index2 = mid2;
        while(index1 <= mid && index2 <= high){
           if(result.get(index1) < result.get(index2)) temp.add(result.get(index1++));
            else temp.add(result.get(index2++));
        }
        while(index1 <= mid) temp.add(result.get(index1++));
        while(index2 <= high) temp.add(result.get(index2++));
        for (int i = 0; i < temp.size(); i++) result.set(low++, temp.get(i));
    }
}
