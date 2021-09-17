class MyStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int top;
    
    public MyStack() {
       queue1 = new LinkedList<>(); 
       queue2 = new LinkedList<>(); 
    }
    
    public void push(int x) {
        top = x;
        queue1.add(x);
        
    }
    
    public int pop() {
        while(queue1.size() > 1){
            top = queue1.remove();
            queue2.add(top);
        }
        
        int result = queue1.remove();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return result;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}
