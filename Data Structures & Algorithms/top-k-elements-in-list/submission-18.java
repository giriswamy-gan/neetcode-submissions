class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length+1];
        for(int i=0; i<bucket.length; ++i) {
            bucket[i] = new ArrayList<>();
        }
        freq.forEach((key, v) -> {
            bucket[v].add(key);
        });

        int[] res = new int[k];
        int idx = 0;
        for(int i=bucket.length - 1; i>=0; i--) {
            int j = 0;
            while(j < bucket[i].size()) {
                res[idx++] = bucket[i].get(j);
                if(idx == k) {
                    return res;
                }
                ++j;
            }
        }
        return res;
    }
}
