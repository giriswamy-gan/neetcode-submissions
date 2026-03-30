class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> check = new HashMap<>();
        for(String str: strs) {
            int[] arr = new int[26];
            for(char c: str.toCharArray()) {
                arr[c - 'a']++;
            }
            String s = Arrays.toString(arr);
            check.putIfAbsent(s, new ArrayList<>());
            check.get(s).add(str);
        }
        return new ArrayList<>(check.values());
    }
}
