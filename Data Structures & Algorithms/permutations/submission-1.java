class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> sol = new ArrayList<>();
        boolean [] visited = new boolean[nums.length];
        backtrack(nums,sol,visited);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> sol, boolean[] visited){
        if(sol.size()==nums.length){
            res.add(new ArrayList<>(sol));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i]) continue;
            sol.add(nums[i]);
            visited[i] = true;
            backtrack(nums,sol,visited);
            visited[i] = false;
            sol.remove(sol.size()-1);
        }
    }
}
