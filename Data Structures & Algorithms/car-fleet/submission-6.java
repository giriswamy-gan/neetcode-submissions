class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<position.length; ++i) {
            map.put(position[i], speed[i]);
        }
        ArrayList<Integer> sortedList = new ArrayList<>(map.keySet());
        Collections.sort(sortedList, Collections.reverseOrder());
        Stack<Double> stack = new Stack<>();
        double initialTime = (double) Math.ceil((target - sortedList.get(0)) / map.get(sortedList.get(0)));
        stack.push(initialTime);
        for(int i=1; i<sortedList.size(); ++i) {
            double time = (double) (target - sortedList.get(i)) / map.get(sortedList.get(i));
            if(time > stack.peek()) {
                stack.push(time);
            }
        }
        return stack.size();
    }
}

// [8,3,7,4,6,5]
// [8,7,6,5,4,3]
// [4,4,4,4,4,4]



// sort based on position in descending order
// time = (10 - 4) / 2
// stack 
// if time1 >= time2 skip it otherwise push it to the stack