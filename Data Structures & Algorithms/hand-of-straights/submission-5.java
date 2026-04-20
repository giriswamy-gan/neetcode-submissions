class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int h : hand) {
            map.put(h, map.getOrDefault(h, 0) + 1);
        }

        for(int count : map.keySet()) {
            while(map.getOrDefault(count - 1, 0) > 0) count--;

            int c = map.get(count);
            while(c > 0) {
                for(int i = count; i < count + groupSize; ++i) {
                    if(!map.containsKey(i) || map.get(i) == 0) {
                        return false;
                    }
                    map.put(i, map.get(i) - 1);
                }
                c--;
            }
        }
        
        return true;
    }
}
