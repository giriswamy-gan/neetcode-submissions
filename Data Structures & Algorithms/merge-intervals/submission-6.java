class Solution {
    public int[][] merge(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) - 1);
            map.put(interval[1], map.getOrDefault(interval[1], 0) + 1);
        }
        List<int[]> res = new ArrayList<>();
        int start = -1, cur = 0;
        for(int key : map.keySet()) {
            if(start == -1) {
                start = key;
            }
            cur += map.get(key);
            if(cur == 0) {
                res.add(new int[]{start, key});
                start = -1;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
