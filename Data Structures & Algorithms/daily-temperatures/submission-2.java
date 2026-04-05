class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int [] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<n;i++){
            int tmp = temperatures[i];
            while(!stack.isEmpty() && stack.peek()[0] < tmp){
                int[] peek = stack.pop(); 
                res[peek[1]] = i- peek[1];
            }
            stack.push(new int[]{tmp,i});
        }
        return res;
    }
}
