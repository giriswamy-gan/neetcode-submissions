class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i=0; i<temperatures.length; ++i) {
            while(!st.isEmpty() && temperatures[i] > st.peek()[0]) {
                int idx = st.pop()[1];
                res[idx] = i - idx;
            }
            st.add(new int[]{temperatures[i], i});
        }
        return res;
    }
}
