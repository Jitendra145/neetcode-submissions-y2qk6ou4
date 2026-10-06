class Solution {
    public int largestRectangleArea(int[] heights) {
       int[] next = nextSmaller(heights);
       int[] prev = prevSmaller(heights);
       int res = 0;
       for(int i=0;i<heights.length;i++){
        int width = next[i]-prev[i]-1;
        res = Math.max(res,heights[i]*width);
       }
       return res;
    }

    private int[] nextSmaller(int[] heights){
        int n = heights.length;
        int[] res = new int[n];
        Arrays.fill(res,n);

        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && heights[i] < heights[stk.peek()]){
                res[stk.pop()] = i;
            }
            stk.push(i);
        }
        return res;
    }

    private int[] prevSmaller(int[] heights){
        int n = heights.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && heights[i] < heights[stk.peek()]){
                stk.pop();
            }
            if(!stk.isEmpty()){
                res[i]= stk.peek();
            }
            stk.push(i);
        }
        return res;
    }
}
