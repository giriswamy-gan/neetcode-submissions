class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] freq = new List[nums.length + 1];
        for(int i = 0; i<freq.length; ++i) {
            freq[i] = new ArrayList<>();
        }

        count.forEach((key, value) -> {
            freq[value].add(key);
        });

        int res[] = new int[k];
        int itr = 0;
        for(int i=nums.length; i>0 && itr<k; --i) {
            for(int n : freq[i]) {
                res[itr++] = n;
                if(itr == k) return res;
            }
        }
        return res;
    }
}
