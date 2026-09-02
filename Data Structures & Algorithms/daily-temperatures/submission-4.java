class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int [] res = new int[n];
        Stack<int[]> stk = new Stack<>();
        for(int i=0;i<n;i++){
            int tmp = temperatures[i];
            while(!stk.isEmpty() && stk.peek()[0] < tmp){
                int[] peek = stk.pop();
                res[peek[1]] = i-peek[1];
            }
            stk.push(new int[]{tmp,i});
        }

        return res;
    }
}
