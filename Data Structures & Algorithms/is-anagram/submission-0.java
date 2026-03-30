class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] og = s.toCharArray();
        char[] notog = t.toCharArray();
        Arrays.sort(og);
        Arrays.sort(notog);
        for(int i=0; i<s.length(); ++i) {
            if(og[i] != notog[i]) {
                return false;
            }
        }
        return true;
    }
}
