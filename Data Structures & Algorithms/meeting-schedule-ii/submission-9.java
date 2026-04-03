/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(Interval interval : intervals) {
            map.put(interval.start, map.getOrDefault(interval.start, 0) + 1);
            map.put(interval.end, map.getOrDefault(interval.end, 0) - 1);
        }
        int prev = 0;
        int res = 0;
        for(int key : map.keySet()) {
            prev += map.get(key);
            res = Math.max(res, prev);
        }
        return res;
    }
}
