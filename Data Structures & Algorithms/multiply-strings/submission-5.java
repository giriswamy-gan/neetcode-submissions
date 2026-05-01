class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        for(int i = 0; i < num1.length(); ++i) {
            for(int j = 0; j < num2.length(); ++j) {
                int digit = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + res[i + j];
                int carry = digit / 10;
                digit = digit % 10;
                res[i + j] = digit;
                res[i + j + 1] += carry;
            }
        }

        int idx = res.length - 1;
        while(idx > 0 && res[idx] == 0) {
            idx--;
        }

        StringBuilder output = new StringBuilder();
        for(int i = 0; i <= idx; ++i) {
            output.insert(0, res[i]);
        }
        return output.toString();
    }
}
