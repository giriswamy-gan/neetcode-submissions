class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> cars = new ArrayList<>();
        for(int i=0; i<position.length; ++i) {
            cars.add(new int[2]);
            cars.get(i)[0] = position[i];
            cars.get(i)[1] = speed[i];
        }
        Collections.sort(cars, (a, b) -> b[0] - a[0]);
        Stack<Double> st = new Stack<>();
        for(int i=0; i<cars.size(); ++i) {
            int dist = target - cars.get(i)[0];
            int spe = cars.get(i)[1];
            double time = (double) dist/spe;
            if(!st.isEmpty() && st.peek() >= time) {
                continue;
            }
            st.add(time);
        }
        return st.size();
    }
}

// 3 / 1 = 1
// 6 / 2 = 3
// 9 / 2 = 4.5
// 10 / 1 = 1
//          2
