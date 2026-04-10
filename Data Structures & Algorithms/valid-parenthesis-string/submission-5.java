class Solution {
    public boolean checkValidString(String s) {
        List<Integer> left = new ArrayList<>();
        List<Integer> star = new ArrayList<>();
        for(int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if(ch == '(') {
                left.add(i);
            }
            else if(ch == '*') {
                star.add(i);
            }
            else {
                if(!left.isEmpty()) {
                    left.remove(left.size() - 1);
                }
                else if(!star.isEmpty()) {
                    star.remove(star.size() - 1);
                }
                else {
                    return false;
                }
            }
        }
        while(!left.isEmpty()) {
            if(star.isEmpty()) {
                return false;
            }
            if(left.get(left.size() - 1) > star.get(star.size() - 1)) {
                return false;
            }
            left.remove(left.size() - 1);
            star.remove(star.size() - 1);
        }
        return true;
    }
}
