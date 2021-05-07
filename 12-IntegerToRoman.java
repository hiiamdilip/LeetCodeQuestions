class Solution {
    public String intToRoman(int num) {
       int arr[] = {1000,900,500,400,100,90,50,40,10,9,8,7,6,5,4,3,2,1}; 
        StringBuilder sb = new StringBuilder();
        for(int i =0; i< arr.length; i++){
            if(arr[i] > num) continue;
            else{
               num = num - arr[i];
               sb.append(getString(arr[i]));
                i--;
            }
        }
        return sb.toString();
    }
    
    public String getString(int num){
        switch(num){
            case 1: return "I";
            case 2: return "II";
            case 3: return "III";
            case 4: return "IV";
            case 5: return "V";
            case 6: return "VI";
            case 7: return "VII";
            case 8: return "VIII";
            case 9: return "IX";
            case 10: return "X";
            case 40: return "XL";
            case 50: return "L";
            case 90: return "XC";
            case 100: return "C";
            case 400: return "CD";
            case 500: return "D";
            case 900: return "CM";
            case 1000: return "M";
            default: return "";
        }
    }
}
