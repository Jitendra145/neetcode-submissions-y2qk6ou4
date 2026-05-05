class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for(int stone : stones){
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1){
            int max1 = maxHeap.poll();
            int max2 = maxHeap.poll();
            if(max1!=max2){
                maxHeap.offer(max1-max2);
            }
        }

        return maxHeap.size()==0?0:maxHeap.peek();
    }
}
