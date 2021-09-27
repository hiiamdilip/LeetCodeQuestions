// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// Example 1:

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:

// Input: n = 1
// Output: ["()"]

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    public void backtrack(List<String> result, String curr, int open, int close, int max){
        if(curr.length() == 2 * max){
            result.add(curr);
            return;
        }
        
        if(open < max) backtrack(result, curr+'(', open+1, close, max);
        if(close < open) backtrack(result, curr+')', open, close+1, max);
    }
}
