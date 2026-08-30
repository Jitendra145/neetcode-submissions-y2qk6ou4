class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        Map<Character,Integer> count = new HashMap<>();
        int l=0, maxf=0;
        for(int r=0;r<s.length();r++){
            char ch = s.charAt(r);
            count.put(ch,count.getOrDefault(ch,0)+1);
            maxf = Math.max(maxf,count.get(ch));
            while((r-l+1)-maxf > k){
                count.put(s.charAt(l),count.get(s.charAt(l))-1);
                l++;
            }
            res = Math.max(res,r-l+1);
        }
        return res;
    }
}
