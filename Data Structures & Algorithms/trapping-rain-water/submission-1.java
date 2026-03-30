class Solution {
    public int trap(int[] height) {
        if(height.length == 1 || height.length == 2) return 0;
        HashMap<Integer, Integer> prefixMax = new HashMap<>();
        HashMap<Integer, Integer> suffixMax = new HashMap<>();
        int prefix = 0;
        int suffix = 0;
        int res = 0;
        for(int i = 0; i<height.length-1; ++i) {
            prefix = Math.max(prefix, height[i]);
            prefixMax.put(i, prefix);
        }
        for(int i=height.length-1; i>0; --i) {
            suffix = Math.max(suffix, height[i]);
            suffixMax.put(i, suffix);
        }
        for(int i=1; i<height.length-1; ++i) {
            int sum = Math.min(prefixMax.get(i), suffixMax.get(i)) - height[i];
            if(sum > 0) {
                res += sum;
            }
        }
        return res;
    }
}
