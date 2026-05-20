class Solution {
    private int n;
    private String inputString;
    private boolean [][] isPartition;
    private List<String> currPartition = new ArrayList<>();
    private List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        n = s.length();
        inputString = s;
        isPartition = new boolean[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(isPartition[i],true);
        }

        for(int start=n-1;start >=0;start--){
            for(int end = start+1;end<n;end++){
                isPartition[start][end] = s.charAt(start)==s.charAt(end) &&
                                            isPartition[start+1][end-1];
            }
        }

        dfs(0);
        return res;
    }

    private void dfs(int idx){
        if(idx==inputString.length()){
            res.add(new ArrayList<>(currPartition));
        }

        for(int end=idx;end<n;end++){
            if(isPartition[idx][end]){
                currPartition.add(inputString.substring(idx,end+1));
                dfs(end+1);
                currPartition.remove(currPartition.size()-1);
            }
        }
    }
}
