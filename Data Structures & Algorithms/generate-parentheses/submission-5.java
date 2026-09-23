class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(0,0,"",n);
        return res;
    }

    private void dfs(int openP, int closeP, String s,int n){
        if(openP==closeP && openP ==n){
            res.add(s);
            return;
        }

        if(openP<n){
            dfs(openP+1,closeP,s+"(",n);
        }
        if( openP > closeP){
            dfs(openP,closeP+1,s+")",n);
        }
    }
}
