class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasTotal = Arrays.stream(gas).sum();
        int costTotal = Arrays.stream(cost).sum();
        if(costTotal > gasTotal) return -1;

        int tank = 0;
        int res = -1;
        for(int i = 0; i < gas.length; ++i) {
            tank += gas[i] - cost[i];
            if(tank < 0) {
                tank = 0;
                res = -1;
            }
            else {
                if(res == -1) {
                    res = i;
                }
            }
        }
        return res;
    }
}
