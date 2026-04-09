class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        if(num1.length() < num2.length()) return multiply(num2, num1);
        
        String res = "";
        int zero = 0;
        for(int i = num2.length() - 1; i >= 0; --i) {
            String cur = mult(num2.charAt(i), num1, zero);
            res = add(res, cur);
            zero++;
        }
        return res;
    }

    private String mult(char n1, String n2, int zero) {
        StringBuilder res = new StringBuilder();
        int c1 = n1 - '0';
        int carry = 0;

        for(int i = n2.length() - 1; i >= 0; --i) {
            int c2 = n2.charAt(i) - '0';
            int prod = c1 * c2 + carry;
            res.insert(0, prod % 10);
            carry = prod / 10;
        }
        if (carry > 0) res.insert(0, carry);

        return res.toString() + "0".repeat(zero);
    }

    private String add(String n1, String n2) {
        StringBuilder res = new StringBuilder();
        int carry = 0, i = n1.length() - 1, j = n2.length() - 1;

        while(i >= 0 || j >= 0 || carry > 0) {
            int c1 = i >= 0 ? n1.charAt(i) - '0' : 0;
            int c2 = j >= 0 ? n2.charAt(j) - '0' : 0;
            int sum = c1 + c2 + carry;
            res.insert(0, sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }

        return res.toString();
    }
}
