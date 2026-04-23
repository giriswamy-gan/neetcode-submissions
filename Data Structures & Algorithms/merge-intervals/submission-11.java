class Solution {
    public int[][] merge(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) - 1);
            map.put(interval[1], map.getOrDefault(interval[1], 0) + 1);
        }

        int cur = 0;
        int start = 0;
        List<int[]> res = new ArrayList<>();
        for(int key : map.keySet()) {
            if(cur == 0) {
                start = key;
            }
            cur += map.get(key);
            if(cur == 0) {
                res.add(new int[]{start, key});
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
