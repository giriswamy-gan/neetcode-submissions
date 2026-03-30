class KthLargest {
    private int k;
    private PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue();
        for(int n : nums) {
            pq.add(n);
            if(pq.size() > this.k) {
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > this.k) {
            pq.poll();
        }
        return pq.peek();
    }
}
