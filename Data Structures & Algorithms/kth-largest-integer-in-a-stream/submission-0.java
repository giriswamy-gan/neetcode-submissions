class KthLargest {
    private PriorityQueue<Integer> q;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.q = new PriorityQueue<>();
        this.k = k;
        for(int n: nums) {
            q.offer(n);
            if(q.size() > k) {
                q.poll();
            }
        }
    }
    
    public int add(int val) {
        q.offer(val);
        if(q.size() > k) {
            q.poll();
        }
        return q.peek();
    }
}
