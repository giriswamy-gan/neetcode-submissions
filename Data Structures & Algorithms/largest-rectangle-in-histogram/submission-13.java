class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> st = new Stack<>();
        int res = 0;
        for(int i=0; i<heights.length; ++i) {
            int idx = i;
            while(!st.isEmpty() && st.peek()[0] > heights[i]) {
                int[] popped = st.pop();
                idx = popped[1];
                res = Math.max(res, popped[0] * (i - popped[1]));
            }
            st.add(new int[]{heights[i], idx});
        }
        while(!st.isEmpty()) {
            int[] popped = st.pop();
            res = Math.max(res, popped[0] * (heights.length - popped[1]));
        }
        return res;
    }
}
