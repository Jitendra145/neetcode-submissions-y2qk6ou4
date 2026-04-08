class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int max = Arrays.stream(piles).max().getAsInt();
        int res = 0;

        while(low<=max){
            int mid = low+ (max-low)/2;
            if(canFinish(piles,mid,h)){
                max = mid-1;
                res = mid;
            }else{
                low = mid+1;
            }
        }
        return res;
    }

    private boolean canFinish(int[] piles, int mid, int h){
        long totalTimes =0;
        for(int i=0;i<piles.length;i++){
            totalTimes += (piles[i]+mid-1)/mid;
        }
        return totalTimes <= h;
    }
}
