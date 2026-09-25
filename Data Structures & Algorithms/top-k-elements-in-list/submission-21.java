class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        Queue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            minHeap.offer(new int[]{entry.getValue(),entry.getKey()});
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = minHeap.poll()[1];
        }

        return res;
    }
}
