class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();

        for(int speed=1;speed<=max;speed++){
            long totalTime = 0;
            for(int j=0;j<piles.length;j++){
                totalTime += (piles[j]+speed-1)/speed;
            }
            if(totalTime <= h)
                return speed;
        }
        return max;
    }
}
