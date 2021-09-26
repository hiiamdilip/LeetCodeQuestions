import java.util.*;

public class Main
{
	public static void main(String[] args) {
		int[][] array = {
		    {10,12},{11,14},{10,11}
		};
		int count = minMeetingRooms(array);
		System.out.println(count);
	}
	
	public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));
     
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int count = 0;
        for (int[] itv : intervals) {
            if (heap.isEmpty()) {
                count++;
                heap.offer(itv[1]);
            } else {
                if (itv[0] >= heap.peek()) {
                    heap.poll();
                } else {
                    count++;
                }
     
                heap.offer(itv[1]);
            }
        }
     
        return count;
    }
}
