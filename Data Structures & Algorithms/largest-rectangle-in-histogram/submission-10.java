class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<int[]> st = new Stack<>();
        int[] ltr = new int[n];
        int[] rtl = new int[n];
        
        st.add(new int[]{heights[0], 0});
        for(int i=1; i<n; ++i) {
            while(!st.isEmpty() && heights[i] < st.peek()[0]) {
                int[] pair = st.pop();
                ltr[pair[1]] = i - pair[1] - 1;
            }
            st.add(new int[]{heights[i], i});
        }
        while(!st.isEmpty()) {
            int[] pair = st.pop();
            ltr[pair[1]] = n - pair[1] - 1;
        }
        
        st = new Stack<>();
        st.add(new int[]{heights[n - 1], n - 1});
        for(int i=n-2; i>=0; --i) {
            while(!st.isEmpty() && heights[i] < st.peek()[0]) {
                int[] pair = st.pop();
                rtl[pair[1]] = pair[1] - i - 1; 
            }
            st.add(new int[]{heights[i], i});
        }
        while(!st.isEmpty()) {
            int[] pair = st.pop();
            rtl[pair[1]] = pair[1];
        }

        // ltr = [0, 4, 0, 2, 1, 0]
        // rtl = [0, 1, 0, 1, 2, 0]
        //       [5, 4, 0, 1, 2, 0]
        // System.out.println(Arrays.toString(ltr));
        // System.out.println(Arrays.toString(rtl));

        int res = 0;
        for(int i=0; i<n; ++i) {
            res = Math.max(res, (ltr[i] + rtl[i] + 1) * heights[i]);
        }

        return res;
    }
}
