class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for(int l = 0; l < gas.length; ++l) {
            int tank = gas[l] - cost[l];
            if(tank < 0) continue;

            int r = (l + 1) % n;
            while(r != l) {
                tank = tank + gas[r] - cost[r];
                if(tank < 0) break;
                r = (r + 1) % n;
            }
            if(r == l) return l;
        }
        return -1;
    }
}
