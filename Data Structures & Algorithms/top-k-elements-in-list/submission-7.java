class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //sorting
        Map<Integer,Integer> count = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            count.put(nums[i],count.getOrDefault(nums[i],0)+1);
        }
        List<int[]> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: count.entrySet()){
            list.add(new int[]{entry.getValue(),entry.getKey()});
        }
        list.sort((a,b)->b[0]-a[0]);
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = list.get(i)[1];
        }
        return res;
    }
}
