class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String token : tokens){
            switch(token){
                case "+" ->{
                    int b = stk.pop();
                    int a = stk.pop();
                    stk.push(a+b);
                }
                case "-" ->{
                    int b = stk.pop();
                    int a = stk.pop();
                    stk.push(a-b);
                }
                case "*" ->{
                    int b = stk.pop();
                    int a = stk.pop();
                    stk.push(a*b);
                }
                case "/" ->{
                    int b = stk.pop();
                    int a = stk.pop();
                    stk.push(a/b);
                }
                default -> stk.push(Integer.parseInt(token));
            }
        }
        return stk.pop();
    }
}
