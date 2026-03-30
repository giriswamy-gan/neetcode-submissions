class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int h : hand) {
            freq.put(h, freq.getOrDefault(h, 0) + 1);
        }

        Arrays.sort(hand);
        for(int n : hand) {
            if(freq.get(n) > 0) {
                for(int i = n; i < n + groupSize; ++i) {
                    if(freq.getOrDefault(i, 0) == 0) return false;
                    freq.put(i, freq.get(i) - 1);
                }
            }
        }

        return true;
    }
}
