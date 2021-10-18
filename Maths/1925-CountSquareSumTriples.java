// A square triple (a,b,c) is a triple where a, b, and c are integers and a2 + b2 = c2.

// Given an integer n, return the number of square triples such that 1 <= a, b, c <= n.

// Input: n = 5
// Output: 2
// Explanation: The square triples are (3,4,5) and (4,3,5).

//Method 1:

class Solution {
    public int countTriples(int n) {
        Set<Integer> squareSet = new HashSet<>();
        int count =0;
        for(int i=1; i<=n; i++){
            squareSet.add(i*i);
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(squareSet.contains((i*i) + (j*j))) count++;
            }
        }
        return count;
    }
}

//Method 2:

class Solution {
    public int countTriples(int n) {
        
        int count =0;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int square = (i*i) + (j*j);
                int squareRoot = (int) Math.sqrt(square);
                if(squareRoot*squareRoot == square && squareRoot<=n) count++;
            }
        }
        return count;
    }
}
