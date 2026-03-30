class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int l = 0;
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0; i<nums.length; ++i) {
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if(l > deque.getFirst()) {
                deque.removeFirst();
            }
            if((i + 1) >= k) {
                res[l] = nums[deque.getFirst()];
                ++l;
            }
        }
        return res;
    }
}

// if front of deque < curr number
// while front of deque < curr number then keep popping from front of deque
// if index of front of deque < i - k then pop the start of deque
// push it to the rear of deque
// if(r + 1) >= k then start adding front of deque to res
