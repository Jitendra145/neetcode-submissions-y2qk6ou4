class Solution {
    //Using two Stack O(n) time and O(n) space
    public int largestRectangleArea(int[] heights) {
        int [] nextS = nextSmaller(heights);
        int [] prevS = prevSmaller(heights);
        
        int res = 0;
        for(int i=0;i<heights.length;i++){
            int width = nextS[i]-prevS[i]-1;
            res = Math.max(res,heights[i]*width);
        }
        return res;
    }

    private int[] nextSmaller(int [] arr){
        int n = arr.length;
        int [] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = n;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                res[stack.pop()] = i;
            }
            stack.push(i);
        }

        return res;
    }

    private int[] prevSmaller(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
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
