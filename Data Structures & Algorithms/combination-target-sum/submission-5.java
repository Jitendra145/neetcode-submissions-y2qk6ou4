class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> sol = new ArrayList<>();
        dfs(nums,target,sol,0,0);
        return res;
    }

    private void dfs(int[] nums,int target, List<Integer> sol, int total, int i){
        if(total==target){
            res.add(new ArrayList<>(sol));
            return;
        }
        if(i>=nums.length || total > target){
            return;
        }

        sol.add(nums[i]);
        dfs(nums,target,sol,total+nums[i],i);
        sol.remove(sol.size()-1);
        dfs(nums,target,sol,total,i+1);
    }
}
