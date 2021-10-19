import java.util.*;
public class Main
{
	public static void main(String[] args) {
		String inputString = "aabbbbcccdaaa";
		System.out.println(getResult(inputString));
	}
	
	public static String getResult(String s){
	    int count = 1;
	    StringBuilder sbr = new StringBuilder();
	    char c= s.charAt(0);
	    for(int i =1; i<s.length(); i++){
	        if(s.charAt(i) == c) count++;
	        else{
	            sbr.append(c);
	            sbr.append(count);
	            c = s.charAt(i);
	            count =1;
	        }
	    }
	     sbr.append(c);
	     sbr.append(count);

	    return sbr.toString();
	}
}


import java.util.*;
public class Main
{
	public static void main(String[] args) {
		String inputString = "baabbbbcccdaaab";
		System.out.println(getResult(inputString));
	}
	
	public static String getResult(String s){
	    Map<Character, Integer> map = new HashMap<>();
	    for(char c : s.toCharArray()){
	        if(map.containsKey(c)){
	            map.put(c, map.get(c)+1);
	        }else{
	            map.put(c,1);
	        }
	    }
	    
	    StringBuilder sbr = new StringBuilder();
	    for(Map.Entry<Character, Integer> entry : map.entrySet()){
	        sbr.append(entry.getKey());
	        sbr.append(entry.getValue());
	    }
	    
	    return sbr.toString();
	}
}
