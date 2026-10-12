class Solution {
    //Optimal O(n), O(n) neet code
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int num : nums){
            if(!set.contains(num-1)){
                int length =1;
                while(set.contains(num+length)){
                    length++;
                }

                res = Math.max(res,length);
            }
        }
        return res;
    }
}
