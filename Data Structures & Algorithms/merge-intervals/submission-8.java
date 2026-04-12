class Solution {
    public int[][] merge(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) - 1);
            map.put(interval[1], map.getOrDefault(interval[1], 0) + 1);
        }
        List<int[]> res = new ArrayList<>();
        int start = -1, have = 0;
        for(int key : map.keySet()) {
            if(have == 0) {
                start = key;
            }
            have += map.get(key);
            if(have == 0) {
                res.add(new int[]{start, key});
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
