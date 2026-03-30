class MinStack {
    private Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        Stack<Integer> s2 = new Stack<>();
        int min = stack.peek();
        while(!stack.isEmpty()) {
            int val = stack.pop();
            if(val < min) min = val;
            s2.push(val);
        }
        while(!s2.isEmpty()) {
            stack.push(s2.pop());
        }
        return min;
    }
}
