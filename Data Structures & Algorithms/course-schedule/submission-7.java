class Solution {
    Map<Integer,List<Integer>> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList<>());
        }    
        for(int[] pre : prerequisites){
            map.get(pre[0]).add(pre[1]);
        }

        for(int i=0;i<numCourses;i++){
            if(!dfs(i)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int crs){
        if(set.contains(crs)){
            return false;
        }
        if(map.get(crs).isEmpty()){
            return true;
        }
        set.add(crs);
        for(int c : map.get(crs)){
            if(!dfs(c)){
                return false;
            }
        }
        set.remove(crs);
        map.put(crs,new ArrayList<>());
        return true;
    }
}
