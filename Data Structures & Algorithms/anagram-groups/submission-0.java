class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> check = new HashMap<>();

        for(String str: strs) {
            int[] arr = new int[26];
            for(char c: str.toCharArray()) {
                arr[c - 'a']++;
            }
            String key = Arrays.toString(arr);
            if(!check.containsKey(key)) {
                check.put(key, new ArrayList<>());
            }

            check.get(key).add(str);
        }
        return new ArrayList<>(check.values());
    }
}
