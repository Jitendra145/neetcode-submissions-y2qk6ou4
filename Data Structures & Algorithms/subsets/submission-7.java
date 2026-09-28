class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> sol = new ArrayList<>();
        rec(nums,sol,0);
        return res;
    }

    public void rec(int[] nums,List<Integer> sol, int start){
        res.add(new ArrayList<>(sol));
        for(int i=start;i<nums.length;i++){
            sol.add(nums[i]);
            rec(nums,sol,i+1);
            sol.remove(sol.size()-1);
        }
    }
}
