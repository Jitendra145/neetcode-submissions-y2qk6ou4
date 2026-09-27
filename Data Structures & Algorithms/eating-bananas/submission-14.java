class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int l = 1;
       int r = Arrays.stream(piles).max().getAsInt();
       int res =0;

       while(l<=r){
        int mid = (l+r)/2;
        if(canFinish(piles,h,mid)){
            r = mid-1;
            res = mid;
        }else{
            l=mid+1;
        }
       }
       return res;
    }

    private boolean canFinish(int[] piles, int h, int speed){
        int totalTimes = 0;
        for(int i=0;i<piles.length;i++){
            totalTimes += Math.ceil((double)piles[i]/speed);
        }
        return totalTimes <=h;
    }
}
