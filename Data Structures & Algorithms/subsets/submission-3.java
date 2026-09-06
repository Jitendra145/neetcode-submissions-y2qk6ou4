class Solution {
    //algo map
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> sol = new ArrayList<>();
        rec(nums,0,sol);
        return res;
    }

    private void rec(int[] nums,int start, List<Integer> sol){
        res.add(new ArrayList<>(sol));
        for(int i=start;i<nums.length;i++){
            sol.add(nums[i]);
            rec(nums,i+1,sol);
            sol.remove(sol.size()-1);
        }
    }
}
