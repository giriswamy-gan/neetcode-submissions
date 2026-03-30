class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] ans = new List[nums.length+1];
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i=0; i<ans.length; ++i) {
            ans[i] = new ArrayList<>();
        }
        for(int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> en : freq.entrySet()) {
            ans[en.getValue()].add(en.getKey());
        }
        int index = 0;
        int[] res = new int[k];
        for(int i=ans.length-1; i>0 && index < k; --i) {
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
