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

// Solution 2
// Interview preference, using one queue but push costly. pop and peek faster o(1)

class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }
    
    public void push(int x) {
        queue.offer(x);

        int rotations = queue.size() -1;

        for(int i =0; i<rotations; i++){
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}
