class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<int[]> st = new Stack<>();

        for(int i=0; i<n; ++i) {
            int[] curPair = new int[]{i, heights[i]}; // 0 - idx 1 - heights[i]
            while(!st.isEmpty() && heights[i] < st.peek()[1]) {
                int[] popPair = st.pop();
                curPair[0] = popPair[0];
                maxArea = Math.max(maxArea, (i - popPair[0]) * popPair[1]);
            }
            st.push(curPair);
        }

        while(!st.isEmpty()) {
            int[] pair = st.pop();
            maxArea = Math.max(maxArea, (n - pair[0]) * pair[1]);
        }
        return maxArea;
    }
}
