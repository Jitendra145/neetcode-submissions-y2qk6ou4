class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        int i=0;
        int j=0;
        while(i<nums.length){
           while(i<nums.length && nums[i]==1){count++;i++;}
           max = Math.max(max,count);
           count=0;
           if(i<nums.length && nums[i]==0){
            i++;
           }
        }
        return max;
    }
}