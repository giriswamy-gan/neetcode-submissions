class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String res = "0";
        for(int i = 0; i < num1.length(); ++i) {
            String cur = mult(num1.charAt(i), num2);
            for(int j = 0; j < num1.length() - 1 - i; ++j) cur += "0";
            res = add(res, cur);
        }
        return res;
    }

    private String mult(char n1, String n2) {
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
        return res.toString();
    }

    private String add(String n1, String n2) {
        if(n1.length() < n2.length()) {
            String tmp = n1;
            n1 = n2;
            n2 = tmp;
        }
        while(n1.length() != n2.length()) {
            n2 = "0" + n2;
        }
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for(int i = n2.length() - 1; i >= 0; --i) {
            int sum = (n1.charAt(i) - '0') + (n2.charAt(i) - '0') + carry;
            carry = sum / 10;
            sum = sum % 10;
            res.insert(0, sum);
        }
        if (carry > 0) res.insert(0, carry);
        return res.toString();
    }
}
