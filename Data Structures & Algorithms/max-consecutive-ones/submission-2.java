class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res=0,cnt=0;
        for(int num : nums){
            cnt = num==0?0:cnt+1;
            res = Math.max(res,cnt);
        }
        return res;
    }
}