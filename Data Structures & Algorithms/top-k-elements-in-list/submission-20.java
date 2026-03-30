class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer>[] bucket = new List[n + 1];
        for(int i=0; i<bucket.length; ++i) {
            bucket[i] = new ArrayList<>();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            bucket[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int idx = 0;
        for(int i=n; i>=0; --i) {
            int j = 0;
            while(j < bucket[i].size()) {
                res[idx++] = bucket[i].get(j);
                ++j;
                if(idx == k) return res;
            }
        }
        return res;
    }
}
