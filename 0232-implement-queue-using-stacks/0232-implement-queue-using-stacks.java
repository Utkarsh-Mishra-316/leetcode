import java.util.Stack;

class MyQueue {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    // Push is simple: always add to the input stack
    public void push(int x) {
        input.push(x);
    }
    
    // Pop needs to return the oldest element
    public int pop() {
        peek(); // Ensure output stack has the current elements
        return output.pop();
    }
    
    // Peek returns the oldest element without removing it
    public int peek() {
        // If output stack is empty, move everything from input to output
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}