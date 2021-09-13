public class Main
{
	public static void main(String[] args) {
		String s ="god";
		helper(s, "");
	}
	
	public static void helper(String s, String answer){
	    if(s.length() == 0 ){
	        System.out.println(answer + " ");
	        return;
	    }
	    
	    boolean[] array = new boolean[26];
	    for(int i =0; i< s.length(); i++){
	        char ch = s.charAt(i);
	        
	        String ros = s.substring(0,i) + s.substring(i + 1);
	        
	        if(array[ch -'a'] == false) helper(ros, answer+ch);
	        array[ch -'a'] = true;
	        
	    }
	}
}
