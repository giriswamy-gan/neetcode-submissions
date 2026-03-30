class TimeMap {
    private Map<String, List<Pair<Integer, String>>> keyStore;

    public TimeMap() {
        keyStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair<Integer, String> pair = new Pair<>(timestamp, value);
        List<Pair<Integer, String>> list = keyStore.getOrDefault(key, new ArrayList<>());
        // if(keyStore.containsKey(key)) {
        //     list = keyStore.get(key);
        // }
        // else {
        //     list = new ArrayList<>();
        // }
        list.add(pair);
        keyStore.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> list = keyStore.getOrDefault(key, new ArrayList<>());
        int r = list.size() - 1, l = 0;
        String result = "";
        while(l <= r) {
            int mid = l + (r-l)/2;
            Pair<Integer, String> pair = list.get(mid);
            if(pair.getKey() <= timestamp) {
                result = pair.getValue();
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
}


// [1, 2, 3, 6, 7]



private static class Pair<K,V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
