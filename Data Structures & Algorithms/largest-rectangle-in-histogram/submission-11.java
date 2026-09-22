class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] prevS = prevSmaller(heights);
        int[] nextS = nextSmaller(heights);

        int res = 0;
        for(int i=0;i<heights.length;i++){
            res = Math.max(res,heights[i]*(nextS[i]-prevS[i]-1));
        }
        return res;
    }

    private int[] nextSmaller(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = n;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
 // For the bars I've already seen, did this new bar just become their first smaller bar?
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                res[stack.pop()] = i;
            }
            stack.push(i);
        }
        return res;
    }

    private int[] prevSmaller(int[] arr){
        int n = arr.length;
        int [] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
           //For the current bar, what is the nearest smaller bar I've already seen? 

            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }
}
