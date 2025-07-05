// Given an array of integers, find the nearest smaller number for every element such that the smaller element is on left side.

// Examples: 

// Input:  arr[] = {1, 6, 4, 10, 2, 5}
// Output:         {_, 1, 1,  4, 1, 2}
// First element ('1') has no element on left side. For 6, 
// there is only one smaller element on left side '1'. 
// For 10, there are three smaller elements on left side (1,
// 6 and 4), nearest among the three elements is 4.

// Input: arr[] = {1, 3, 0, 2, 5}
// Output:        {_, 1, _, 0, 2}

public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack();
        ArrayList<Integer> list = new ArrayList<>();

        for(int element: A){
            while(!stack.isEmpty() && (stack.peek() >= element)) stack.pop();

            if(stack.isEmpty()) list.add(-1);
            else list.add(stack.peek());
          
            stack.push(element);
        }

        return list;
    }
}
