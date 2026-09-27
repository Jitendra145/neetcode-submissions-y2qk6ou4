class MinStack {
    private Stack<Integer> stk;
    private Stack<Integer> minStk;
    public MinStack() {
        this.stk = new Stack<>();
        this.minStk = new Stack<>();
    }
    
    public void push(int val) {
        if(minStk.isEmpty() || (!minStk.isEmpty() && minStk.peek()>=val)){
            minStk.push(val);
        }
        stk.push(val);
    }
    
    public void pop() {
        int val = stk.pop();
        if(val == minStk.peek()){
            minStk.pop();
        }
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minStk.peek();
    }
}
