class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    
    public MyQueue() {
       this.stack1 = new Stack<>();
       this.stack2 = new Stack<>(); 
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
       if(stack2.isEmpty()) 
           while(!stack1.isEmpty())
               stack2.push(stack1.pop());
        return stack2.pop();
    }
    
    public int peek() {
        if(stack2.isEmpty()) 
           while(!stack1.isEmpty())
               stack2.push(stack1.pop());
        return stack2.peek();
    }
    
    public boolean empty() {
        if(stack1.isEmpty() && stack2.isEmpty()) return true;
        return false;
    }
}

Solution 2

class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack();
        outStack = new Stack();
    }
    
    public void push(int x) {
        inStack.add(x);
    }
    
    public int pop() {
        transferIfNeeded();
        return outStack.pop();
    }
    
    public int peek() {
        transferIfNeeded();
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public void transferIfNeeded(){
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.add(inStack.pop());
            }
        }
    }
}
