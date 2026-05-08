class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] freq = new int[26];
        for(char task : tasks){
            freq[task-'A']++;
        }

        int maxFreq = Arrays.stream(freq).max().getAsInt();
        int maxOccupyFreq = (maxFreq-1)*(n+1);

        int nMaxFreq = (int)Arrays.stream(freq).filter(c->c==maxFreq).count();

        return Math.max(maxOccupyFreq + nMaxFreq, tasks.length);
    }
}
