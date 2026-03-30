class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder("");
        for(String str: strs) {
            res.append(str.length()).append("#").append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        for(int i=0; i<str.length(); ++i) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }
            int size = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j += size;
            res.add(str.substring(i, j + 1));
            i = j;
        }
        return res;
    }
}

// 5#Hello5#World
