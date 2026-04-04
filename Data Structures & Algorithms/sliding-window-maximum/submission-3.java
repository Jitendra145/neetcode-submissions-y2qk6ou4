class Solution {
    //brute force, O(n*k), O(1) extra space and O(n-k+1) space for output array
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int[n-k+1];
        int index = 0;
        for(int i=0;i<=n-k;i++){
            int max = nums[i];
            for(int j=i;j<i+k;j++){
                max = Math.max(max,nums[j]);
            }
            res[index++] = max;
        }
        return res;
    }
}
