public class Main
{
	public static void main(String[] args) {
		int a[] = { 1, 3, 1, 4, 5, 6, 7, 8, 9, 8, 17, 6, 15 };
                 
        System.out.println(LongestMountain(a));
	}
	
	public static int LongestMountain(int a[])
    {
        int start = -1;
        int end = -1;
        int result = 0;
     
        if (a.length < 3)
            return 0;
     
        for(int i = 0; i < a.length - 1; i++)
        {
            if (a[i + 1] > a[i])
            {
                 
                // When a new mountain sub-array is
                // found, there is a need to set the
                // variables k, j to -1 in order to
                // help calculate the length of new
                // mountain sub-array
                if (end != -1)
                {
                    end = -1;
                    start = -1;
                }
     
                // j marks the starting index of a
                // new mountain sub-array. So set the
                // value of j to current index i.
                if (start == -1)
                    start = i;
            }
            else
            {
                 
                // Checks if next element is
                // less than current element
                if (a[i + 1] < a[i])
                {
                     
                    // Checks if starting element exists
                    // or not, if the starting element of
                    // the mountain sub-array exists then
                    // the index of ending element is
                    // stored in k
                    if (start != -1)
                        end = i + 1;
     
                    // This condition checks if both
                    // starting index and ending index
                    // exists or not, if yes,the length
                    // is calculated.
                    if (end != -1 && start != -1)
                    {
     
                        // d holds the length of the
                        // longest mountain sub-array.
                        // If the current length is
                        // greater than the calculated
                        // length, then value of d is
                        // updated.
                        if (result < end - start + 1)
                            result = end - start + 1;
                    }
                }
                 
                // Ignore if there is no increase
                // or decrease in the value of the
                // next element
                else
                {
                    end = -1;
                    start = -1;
                }
            }
        }
     
        // Checks and calculates the length
        // if last element of the array is
        // the last element of a mountain sub-array
        if (end != -1 && start != -1)
        {
            if (result < end - start + 1)
                result = end - start + 1;
        }
        return result;
    }
}
