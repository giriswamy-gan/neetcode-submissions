class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();
        int l = 0;
        int last = 0;
        for(int r = 0; r < s.length(); ++r) {
            char cur = s.charAt(r);
            last = Math.max(last, map.get(cur));
            if(last == r) {
                res.add(r - l + 1);
                l = r + 1;
            }
        }
        return res;
    }
}
