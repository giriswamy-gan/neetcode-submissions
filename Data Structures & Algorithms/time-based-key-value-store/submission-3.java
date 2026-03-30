class TimeMap {
    HashMap<String, List<Pair<Integer, String>>> keyMap;

    public TimeMap() {
        keyMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!keyMap.containsKey(key)) return "";
        List<Pair<Integer, String>> valueMap = keyMap.get(key);

        int l = 0;
        int r = valueMap.size() - 1;
        String res = "";

        while(l <= r) {
            int m = l + (r - l) / 2;
            if(valueMap.get(m).getKey() <= timestamp) {
                res = valueMap.get(m).getValue();
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}

private static class Pair<K, V> {
    K key;
    V value;

    public Pair(K key, V value) {
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
