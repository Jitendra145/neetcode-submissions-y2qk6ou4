class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int res = 1,count=1;
        int i=0;
        while(i<nums.length-1){
            if(nums[i]==nums[i+1]){  
                i++;             
                continue;
            }else if(nums[i]+1==nums[i+1]){                
                count++;
            }else{
                count=1;;
            }
            res= Math.max(res,count);
            i++;
        }
        return  res;
    }
}
