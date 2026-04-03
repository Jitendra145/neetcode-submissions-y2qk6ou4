class Solution {
    public int characterReplacement(String s, int k) {
        //Brute force O(n^2) O(m) n= length of string, m=no of distinct character
        int res = 0;
        for(int i=0;i<s.length();i++){
            Map<Character,Integer> count = new HashMap<>();
            int maxf = 0;
            for(int j=i;j<s.length();j++){
                char ch = s.charAt(j);
                count.put(ch, count.getOrDefault(ch,0)+1);
                maxf = Math.max(maxf,count.get(ch));
                if((j-i+1)-maxf <= k){
                    res = Math.max(res,(j-i+1));
                }
            }
        }
        return res;
    }
}
