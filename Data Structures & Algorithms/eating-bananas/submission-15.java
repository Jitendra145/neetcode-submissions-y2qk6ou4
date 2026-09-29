class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=0;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = 0;

        while(l<=r){
            int mid = (l+r)/2;
            if(canFinish(piles,mid,h)){
                res = mid;
                r = mid-1;
            }else{
                l=mid+1;
            }
        }
        return res;
    }

    private boolean canFinish(int[] piles,int mid,int h){
        int total =0;
        for(int i=0;i<piles.length;i++){
            total += Math.ceil((double)piles[i]/mid);
        }
        return total<=h;
    }
}
