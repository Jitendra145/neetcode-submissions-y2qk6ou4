class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> sol = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        dfs(nums,sol,isVisited);
        return res;
    }

    private void dfs(int[] nums,List<Integer> sol,boolean[] isVisited){
        if(sol.size()==nums.length){
            res.add(new ArrayList<>(sol));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(isVisited[i]) continue;
            isVisited[i] = true;
            sol.add(nums[i]);
            dfs(nums,sol,isVisited);
            sol.remove(sol.size()-1);
            isVisited[i] = false;
        }
    }
}
