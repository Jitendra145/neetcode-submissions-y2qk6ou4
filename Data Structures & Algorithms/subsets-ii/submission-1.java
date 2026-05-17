class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> sol = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,0,sol);
        return res;
    }

    private void backtrack(int[] nums, int index, List<Integer> sol){
        res.add(new ArrayList<>(sol));

        for(int i=index;i<nums.length;i++){
            if(i > index && nums[i]==nums[i-1]) continue;
            sol.add(nums[i]);
            backtrack(nums,i+1,sol);
            sol.remove(sol.size()-1);
        }
    }
}
