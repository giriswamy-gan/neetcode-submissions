class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            int[] count = new int[26];
            for(int i=0; i<str.length(); ++i) {
                count[str.charAt(i) - 'a']++;
            }
            String s = Arrays.toString(count);
            map.putIfAbsent(s, new ArrayList<>());
            List<String> temp = map.get(s);
            temp.add(str);
            map.put(s, temp);
        }
        return new ArrayList<>(map.values());
    }
}
