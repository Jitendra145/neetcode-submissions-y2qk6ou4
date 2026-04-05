class Solution {
    //Brute Force O(n^2) O(1)
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for(int i=0;i<heights.length;i++){
            int right = 0;
            int left = 0; 
            for(int j=i-1;j>=0;j--){
                if(heights[i] > heights[j]){
                    break;
                }
                left = Math.max(left,i-j);
            }
            for(int j=i+1;j<heights.length;j++){
                if(heights[i] > heights[j]){
                    break;
                }
                right = Math.max(right,j-i);
            }
            res = Math.max(res,heights[i]*(left+right+1));
        }
        return res;
    }
}
