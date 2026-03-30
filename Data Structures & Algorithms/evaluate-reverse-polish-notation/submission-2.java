class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String str : tokens) {
            if(str.equals("+")) {
                Integer i1 = st.pop();
                Integer i2 = st.pop();
                st.add(i1 + i2);
            }
            else if(str.equals("-")) {
                Integer i1 = st.pop();
                Integer i2 = st.pop();
                st.add(i2 - i1);
            }
            else if(str.equals("*")) {
                Integer i1 = st.pop();
                Integer i2 = st.pop();
                st.add(i1 * i2);
            }
            else if(str.equals("/")) {
                Integer i1 = st.pop();
                Integer i2 = st.pop();
                st.add(i2 / i1);
            }
            else {
                st.add(Integer.parseInt(str));
            }
        }
        return st.peek();
    }
}
