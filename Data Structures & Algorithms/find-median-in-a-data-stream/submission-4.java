class MedianFinder {
    private Queue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
    private Queue<Integer> minHeap = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }

        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
        else if((maxHeap.size() - minHeap.size()) > 1){
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
        return maxHeap.peek();
    }
}
