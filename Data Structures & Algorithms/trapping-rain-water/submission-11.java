class Solution {
    public int trap(int[] height) {
        int res = 0;
        int n  = height.length;
        int l = 0, r = n-1;
        int lm = height[l], rm=height[r];
        while(l<r){
            if(lm < rm){
                l++;
                lm = Math.max(lm,height[l]);
                res+=lm-height[l];
            }else{
                r--;
                rm = Math.max(rm,height[r]);
                res+=rm-height[r];
            }
        }
        return res;
    }
}
