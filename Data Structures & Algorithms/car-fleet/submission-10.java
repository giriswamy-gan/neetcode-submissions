class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<position.length; ++i) {
            list.add(new int[]{position[i], speed[i]});
        }
        list.sort((a, b) -> b[0] - a[0]);
        Stack<Float> st = new Stack<>();
        for(int i=0; i<list.size(); ++i) {
            int[] cur = list.get(i);
            float time = (float) (target - cur[0]) / cur[1];
            if(!st.isEmpty() && time <= st.peek()) {
                continue;
            }
            st.add(time);
        }
        return st.size();
    }
}
