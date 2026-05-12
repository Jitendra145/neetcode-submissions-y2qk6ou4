class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> sol = new ArrayList<>();
        dfs(0,sol,0,nums,target);
        return res;
    }

    private void dfs(int i, List<Integer> sol, int total, int[] nums, int target){
        if(total==target){
            res.add(new ArrayList<>(sol));
            return;
        }
        if(i >= nums.length || total > target){
            return;
        }

        sol.add(nums[i]);
        dfs(i,sol,total+nums[i],nums,target);
        sol.remove(sol.size()-1);
        dfs(i+1,sol,total,nums,target);
    }
}
