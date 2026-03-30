class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer>[] ans = new List[nums.length + 1];
        for(int i=0; i<ans.length; ++i) {
            ans[i] = new ArrayList<>();
        }
        for(int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            ans[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for(int i=ans.length - 1; i > 0 && index < k; --i) {
            for(int n: ans[i]) {
                res[index++] = n;
                if(index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
