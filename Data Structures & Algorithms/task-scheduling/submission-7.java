class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task : tasks) {
            freq[task - 'A']++;
        }
        Arrays.sort(freq);
        int maxf = freq[25] - 1;
        int idles = n * maxf;
        for(int i = 24; i >= 0; --i) {
            idles -= Math.min(maxf, freq[i]);
        }
        return Math.max(idles, 0) + tasks.length;
    }
}
