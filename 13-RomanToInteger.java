class Solution {
    public int romanToInt(String s) {
        int n = s.length() -1;
        int totalValue = find(s.charAt(n));
        for(int i =n; i> 0; i--){
            int nextChar = find(s.charAt(i));
            int prevChar = find(s.charAt(i-1));
            if(nextChar > prevChar){
                totalValue = totalValue - prevChar;
            }else{
               totalValue = totalValue + prevChar; 
            }
        }
        return totalValue;
        
    }
    
    public int find(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
