class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<int[]> stk = new Stack<>();
        for(int i=0;i<n;i++){
            int tmp = temperatures[i];
            while(!stk.isEmpty() && tmp > stk.peek()[0]){
                int[] arr = stk.pop();
                res[arr[1]] = i-arr[1];
            }
            stk.add(new int[]{tmp,i});
        }
        return res;
    }
}
