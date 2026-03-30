class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int max = 1, min = 1;
        for(int n : nums) {
            int tmp = max * n;
            max = Math.max(Math.max(min * n, max * n), n);
            min = Math.min(Math.min(min * n, tmp), n);
            res = Math.max(res, max);
        }
        return res;
    }
}