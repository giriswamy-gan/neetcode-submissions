class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] charArray1 = s.toCharArray();
        Arrays.sort(charArray1);
        String s1 = new String(charArray1);
        char[] charArray2 = t.toCharArray();
        Arrays.sort(charArray2);
        String s2 = new String(charArray2);
        for(int i=0; i<s1.length(); ++i) {
            if(s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
