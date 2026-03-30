class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task : tasks) {
            freq[task - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<freq.length; ++i) {
            if(freq[i] > 0) {
                maxHeap.add(freq[i]);
            }
        }
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        while(!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;
            if(maxHeap.isEmpty()) {
                time = q.peek()[1];
            } else {
                int cur = maxHeap.poll() - 1;
                if(cur > 0) {
                    q.add(new int[]{cur, time + n});
                }
            }
            if(!q.isEmpty() && time == q.peek()[1]) {
                maxHeap.add(q.poll()[0]);
            }
        }
        return time;
    }
}
