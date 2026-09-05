class Solution {
    public int maxSubArray(int[] nums) {
        //Kadane's algorithm
        int max = nums[0];
        int sum = nums[0];
        for(int i=1;i<nums.length;i++){
            if(sum<0){
                sum = nums[i];
            }else{
                sum += nums[i];
            }
            if(sum > max){
                max=sum;
            }
        }
        return max;
    }
}
