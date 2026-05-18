class Solution {
    private List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(0,0,"",n);
        return res;
    }

    private void dfs(int openP, int closedP, String s, int n){
        if(openP == closedP && openP+closedP == 2*n){
            res.add(s);
            return;
        }

        if(openP < n){
            dfs(openP+1,closedP,s+"(",n);
        }

        if(closedP < openP){
            dfs(openP,closedP+1,s+")",n);
        }
    }
}
