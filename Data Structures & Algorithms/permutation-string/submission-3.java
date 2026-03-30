class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        String sortedS1 = new String(c1);
        for(int i=0; i<s2.length(); ++i) {
            for(int j=i; j<s2.length(); ++j) {
                char[] c2 = s2.substring(i,j + 1).toCharArray();
                Arrays.sort(c2);
                String sortedS2 = new String(c2);
                if(sortedS1.equals(sortedS2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
