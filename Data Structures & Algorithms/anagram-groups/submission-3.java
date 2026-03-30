class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> check = new HashMap<>();
        for(String str: strs) {
            char[] tempArray = str.toCharArray();
            Arrays.sort(tempArray);
            String s = Arrays.toString(tempArray);
            check.putIfAbsent(s, new ArrayList<>());
            check.get(s).add(str);
        }
        return new ArrayList<>(check.values());
    }
}
