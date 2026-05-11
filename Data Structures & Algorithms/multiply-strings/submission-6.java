class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();
        int[] res = new int[n1.length() + n2.length()];

        for(int i = 0; i < n1.length(); ++i) {
            for(int j = 0; j < n2.length(); ++j) {
                res[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
                res[i + j + 1] += res[i + j] / 10;
                res[i + j] = res[i + j] % 10;
            }
        }

        int j = res.length - 1;
        while(res[j] == 0) {
            j--;
        }

        StringBuilder output = new StringBuilder();
        for(int i = j; i >= 0; --i) {
            output.append(res[i]);
        }

        return output.toString();
    }
}
