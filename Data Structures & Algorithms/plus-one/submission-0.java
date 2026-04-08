class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;
        if(digits[digits.length - 1] < 10) return digits;

        List<Integer> res = new ArrayList<>();
        res.add(0);
        int carry = 1;
        for(int i = digits.length - 2; i >= 0; --i) {
            int cur = digits[i] + carry;
            if(cur < 10) {
                carry = 0;
            }
            else {
                cur = 0;
            }
            res.addFirst(cur);
        }
        if(carry == 1) res.addFirst(1);
        return res.stream().mapToInt(i -> i).toArray();
    }
}
