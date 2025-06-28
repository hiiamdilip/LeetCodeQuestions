Given a sorted array, find the sumber of pairs which has sum = k

Example 1: nums = [1, 2, 3, 4], k = 5
Output = 2

Example 2: nums = [1, 1, 1, 1], k = 2
Output = 3

Example 3: nums = [1, 2, 3], k = 12
Output = 0

Example 4: nums = [1,4,4,5,5,5,6,6,11], k =11
Output = 6

public class Main
{
	public static void main(String[] args) {
		int nums[] = new int[]{1, 2, 3};
		int target = 12;
		int count = 0;
		int left = 0;
		int right = nums.length -1;
		while(left < right){
		    int sum = nums[left] + nums[right];
		    if(sum == target){
		        int leftCount = 1;
		        int rightCount = 1;
		        while(left+1 < right && nums[left] == nums[left+1]){
		            left++;
		            leftCount++;
		        }
		        while(left < right-1 && nums[right] == nums[right-1]){
		            right--;
		            rightCount++;
		        }
		        count = count + leftCount*rightCount;
		    }
		    if(sum < target){
		        left++;
		    } else {
		        right--;
		    }
		}
		System.out.println(count);
	}
}
