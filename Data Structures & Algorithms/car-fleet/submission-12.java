class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] dist = new int[position.length][2];
        for(int i=0; i<speed.length; ++i) {
            dist[i][0] = position[i];
            dist[i][1] = speed[i];
        }
        Arrays.sort(dist, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> st = new Stack<>();
        for(int[] pair: dist) {
            double time = (double) (target - pair[0]) / pair[1];
            if(!st.isEmpty() && time <= st.peek()) {
                time = st.pop();
            }
            st.add(time);
        }
        return st.size();
    }
}

// [3, 3, 5, 10]
