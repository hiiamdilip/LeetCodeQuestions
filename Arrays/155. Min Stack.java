class MinStack {

    Stack<Integer> stack;
    int min;
    
    public MinStack() {
        stack = new Stack();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(stack.isEmpty() || val < min) min = val;
        stack.push(val);
    }
    
    public void pop() {
        if(stack.pop() == min){
           if(stack.isEmpty()) return;
           min = stack.peek();
           for(int v : stack){
              if(v < min) min = v;
           }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
