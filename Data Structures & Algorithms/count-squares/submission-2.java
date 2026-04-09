class CountSquares {
    Map<List<Integer>, Integer> map;

    public CountSquares() {
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        List<Integer> key = Arrays.asList(point[0], point[1]);
        map.put(key, map.getOrDefault(key, 0) + 1);
    }
    
    public int count(int[] point) {
        int qx = point[0], qy = point[1];
        int res = 0;

        for(List<Integer> key : map.keySet()) {
            int px = key.get(0), py = key.get(1);
            if(Math.abs(px - qx) == Math.abs(py - qy) && Math.abs(px - qx) > 0) {
                List<Integer> p1 = Arrays.asList(px, qy);
                List<Integer> p2 = Arrays.asList(qx, py);
                if(map.containsKey(p1) && map.containsKey(p2)) {
                    res += map.get(p1) * map.get(p2) * map.get(key);
                }
            }
        }
        return res;
    }
}
