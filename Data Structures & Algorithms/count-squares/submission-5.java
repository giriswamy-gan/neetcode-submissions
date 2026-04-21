class CountSquares {
    Map<List<Integer>, Integer> map;

    public CountSquares() {
        map = new HashMap<>();    
    }
    
    public void add(int[] point) {
        List<Integer> list = Arrays.asList(point[0], point[1]);
        map.put(list, map.getOrDefault(list, 0) + 1);
    }
    
    public int count(int[] point) {
        int res = 0;
        int px = point[0], py = point[1];
        for(List<Integer> q : map.keySet()) {
            int qx = q.get(0), qy = q.get(1);
            if((qx == px && qy == py) || Math.abs(px - py) != Math.abs(qx - qy)) continue;
            List<Integer> q1 = Arrays.asList(qx, py);
            List<Integer> q2 = Arrays.asList(px, qy);
            if(map.containsKey(q) && map.containsKey(q1) && map.containsKey(q2)) {
                res += map.get(q) * map.get(q1) * map.get(q2);
            }
        }
        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */