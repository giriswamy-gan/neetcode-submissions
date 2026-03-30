class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char task : tasks) {
            count[task - 'A']++;
        }
        Arrays.sort(count);

        int maxf = count[25];
        int idle = (maxf - 1) * n;
        for(int i = 24; i >= 0; --i) {
            idle -= Math.min(maxf - 1, count[i]);
        }

        return Math.max(0, idle) + tasks.length;
    }
}

// [A, A, A, B, B, B, C, C, D, D, E, E]
// A -> B C D -> A -> B C D -> A -> E N N N -> E
