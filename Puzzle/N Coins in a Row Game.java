// You are given an array A of size N. The array contains integers and is of even length. The elements of the array represent N coin of values V1, V2, ....Vn. You play against an opponent in an alternating way.

// In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin.

// You need to determine the maximum possible amount of money you can win if you go first.
// Note: Both the players are playing optimally.

// Example 1:

// Input:
// N = 4
// A[] = {5,3,7,10}
// Output: 15
// Explanation: The user collects maximum
// value as 15(10 + 5)
// Example 2:

// Input:
// N = 4
// A[] = {8,15,3,7}
// Output: 22
// Explanation: The user collects maximum
// value as 22(7 + 15)
  
class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int arr[], int n)
    {
        return helper(arr, 0, n-1);
    }
    
    public static int helper(int[]arr, int l , int r){
        
        if(l>=r) return 0;
        
        Map<String, Integer> m = new HashMap<>();
        
        String key = l + "|" + r;
        Integer solution = m.get(key);
        if(solution != null){
            return solution;
        }
        
        int a = arr[l] + Math.min(helper(arr, l+2, r), helper(arr, l+1, r-1));
        
        int b = arr[r] + Math.min(helper(arr, l+1, r-1), helper(arr, l, r-2));
        
        int profit = Math.max(a,b);
        m.put(key, profit);
        
        return profit;
    }
}
