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
        List<Integer> pointList = Arrays.asList(point[0], point[1]);
        int res = 0;
        for(List<Integer> key : map.keySet()) {
            if(Math.abs(key.get(0) - point[0]) == Math.abs(key.get(1) - point[1]) &&
            key.get(0) - point[0] != 0) {
                List<Integer> point1 = Arrays.asList(point[0], key.get(1));
                List<Integer> point2 = Arrays.asList(key.get(0), point[1]);
                res += map.get(key) * map.getOrDefault(point1, 0) * map.getOrDefault(point2, 0);
            }
        }
        return res;
    }
}
