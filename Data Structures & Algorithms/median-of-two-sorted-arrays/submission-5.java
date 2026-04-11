class Solution {
    //gfg brute force O((m+n)*log(m+n)) O(m+n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] res = new int[nums1.length+nums2.length];
        System.arraycopy(nums1,0,res,0,nums1.length);
        System.arraycopy(nums2,0,res,nums1.length,nums2.length);

        Arrays.sort(res);
        int len = res.length;
        if(len%2==0){
            return (res[len/2]+res[len/2-1])/2.0;
        }else{
            return res[len/2];
        }
    }
}
