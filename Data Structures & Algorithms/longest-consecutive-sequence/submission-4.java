class Solution {
    
    public int longestConsecutive(int[] nums) {
       if(nums.length==0)
            return 0;
       Set<Integer> set = new HashSet<>();
       for(int num : nums){
        set.add(num);
       }
       int res = 1;
       for(int num :set){
        if(!set.contains( num-1)){
            int count = 1;
            int x = num;
            while(set.contains(x+1)){
                count++;
                x++;
            }
            res = Math.max(res,count);
        }
       }
       return res;
    }
}
