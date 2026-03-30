class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int r=0, l=0;
        while(r < nums.length) {
            while(!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.pollLast();
            }
            q.addLast(r);
            if(l > q.getFirst()) {
                q.pollFirst();
            }
            if(r+1 >= k) {
                res[l] = nums[q.getFirst()];
                ++l;
            }
            ++r;
        }
        return res;
    }
}


// while(!deque empty and nums[deque.getLast()] < nums[r]) {
    // pop the right elements
// }
// add element to deque
// if(l > deque.getFirst()) {
    // pop the first element from deque
// }
// if(r+1 >= k) {
    // output[l] = nums[deque.getFirst()]
    // ++l;
// }
// ++r