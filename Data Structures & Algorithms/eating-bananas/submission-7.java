class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();

        for(int i=1;i<=max;i++){
            long total = 0;
            for(int j=0;j<piles.length;j++){
                total += (piles[j]+i-1)/i;
            }
            if(total<=h){
                return i;
            }
        }
        return max;
    }
}
