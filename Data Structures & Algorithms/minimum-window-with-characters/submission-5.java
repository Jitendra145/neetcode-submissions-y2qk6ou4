class Solution {
    //sliding window O(n+m), O(m) n=length of s, m= no of unique charcters in s and t
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";

        Map<Character,Integer> countT = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for(char c : t.toCharArray()){
            countT.put(c,countT.getOrDefault(c,0)+1);
        }    

        int have =0, need=countT.size();
        int[] res = {-1,-1};
        int resLen = Integer.MAX_VALUE;
        int l=0;
        for(int r=0;r<s.length();r++){
            char ch = s.charAt(r);
            window.put(ch,window.getOrDefault(ch,0)+1);
            if(countT.containsKey(ch) && window.get(ch).equals(countT.get(ch))){
                have++;
            }

            while(have == need){
                if((r-l+1) < resLen){
                    resLen = r-l+1;
                    res[0] = l;
                    res[1] = r;
                }

                char left = s.charAt(l);
                window.put(left,window.get(left)-1);
                if(countT.containsKey(left) && window.get(left) < countT.get(left)){
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE?"":s.substring(res[0],res[1]+1);
    }
}
