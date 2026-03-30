class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i=0; i<temperatures.length; ++i) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                // System.out.println("popping: " + index);
                res[index] = i - index;
            }
            stack.push(i);
            // System.out.println("pushing: " + i);
        }
        while(!stack.isEmpty()) {
            int index = stack.pop();
            res[index] = 0;
        }
        return res;
    }
}


// check if top of stack is less than current number
// if it is, then pop it till it is no longer greater, compute the difference and store the difference
// in the corresponding index in the res array
// push the current number to the stack
// once we exit the loop, use another loop to populate the remaining elements with 0
