class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        this.stack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
       
        if(stack.isEmpty()){
             minStack.add(val);
        }else{
            if(minStack.peek() >= val){
                minStack.add(val);
            }
        }
         stack.add(val);
    }
    
    public void pop() {
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
