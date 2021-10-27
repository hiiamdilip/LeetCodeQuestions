/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
	public static void main(String[] args) {
		int[] inputArray = new int[] {1 , 2 , 3 , 4 , 5 , 5};
		
		int result = getSplitPoint(inputArray);
		
		for(int i = 0 ; i< inputArray.length ; i++){
		    if(result == i) System.out.println();
		    System.out.print(inputArray[i] + " ");
		}
	}
	
	public static int getSplitPoint(int[] array){
	    int leftSum = 0;
	    
	    for(int element : array){
	        leftSum += element;
	    }
	    
	    int rightSum =0;
	    for(int i = array.length -1 ; i>= 0; i--){
	        rightSum += array[i];
	        leftSum -= array[i];
	        
	        if(rightSum == leftSum) return i;
	    }
	    
	    return -1;
	}
}
