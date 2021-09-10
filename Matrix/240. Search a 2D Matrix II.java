// Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
// Output: true
  
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int x = matrix.length -1;
        int y =0;
        
        while(x >= 0 && y < matrix[0].length){
           if(matrix[x][y] == target) return true; 
           if(matrix[x][y] > target) x--;
           else y++;
        }
        return false;
    }
}
