class Solution {
    Map<Integer, Integer> cache;
    public int coinChange(int[] coins, int amount) {
        cache = new HashMap<>();
        cache.put(0, 0);
        int res = dfs(coins, amount);
        return res == (int) 1e9 ? -1 : res;
    }

    private int dfs(int[] coins, int amount) {
        if(cache.containsKey(amount)) return cache.get(amount);
        int res = (int) 1e9;
        for(int coin : coins) {
            if(coin <= amount) {
                res = Math.min(res, 1 + dfs(coins, amount - coin));
            }
        }
        cache.put(amount, res);
        return res;
    }
}
