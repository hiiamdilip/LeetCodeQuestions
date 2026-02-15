//Solution 1 using two queue, push friendly but pop and lookup costly
class MyStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;
    
    public MyStack() {
       q1 = new ArrayDeque<>();
       q2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
       q1.offer(x);
    }
    
    public int pop() {
       while(q1.size() > 1){
        q2.offer(q1.poll());
       }

       int top = q1.poll();

       Queue<Integer> temp = new ArrayDeque<>();
       temp = q1;
       q1 = q2;
       q2 = temp;

       return top;
    }
    
    public int top() {
       while(q1.size() > 1){
        q2.offer(q1.poll());
       }

       int top = q1.peek();
       q2.offer(q1.poll());

       Queue<Integer> temp = new ArrayDeque<>();
       temp = q1;
       q1 = q2;
       q2 = temp;

       return top;

    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
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
