class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        int r = 0;

        while(r < n) {
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[r]) {
                dq.removeLast();
            }
            dq.addLast(r);

            if(dq.getFirst() < r - k + 1) {
                dq.removeFirst();
            }

            if(r + 1 >= k) {
                res[r-k+1] = nums[dq.getFirst()];
            }
            ++r;
        }
        return res;
    }
}
