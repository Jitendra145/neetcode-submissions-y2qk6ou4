class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int curSum = 0;
        Map<Integer,Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1);//empty prefix

        for(int num : nums){
            curSum += num;
            int diff = curSum -k;
            res+= prefixSum.getOrDefault(diff,0);
            prefixSum.put(curSum, prefixSum.getOrDefault(curSum,0)+1);
        }

        return res;
    }

}