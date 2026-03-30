class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder("");
        for(String str: strs) {
            int size = str.toCharArray().length;
            encoded.append(size).append("!").append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int n = str.length();
        int i = 0;
        while(i < n) {
            int j = i;
            while(str.charAt(j) != '!') {
                j++;
            }
            int size = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + size;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }
}

// 10!!@#$%^&*()
// j = 2
// size = 10
// i = 3
// j = 13

