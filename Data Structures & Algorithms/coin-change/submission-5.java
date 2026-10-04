class Solution {
    private Map<Integer,Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        int minCoins = dfs(coins,amount);
        return minCoins==1e9?-1:minCoins;
    }

    private int dfs(int[] coins, int amount){
        if(amount==0){
            return 0;
        }
        if(map.containsKey(amount)){
            return map.get(amount);
        }
        int res = (int)1e9;
        for(int coin : coins){
            int rem = amount-coin;
            if(rem>=0){
                res = Math.min(res,1+dfs(coins,rem));
            }
        }
        map.put(amount,res);
        return res;
    }
}
