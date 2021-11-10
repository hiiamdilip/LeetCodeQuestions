public class Main
{
	public static void main(String[] args) {
		int[] inputArray = new int[] {1, 4, 2, 10, 23, 3, 1, 0, 20};
		System.out.println(maxSum(inputArray,4));
	}
	
	public static int maxSum(int[] array, int k){
	    int winSum =0;
	    int result=0;
	    
	    for(int i =0; i<k; i++) winSum += array[i];
	    
	    for(int i=k; i<array.length; i++){
	        winSum = winSum + array[i] - array[i-k];
	        result = Math.max(result,winSum);
	    }
	    
	    return result;
	}
}
