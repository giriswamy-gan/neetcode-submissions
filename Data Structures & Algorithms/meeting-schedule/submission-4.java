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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.isEmpty()) return true;
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        int prevEnd = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); ++i) {
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            if(start < prevEnd) {
                return false;
            }
            prevEnd = end;
        }
        return true;
    }
}
