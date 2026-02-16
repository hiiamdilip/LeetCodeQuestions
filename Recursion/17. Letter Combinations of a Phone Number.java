Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = "2"
Output: ["a","b","c"]


class Solution {
    String[] map = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        
        StringBuilder curr = new StringBuilder();

        comb(digits, 0, curr, ans);
        return ans;   
    }

    void comb(String digits, int idx, StringBuilder curr, List<String> ans){
        if(idx == digits.length()){
            ans.add(curr.toString());
            return;
        }

        int digit = digits.charAt(idx) - '0';
        String letters = map[digit];

        for(int i =0; i<letters.length(); i++){
            curr.append(letters.charAt(i));
            comb(digits, idx+1, curr, ans);
            curr.deleteCharAt(curr.length() -1);
        }
    }
}
