class Solution {
    public void sortColors(int[] nums) {
        //dutch national flag
        int left = 0, curr=0,right=nums.length-1;

        while(curr <= right){
            if(nums[curr]==0){
                swap(nums,left,curr);
                left++;
            }
            else if(nums[curr]==2){
                swap(nums,right,curr);
                right--;
                curr--;
            }
            curr++;
        }
    }

    private void swap(int[] nums, int a,int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}