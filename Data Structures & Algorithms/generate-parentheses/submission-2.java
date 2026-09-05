class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("",res,n);
        return res;
    }

    private void dfs(String s, List<String> res,int n){
        if(2*n == s.length()){
            if(isValid(s)){
                res.add(s);                
            }
            return;
        }

        dfs(s+'(',res,n);
        dfs(s+')',res,n);
    }

    private boolean isValid(String s){
        int open = 0;
        for(char ch : s.toCharArray()){
            open += ch=='('?1:-1;
            if(open < 0){
                return false;
            }
        }
        return open==0;
    }
}
