class Solution {
    /*
    while there are elements left:

    find middle

    if middle == target:
        return middle

    determine which half is sorted

    if LEFT half is sorted:

        if target belongs to left half:
            search left
        else:
            search right

    else:

        RIGHT half must be sorted

        if target belongs to right half:
            search right
        else:
            search left

return -1

    */
    public int search(int[] nums, int target) {
       int l = 0;
       int r = nums.length-1;

       while(l<=r){
            int mid = (l+r)/2;
           // Question 1: Did I find the target?
            if(nums[mid]==target){
                return mid;
            }
            //Question 2: Which half is sorted?
            //if below is true then left is sorted o/w right
            //Question 3: Is the target inside the sorted half?
            //  If yes → search that half.

            //If no → discard that half and search the other half.
            if(nums[l] <= nums[mid]){
                if(target > nums[mid] || target < nums[l]){
                    l = mid+1;
                }else{
                    r=mid-1;
                }
            }else{
                if(target <nums[mid] || target > nums[r]){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }
       }
       return -1;
    }
}
