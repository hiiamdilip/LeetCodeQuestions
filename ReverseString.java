class Solution {
    public void reverseString(char[] s) {
        int i = s.length-1;
        int j = 0;
        while(j<i){
            char temp = s[j];
            s[j]=s[i];
            s[i]=temp;
            i--;
            j++;  
        }  
    }
}
