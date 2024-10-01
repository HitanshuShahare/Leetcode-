class CustomStack {
    private int[] stack;
    private int size;
    private int top;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        size = maxSize;
        top = -1;
    }
    
    public void push(int x) {
        if (top < size - 1) {
            stack[++top] = x;
        }
    }
    
    public int pop() {
        if (top == -1) {
            return -1;
        }
        return stack[top--];
    }
    
    public void increment(int k, int val) {
        for (int i =  0; i < Math.min(k, top + 1); i++) {
            stack[i] += val;
        }
    }
}