class MyHashSet {
    private int[] arr;

    public MyHashSet() {
        this.arr = new int[10000];
        Arrays.fill(arr, -1);
    }
    
    public void add(int key) {
        this.arr[key % 10000] = key;
    }
    
    public void remove(int key) {
        this.arr[key % 10000] = -1;
    }
    
    public boolean contains(int key) {
        return this.arr[key % 10000] != -1;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */