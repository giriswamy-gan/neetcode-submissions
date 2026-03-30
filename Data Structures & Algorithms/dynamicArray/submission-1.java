class DynamicArray {

    int[] arr;
    int size = 0;
    int capacity;

    public DynamicArray(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if(size == capacity) {
            resize();
        }
        arr[size] = n;
        size++;
    }

    public int popback() {
        size--;
        return arr[size];
    }

    private void resize() {
        // arr = Arrays.copyOf(arr, capacity * 2);
        // capacity = capacity * 2;
        int[] arr2 = new int[capacity*2];
        for(int i=0; i<capacity; ++i) {
            arr2[i] = arr[i];
        }
        arr = arr2;
        capacity = capacity * 2;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
