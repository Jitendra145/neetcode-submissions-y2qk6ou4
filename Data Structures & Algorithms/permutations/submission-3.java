class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> sol = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums,sol,visited);
        return res;
    }

    private void dfs(int[] nums, List<Integer> sol, boolean[] visited){
        if(sol.size()==nums.length){
            res.add(new ArrayList<>(sol));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i]) continue;
            sol.add(nums[i]);
            visited[i] = true;
            dfs(nums,sol,visited);
            visited[i] = false;
            sol.remove(sol.size()-1);
        }
    }
}
