class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Max heap O(nlogn), O(n)
        Map<Integer,Integer> count = new HashMap<>();
        for(int num : nums){
            count.put(num,count.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->count.get(b)-count.get(a));
        pq.addAll(count.keySet());

        int [] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = pq.poll();
        }
        return res;
    }
}
