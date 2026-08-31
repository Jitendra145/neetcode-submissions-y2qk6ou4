class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int num : nums){
            if(!set.contains(num-1)){
                int longest = 1;
                while(set.contains(num+longest)){
                    longest++;
                }
            res = Math.max(res,longest);
            }
        }
        return res;
    }
}
