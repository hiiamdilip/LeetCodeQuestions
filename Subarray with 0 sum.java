class ZeroSumSubarray
{
    static Boolean subArrayExists(int arr[])
    {
        Set<Integer> hs = new HashSet<Integer>();
        int sum = 0;
 
        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
 
            // Return true in following cases
            // a) Current element is 0
            // b) sum of elements from 0 to i is 0
            // c) sum is already present in hash map
            if (arr[i] == 0
                || sum == 0
                || hs.contains(sum))
                return true;
            hs.add(sum);
        }
        return false;
    }
  
  
  
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		int[] inputArray = new int[] { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
		zeroSum(inputArray);
	}
	
	public static void zeroSum(int[] array){
	    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
	    ArrayList<Pair> result = new ArrayList<>();
	    int sum =0;
	    int count = 0;
	    
	    for(int i =0; i<array.length;i++){
	       sum = sum +array[i];
	       
	       if(sum == 0) result.add(new Pair(0,i));
	       
	       ArrayList<Integer> al = new ArrayList<>();
	       
	       if(map.containsKey(sum)){
	          al = map.get(sum); 
	          for(int j =0; j<al.size() ;j++){
	              result.add(new Pair(al.get(j) +1,i));
	          }
	       }
	       al.add(i);
	       map.put(sum,al);
	    }
	    for(Pair p : result){
	        count = Math.max(count, p.second - p.first +1);
	        System.out.print(p.first);
	        System.out.print(",");
	        System.out.println(p.second);
	    }
	    System.out.println(count);
	}
}

class Pair{
   int first;
   int second;
   Pair(int a, int b){
       first = a;
       second = b;
   }
}
