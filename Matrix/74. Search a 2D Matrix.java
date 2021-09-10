// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix .length;
        int n = matrix[0].length;
        if(matrix == null || m == 0 || n == 0) return false;
        
        int low = 0;
        int high = m*n -1;
        
        while(low <=high){
            int mid = low + (high - low)/2;
            int x = mid/n;
            int y = mid%n;
            if(matrix[x][y] == target) return true;
            if(matrix[x][y] > target) high = mid -1;
            else low = mid +1;
        }
        return false;
    }
}
