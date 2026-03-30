class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<int[]> arrList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            arrList.add(new int[]{entry.getValue(), entry.getKey()});
        }
        arrList.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        for(int i=0; i<k; ++i) {
            res[i] = arrList.get(i)[1];
        }
        return res;
    }
}
