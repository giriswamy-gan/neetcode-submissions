class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        for(int i=0; i<nums.length; ++i) {
            while(!q.isEmpty() && nums[q.getLast()] < nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
            if(!q.isEmpty() && q.getFirst() < (i - k + 1)) {
                q.removeFirst();
            }
            if(i + 1 >= k) {
                res[idx++] = nums[q.getFirst()];
            }
        }
        return res;
    }
}
