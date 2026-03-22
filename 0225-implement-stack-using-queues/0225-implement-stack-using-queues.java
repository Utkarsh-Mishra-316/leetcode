import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    // Push: O(n) Time Complexity
    public void push(int x) {
        // 1. Naya element q2 mein daalo
        q2.add(x);
        
        // 2. q1 ke saare puraane elements q2 mein shift karo
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        
        // 3. q1 aur q2 ko swap kar do
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    // Pop: O(1) Time Complexity
    public int pop() {
        return q1.remove();
    }
    
    // Top: O(1) Time Complexity
    public int top() {
        return q1.peek();
    }
    
    // Empty: O(1) Time Complexity
    public boolean empty() {
        return q1.isEmpty();
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */