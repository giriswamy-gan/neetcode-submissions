class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean a = false, b = false, c = false;
        for(int[] t : triplets) {
            a |= (t[0] == target[0] && t[1] <= target[1] && t[2] <= target[2]);
            b |= (t[0] <= target[0] && t[1] == target[1] && t[2] <= target[2]);
            c |= (t[0] <= target[0] && t[1] <= target[1] && t[2] == target[2]);

            if(a && b && c) return true;
        }

        return false;
    }
}
