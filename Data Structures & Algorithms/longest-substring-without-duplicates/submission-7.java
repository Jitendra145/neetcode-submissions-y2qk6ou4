class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int res = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            Set<Character> set = new HashSet<>();
            for(int j=i;j<s.length();j++){
                if(!set.add(s.charAt(j))){
                    break;
                }
            }

            res = Math.max(res,set.size());
        }

        return res;
    }
}
