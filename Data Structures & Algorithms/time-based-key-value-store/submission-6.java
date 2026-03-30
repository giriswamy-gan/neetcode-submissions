class Pair<K,V> {
    private K key;
    private V value;

    public Pair (K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }
}

class TimeMap {
    Map<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // if(!map.containsKey(key)) {
        //     map.put(key, new ArrayList<>());
        // }
        // map.get(key).add(new Pair<>(value, timestamp));
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair<String, Integer>> list = map.get(key);
        int l = 0, r = list.size() - 1;
        int res = -1;
        while(l <= r) {
            int m = l + (r-l) / 2;
            if(list.get(m).getValue() <= timestamp) {
                res = Math.max(res, m);
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res == -1 ? "" : list.get(res).getKey();
    }
}
