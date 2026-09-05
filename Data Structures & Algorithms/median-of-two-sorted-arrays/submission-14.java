/*
To find the median of the two sorted arrays, a[] and b[] of size n and m, so to find median, we need the average of two middle elements of merged sorted array if merged array is even or take the middle element in case merged sorted array is odd length. 

The idea is to use Binary Search to find the valid partition in a[] say mid1, such that all elements of a[0...mid1 - 1] will lie in the first half of the merged sorted array. Since, we know that first half of the merged sorted array will have total X elements, the remaining mid2 = (X - mid1) elements will be from b[]. In other words, the first half of the merged sorted array will have all the elements in a[0...mid1 - 1] and b[0...mid2 - 1]. 

where X = (n+m+1)/2, we have added 1 to handle odd size

How to check if the partition mid1 and mid2 is valid or not?
For mid1 and mid2 to be valid, we need to check for the following conditions:

All elements in a[0...mid1 - 1] should be less than or equal to all elements in b[mid2...m - 1]. Since both the subarrays are sorted individually, we can check a[mid1 - 1] should be less than or equal to b[mid2].
All elements in b[0...mid2 - 1] should be less than or equal to all elements in a[mid1...n - 1]. Since both the subarrays are sorted individually, we can check b[mid2 - 1] should be less than or equal to a[mid1].

For simplicity, take the element to the left of partition mid1 as l1, so l1 = a[mid1 - 1] and element to the right of partition mid1 as r1, so r1 = a[mid1]. Similarly, take the element to the left of mid2 as l2, so l2 = b[mid2 - 1] and element to the right of mid2 as r2, so r2 = b[mid2]. So, the above conditions can be simplified as l1 <= r2 and l2 <= r1.

If the partition is not valid, we can have two cases:

If l1 > r2, this means that we have taken extra elements from a[], so take less elements by moving hi = mid - 1.
If l2 > r1, this means that we have taken less elements from a[], so take more elements by moving lo = mid + 1.


*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n= nums1.length,m=nums2.length;
        if(n>m)
            return findMedianSortedArrays(nums2,nums1);
        
        int lo=0,hi=n;
        while(lo<=hi){
            int mid1 = (lo+hi)/2;
            int mid2 = (n+m+1)/2-mid1;

            int l1 = (mid1==0)?Integer.MIN_VALUE:nums1[mid1-1];
            int r1 = (mid1==n)?Integer.MAX_VALUE:nums1[mid1];

            int l2 = (mid2==0)?Integer.MIN_VALUE:nums2[mid2-1];
            int r2 = (mid2==m)?Integer.MAX_VALUE:nums2[mid2];

            if(l1<=r2 && l2<=r1){
                if((m+n)%2==0){
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }else{
                    return Math.max(l1,l2);
                }
            }
            if(l1>r2){
                hi = mid1-1;
            }else{
                lo = mid1+1;
            }
            
        }
        return 0.0;
    }
}
