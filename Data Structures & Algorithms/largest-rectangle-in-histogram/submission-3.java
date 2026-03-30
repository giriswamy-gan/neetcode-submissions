class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();
        for(int i=0; i<heights.length; ++i) {
            int currHeight = heights[i];
            int currIndex = i;
            while(!stack.isEmpty() && currHeight < stack.peek()[0]) {
                int[] oldVal = stack.pop();
                int area = oldVal[0] * (i - oldVal[1]);
                maxArea = Math.max(maxArea, area);
                currIndex = oldVal[1];
            }
            stack.push(new int[]{currHeight, currIndex});
        }
        while(!stack.isEmpty()) {
            int[] oldVal = stack.pop();
            int area = oldVal[0] * (heights.length - oldVal[1]);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}


// stack = 2
// stack = 1
// stack = 5, 1
// stack = 6,5,1
// max area = 10



// loop through heights
// while check if top of stack height is greater than current height
// if greater keep popping and change the index of current number to the popped numbers index
// for the popped number do (current index - popped index) to find width and calculate area and max area
// push the current number onto the stack
// exit the loop
// loop through the stack and keep popping elements and calculate area
