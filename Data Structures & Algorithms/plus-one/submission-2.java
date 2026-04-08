class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;
        if(digits[digits.length - 1] < 10) return digits;

        digits[digits.length - 1] = 0;
        boolean carry = true;
        for(int i = digits.length - 2; i >= 0; --i) {
            if(carry) {
                if(digits[i] == 9) {
                    digits[i] = 0;
                }
                else {
                    digits[i]++;
                    carry = false;
                }
            }
        }
        if(carry) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
