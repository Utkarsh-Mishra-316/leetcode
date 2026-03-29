class CustomStack {
    int[] stack;
    int[] inc; // Stores the increment values
    int top;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        inc = new int[maxSize];
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

        // 1. Current element ka actual value = stack value + increment value
        int res = stack[top] + inc[top];

        // 2. Lazy Propagate: Is index ka increment niche waale index ko pass kar do
        if (top > 0) {
            inc[top - 1] += inc[top];
        }

        // 3. Current index ka increment reset karo
        inc[top] = 0;
        top--;
        
        return res;
    }

    public void increment(int k, int val) {
        // Sirf k-th element (ya top) par value store karo
        int idx = Math.min(k - 1, top);
        if (idx >= 0) {
            inc[idx] += val;
        }
    }
}