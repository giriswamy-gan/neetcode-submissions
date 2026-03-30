class Solution {
    public boolean isPalindrome(String s) {
        int i;
        int j;
        char[] arr = s.toCharArray();
        for(i = 0,j = s.length() - 1; i<j; ++i, --j) {
            if(i == j) return true;
            while(i<j && !isAlphaNum(arr[i])) ++i;
            while(i<j && !isAlphaNum(arr[j])) --j;
            if(Character.toLowerCase(arr[i]) != Character.toLowerCase(arr[j])) return false;
        }
        return true;
    }

    private boolean isAlphaNum(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
