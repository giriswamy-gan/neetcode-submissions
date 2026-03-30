class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int s : stones) {
            pq.add(s);
        }
        while(pq.size() > 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            if(s1 != s2) {
                pq.add(s1 - s2);
            }
        }
        return pq.size() == 1 ? pq.poll() : 0;
    }
}
