class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int res =0;
        int[] nextS = nextSmaller(heights,n);
        int[] prevS = prevSmaller(heights,n);
        for(int i=0;i<n;i++){
           res = Math.max(res,heights[i]*(nextS[i]-prevS[i]-1));
        }
        return res;
    }

    private int[] nextSmaller(int[] heights,int n){
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            res[i] = n;
        }
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && heights[i] < heights[stk.peek()]){
                res[stk.pop()] = i;
            }
            stk.push(i);
        }
        return res;
    }

    private int[] prevSmaller(int[] heights, int n){
        int [] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = -1;
        }
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && heights[i] < heights[stk.peek()]){
                stk.pop();
            }

            if(!stk.isEmpty()){
                res[i] = stk.peek();
            }

            stk.push(i);
        }
        return res;
    }
}
