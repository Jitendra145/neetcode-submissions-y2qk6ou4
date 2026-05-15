class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> sol = new ArrayList<>();
        backtrack(0,sol,candidates,target);
        return res;
    }

    private void backtrack(int start, List<Integer> sol, int[] candidates, int remaining){
        if(remaining==0){
            res.add(new ArrayList<>(sol));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i > start && candidates[i]==candidates[i-1]) continue;
            if(candidates[i] > remaining) break;
            sol.add(candidates[i]);
            backtrack(i+1,sol,candidates,remaining-candidates[i]);
            sol.remove(sol.size()-1);
        }
    }
}
