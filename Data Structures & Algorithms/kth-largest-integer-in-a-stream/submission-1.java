class KthLargest {
    private int k;
    private Queue<Integer> minHeap = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
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
