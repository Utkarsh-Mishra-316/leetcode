class CustomStack {
    int[] stack;
    int top;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        top = -1;
    }

    public void push(int x) {
        if (top < stack.length - 1) {
            top++;
            stack[top] = x;
        }
    }

    public int pop() {
        if (top == -1) return -1;
        return stack[top--];
    }

    public void increment(int k, int val) {
        // Increment either k elements or the whole stack, whichever is smaller
        int limit = Math.min(k, top + 1);
        for (int i = 0; i < limit; i++) {
            stack[i] += val;
        }
    }
}