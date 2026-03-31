class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0)
            return 0;
        Arrays.sort(nums);
        int curr = nums[0],i=0,res=1,streak=0;
        while(i<n){
            if(curr != nums[i]){
                curr = nums[i];
                streak = 0;
            }
            while(i<n && nums[i]==curr){
                i++;
            }
            streak++;
            curr++;
            res = Math.max(res,streak);
        }
        return res;
    }
}
