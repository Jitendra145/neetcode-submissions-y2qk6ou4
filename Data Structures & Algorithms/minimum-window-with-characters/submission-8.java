class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";

        Map<Character,Integer> countT = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for(char ch:t.toCharArray()){
            countT.put(ch,countT.getOrDefault(ch,0)+1);
        }

        int have = 0,need = countT.size();
        int left=0;
        int resLen = Integer.MAX_VALUE;
        int[] res = {-1,-1};
        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            window.put(ch,window.getOrDefault(ch,0)+1);
            if(countT.containsKey(ch) && window.get(ch).equals(countT.get(ch))){
                have++;
            }

            while(have==need){
                if(right-left+1 < resLen){
                    resLen = right-left+1;
                    res[0] = left;
                    res[1] = right;
                }

                char l = s.charAt(left);
                window.put(l,window.get(l)-1);
                if(countT.containsKey(l) && window.get(l) < countT.get(l)){
                    have--;
                }
                left++;
            }
        }

        return resLen == Integer.MAX_VALUE?"":s.substring(res[0],res[1]+1);
    }
}
