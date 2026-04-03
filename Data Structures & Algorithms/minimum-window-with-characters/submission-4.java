class Solution {
    //brute force O(n^2*m) O(m) n= length of string s, m=total no of unique characters in t and  s
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";

        Map<Character,Integer> countT = new HashMap<>();
        for(char ch : t.toCharArray()){
            countT.put(ch,countT.getOrDefault(ch,0)+1);
        }    
        int[] res = {-1,-1};
        int resLen = Integer.MAX_VALUE;

        for(int start=0;start<s.length();start++){
            Map<Character,Integer> countS = new HashMap<>();
            for(int end=start;end<s.length();end++){
                char ch = s.charAt(end);
                countS.put(ch,countS.getOrDefault(ch,0)+1);
                boolean flag = true;
                
                for(char c : countT.keySet()){
                    if(countS.getOrDefault(c,0) < countT.get(c)){
                        flag = false;
                        break;
                    }
                }
                if(flag && (end-start+1) < resLen){
                    resLen = end-start+1;
                    res[0] = start;
                    res[1] = end;
                }
            }
        }

        return resLen==Integer.MAX_VALUE?"":s.substring(res[0],res[1]+1);
    }
}
