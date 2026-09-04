class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        this.stack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }
    
    public void push(int val) {       
        if(minStack.isEmpty() || minStack.peek() >= val){
            minStack.add(val);            
        }
         stack.add(val);
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        int val = stack.pop();
        if(minStack.peek()==val){
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
