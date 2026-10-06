class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<int[]> stk = new Stack<>();
        for(int i=0;i<n;i++){
            int tem = temperatures[i];
            while(!stk.isEmpty() && tem > stk.peek()[0]){
                int[] curr = stk.pop();                
                res[curr[1]] = i-curr[1];
            }
            stk.push(new int[]{tem,i});
        }
        return res;
    }
}
