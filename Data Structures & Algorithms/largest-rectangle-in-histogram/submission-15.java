class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] prev = prevSmaller(heights);
        int[] next = nextSmaller(heights);
        int res = 0;
        for(int i=0;i<heights.length;i++){
            res = Math.max(res, heights[i]*(next[i]-prev[i]-1));
        }
        return res;
    }

    private int[] prevSmaller(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = -1;
        }
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && arr[i] < arr[stk.peek()]){
                stk.pop();
            }
            if(!stk.isEmpty()){
                res[i] = stk.peek();
            }
            stk.push(i);
        }
        return res;
    }

    private int[] nextSmaller(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i]=n;
        }

        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && arr[i] < arr[stk.peek()]){
                res[stk.pop()] = i;
            }
            stk.push(i);
        }
        return res;
    }

}
