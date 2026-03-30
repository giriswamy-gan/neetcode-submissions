class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n: nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        freq.forEach((key, value) -> {
            q.add(new int[]{value, key});
            if(q.size() > k) {
                q.remove(q.peek());
            }
        });

        int[] res = new int[k];
        Iterator<int[]> it = q.iterator();
        int i = 0;
        while(it.hasNext()) {
            res[i] = it.next()[1];
            i++;
        }
        return res;
    }
}
