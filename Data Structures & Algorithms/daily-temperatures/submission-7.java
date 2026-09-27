class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<int[]> stk = new Stack<>();
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            int tmp = temperatures[i];
            while(!stk.isEmpty() && tmp > stk.peek()[0]){
                int[] t = stk.pop();
                res[t[1]] = i-t[1];
            }
            stk.push(new int[]{tmp,i});
        }
        return res;
    }
}
