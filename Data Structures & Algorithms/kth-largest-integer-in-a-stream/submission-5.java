class KthLargest {
    Queue<Integer> minHeap = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums){
            heapify(num);
        }
    }
    
    public int add(int val) {
        return heapify(val);
    }

    private int heapify(int num){
        minHeap.offer(num);
        if(minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
