class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for(int num : nums){
            heapify(num);
        }
    }
    
    public int add(int val) {
        heapify(val);
        return minHeap.peek();
    }

    private void heapify(int num){
        minHeap.offer(num);
        if(minHeap.size() > k){
            minHeap.poll();
        }
    }
}
