class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int h : hand) {
            count.put(h, count.getOrDefault(h, 0) + 1);
        }

        for(int num : hand) {
            int start = num;
            while(count.getOrDefault(start - 1, 0) > 0) start--;
            while(start <= num) {
                while(count.getOrDefault(start, 0) > 0) {
                    for(int i = start; i < start + groupSize; ++i) {
                        if(count.getOrDefault(i, 0) == 0) return false;
                        count.put(i, count.get(i) - 1);
                    }
                }
                start++;
            }
        }
        
        return true;
    }
}
