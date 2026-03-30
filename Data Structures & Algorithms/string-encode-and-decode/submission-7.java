class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String str : strs) {
            res.append(str + "?!");
        }
        System.out.println(res.toString());
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        String resString = "";
        char[] charArr = str.toCharArray();
        for(int i = 0; i < charArr.length; ++i) {
            if(charArr[i] == '?' && charArr[i+1] == '!') {
                res.add(resString);
                resString = "";
                i = i+1;
                continue;
            }
            resString = resString + charArr[i];
        }
        return res;
    }
}
