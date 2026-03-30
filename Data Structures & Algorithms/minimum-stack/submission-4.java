class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int val) {
        st.add(val);
        if(minSt.isEmpty() || minSt.peek() >= st.peek()) {
            minSt.push(val);
        }
    }
    
    public void pop() {
        int popped = st.pop();
        if(popped == minSt.peek()) {
            minSt.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
    }
}
