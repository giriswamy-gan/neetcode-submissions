class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> mapList = new HashMap<>();
        for(String str: strs) {
        HashMap<Character, Integer> map = new HashMap<>();
        int[] check = new int[26];

        for(char ch: str.toCharArray()) {
            check[ch - 'a']++;
        }
        
        StringBuilder keyBuilder = new StringBuilder();
        for(int i: check) {
            keyBuilder.append(i).append("#");
        }
        String key = new String(keyBuilder);

        List<String> temp = mapList.getOrDefault(key, new ArrayList<>());
        temp.add(str);
        mapList.put(key, temp);
        }
        for(Map.Entry<String, List<String>> entry : mapList.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
