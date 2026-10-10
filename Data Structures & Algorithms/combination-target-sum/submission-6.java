class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> sol = new ArrayList<>();
        dfs(nums,target,sol,0,0);
        return res;
    }

    private void dfs(int[] nums, int target,List<Integer> sol, int total, int start){
        if(total==target){
            res.add(new ArrayList<>(sol));
            return;
        }
        if(start >= nums.length || total >target) return;
        sol.add(nums[start]);
        dfs(nums,target,sol,total+nums[start],start);
        sol.remove(sol.size()-1);
        dfs(nums,target,sol,total,start+1);
    }
}
