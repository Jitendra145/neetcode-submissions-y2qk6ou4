class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int [] res = new int[n-k+1];
        if(n==0) return res;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });

        int index = 0;

        for(int i=0;i<n;i++){
            maxHeap.offer(new int[]{nums[i],i});

            if(i>=k-1){
                while(!maxHeap.isEmpty() && maxHeap.peek()[1] < i-k+1){
                    maxHeap.poll();
                }
                res[index++] = maxHeap.peek()[0];
            }
        }
        return res;
    }
}
