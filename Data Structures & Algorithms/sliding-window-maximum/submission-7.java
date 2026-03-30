class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] res = new int[nums.length - k + 1];
        for(int r=0; r<nums.length; ++r) {
            q.add(new int[]{nums[r], r});
            while(q.peek()[1] < r - k + 1) {
                q.poll();
            }
            if(r + 1 >= k) {
                res[r-k+1] = q.peek()[0];
            }
        }
        return res;
    }
}
