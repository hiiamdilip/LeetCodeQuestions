// Example
// w=abcd
// The next largest word is abdc

// Complete the function biggerIsGreater below to create and return the new string meeting the criteria. If it is not possible, return no answer.
  
//Psudo Code
// Condensed mathematical description:

// Find largest index i such that array[i − 1] < array[i].
// (If no such i exists, then this is already the last permutation.)

// Find largest index j such that j ≥ i and array[j] > array[i − 1].

// Swap array[j] and array[i − 1].

// Reverse the suffix starting at array[i].
  
// Annotated code (Java)
// boolean nextPermutation(int[] array) {
//     // Find longest non-increasing suffix
//     int i = array.length - 1;
//     while (i > 0 && array[i - 1] >= array[i])
//         i--;
//     // Now i is the head index of the suffix
    
//     // Are we at the last permutation already?
//     if (i <= 0)
//         return false;
    
//     // Let array[i - 1] be the pivot
//     // Find rightmost element greater than the pivot
//     int j = array.length - 1;
//     while (array[j] <= array[i - 1])
//         j--;
//     // Now the value array[j] will become the new pivot
//     // Assertion: j >= i
    
//     // Swap the pivot with j
//     int temp = array[i - 1];
//     array[i - 1] = array[j];
//     array[j] = temp;
    
//     // Reverse the suffix
//     j = array.length - 1;
//     while (i < j) {
//         temp = array[i];
//         array[i] = array[j];
//         array[j] = temp;
//         i++;
//         j--;
//     }
    
//     // Successfully computed the next permutation
//     return true;
// }



public class Main
{
	public static void main(String[] args) {
		String s = "dkhc";
		System.out.println(biggerIsGreater(s));
	}
	
	public static String biggerIsGreater(String s){
	    int i = s.length() -1;
	    while(i>0 && s.charAt(i-1) >= s.charAt(i)){
	        i--;
	    }
	    
	    if(i<=0){
	        return "No answer";
	    }
	    
	    int j = s.length() -1;
	    while(s.charAt(j) <= s.charAt(i-1)){
	        j--;
	    }
	    
	    char temp = s.charAt(i-1);
	    s = s.substring(0, i-1) + s.charAt(j) + s.substring(i);
	    s= s.substring(0, j) + temp + s.substring(j+1);
              
	    
	    j = s.length() -1;
	    while(i<j){
	       temp =  s.charAt(i);
	       s = s.substring(0, i) + s.charAt(j) + s.substring(i+1);
	       s = s.substring(0, j) + temp + s.substring(j+1);
	      
	       i++;
	       j--;
	    }
	    
	    return s;
	    
	}
}
