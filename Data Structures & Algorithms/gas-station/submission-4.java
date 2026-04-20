class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for(int i = 0; i < n; ++i) {
            if(cost[i] > gas[i]) continue;
            int curCost = gas[i] - cost[i];
            int j = (i + 1) % n;
            while(j != i) {
                curCost += gas[j] - cost[j];
                if(curCost < 0) break;
                j = (j + 1) % n;
            }
            if(j == i) {
                return i;
            }
        }
        return -1;
    }
}
