class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int h : hand) {
            map.put(h, map.getOrDefault(h, 0) + 1);
        }

        for(int count : map.keySet()) {
            int start = count;
            while(map.getOrDefault(count - 1, 0) > 0) count--;

            while(start <= count) {
                while(map.getOrDefault(count, 0) > 0) {
                    for(int i = count; i < count + groupSize; ++i) {
                        if(!map.containsKey(i) || map.get(i) == 0) {
                            return false;
                        }
                        map.put(i, map.get(i) - 1);
                    }
                }
                start++;
            }
        }
        
        return true;
    }
}
