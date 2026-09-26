class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> sol = new ArrayList<>();
        backtrack(nums,target,sol,0);
        return res;
    }

    private void backtrack(int[] nums, int target,List<Integer> sol, int start){
        if(target==0){
            res.add(new ArrayList<>(sol));
            return;
        }
        if(target< 0 || start >= nums.length){
            return;
        }

        sol.add(nums[start]);
        backtrack(nums,target-nums[start],sol,start);
        sol.remove(sol.size()-1);
        backtrack(nums,target,sol,start+1);
    }
}
