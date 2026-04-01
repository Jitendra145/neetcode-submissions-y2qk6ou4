class Solution {
    public int maxArea(int[] heights) {
        //Two pointer solution
        int n = heights.length;
        int l=0,r=n-1;
        int res = 0;
        while(l<r){
            res = Math.max(res,Math.min(heights[l],heights[r])*(r-l));
            if(heights[l] < heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}
