class Solution {

    public String encode(List<String> strs) {
        StringBuilder ans = new StringBuilder();
        for(String str: strs) {
            ans.append(str.length()).append("#").append(str);
        }
        return ans.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int j = 0, i = 0;
        while(i<str.length()) {
            j = i;
            while(str.charAt(j) != '#') {
                ++j;
            }
            int length = Integer.valueOf(str.substring(i, j));
            i = 1 + j + length;
            ans.add(str.substring(j + 1, i));
        }
        return ans;
    }
}
