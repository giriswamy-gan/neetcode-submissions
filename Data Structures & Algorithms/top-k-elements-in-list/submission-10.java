class Solution {
    private static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, (l1, l2) -> {
        int valueCompare = l2.getValue().compareTo(l1.getValue());
        return valueCompare != 0 ? valueCompare : l1.getKey().compareTo(l2.getKey());
    });
        HashMap<Integer, Integer> ans = new LinkedHashMap<Integer, Integer>();
        for(Map.Entry<Integer, Integer> en : list) {
            ans.put(en.getKey(), en.getValue());
        }
        return ans;
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        HashMap<Integer, Integer> ansMap = sortByValue(map);
        int[] tempArr = new int[nums.length];
        int i = 0;
        for(Map.Entry<Integer, Integer> en : ansMap.entrySet()) {
            tempArr[i] = en.getKey();
            ++i;
        }
        int[] ansArr = new int[k];
        for(int j = 0; j<k; ++j) {
            ansArr[j] = tempArr[j];
        }
        return ansArr;
    }
}
