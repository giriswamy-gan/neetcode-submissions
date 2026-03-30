class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(Map.Entry<Character, Integer> entry : freq.entrySet()) {
            maxHeap.add(entry.getValue());
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
