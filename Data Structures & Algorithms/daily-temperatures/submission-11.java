class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] res = new int[n];

        Stack<int[]> stk = new Stack<>();
        for(int i=0;i<n;i++){
            int t = temp[i];
            while(!stk.isEmpty() && t > stk.peek()[0]){
                int[] tmp = stk.pop();
                res[tmp[1]]=i-tmp[1];
            }
            stk.push(new int[]{t,i});
        }
        return res;
    }
}
