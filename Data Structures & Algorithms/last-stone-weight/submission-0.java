class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int n: stones) {
            q.offer(n);
        }
        while(!q.isEmpty() && q.size() > 1) {
            int s1 = q.poll();
            int s2 = q.poll();
            if(s1 == s2) {
                continue;
            }
            else if(s1 > s2) {
                q.offer(s1-s2);
            }
            else {
                q.offer(s2-s1);
            }
        }
        if(q.isEmpty()) return 0;
        else return q.peek();
    }
}
