class Solution {
    private List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return res;
        }
        Map<Character,String> digitMap = new HashMap<>();
        digitMap.put('2',"abc");
        digitMap.put('3',"def");
        digitMap.put('4',"ghi");
        digitMap.put('5',"jkl");
        digitMap.put('6',"mno");
        digitMap.put('7',"pqrs");
        digitMap.put('8',"tuv");
        digitMap.put('9',"wxyz");

        dfs(0,new StringBuilder(),digits,digitMap);
        return res;
    }

    private void dfs(int idx, StringBuilder path,String digits,Map<Character,String> digitMap){
        if(idx==digits.length()){
            res.add(path.toString());
            return;
        }

        String str = digitMap.get(digits.charAt(idx));
        for(char ch : str.toCharArray()){
            path.append(ch);
            dfs(idx+1,path,digits,digitMap);
            path.deleteCharAt(path.length()-1);
        }
    }
}
