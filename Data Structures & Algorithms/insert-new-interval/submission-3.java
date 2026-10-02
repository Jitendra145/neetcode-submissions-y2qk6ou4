class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for(int[] interval : intervals){
            list.add(interval);
        }
        list.add(newInterval);
        list.sort((a,b)->a[0]-b[0]);
        List<int[]> merged = new ArrayList<>();

        for(int[] interval : list){
            if(merged.isEmpty() || merged.get(merged.size()-1)[1] < interval[0]){
                merged.add(interval);
            }else{
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1],interval[1]);
            }
        }

        return merged.toArray(int[][]::new);
    }
}
