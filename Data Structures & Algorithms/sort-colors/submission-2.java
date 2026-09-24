class Solution {
    /*
        “When we find 2, we swap it with the right pointer, but the element coming from the right is unprocessed. So we decrement curr so that after the loop's curr++, we process the same index again.”
    */
    public void sortColors(int[] nums) {
        int left =0, right = nums.length-1,curr=0;

        while(curr <= right){
            if(nums[curr]==0){
                swap(nums,left,curr);
                left++;
            }else if(nums[curr]==2){
                swap(nums,curr,right);
                right--;
                curr--;
            }
            curr++;
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}