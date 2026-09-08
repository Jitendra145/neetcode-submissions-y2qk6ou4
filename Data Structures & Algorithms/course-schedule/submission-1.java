class Solution {
    private Map<Integer,List<Integer>> map = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList<>());
        }
        //build graph
        for(int[] pre : prerequisites){
            map.get(pre[0]).add(pre[1]);
        }
        //for each course run dfs
        for(int c=0;c<numCourses;c++){
            if(!dfs(c)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course){
        if(visited.contains(course)){
            return false;
        }

        if(map.get(course).isEmpty()){
            return true;
        }

        visited.add(course);

        for(int c : map.get(course)){
            if(!dfs(c)){
                return false;
            }
        }

        visited.remove(course);
        map.put(course,new ArrayList<>());
        return true;
    }
}
