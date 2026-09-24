class Solution {
    //cycle neet code
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> prereq = new HashMap<>();
        for(int [] pre : prerequisites){
            prereq.putIfAbsent(pre[0],new ArrayList<>());
            prereq.get(pre[0]).add(pre[1]);
        }

        Set<Integer> visit = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        List<Integer> output = new ArrayList<>();

        for(int course=0;course<numCourses;course++){
            if(!dfs(course,prereq,visit,cycle,output)){
                return new int[0];
            }
        }
        int[] res = new int[output.size()];
        for(int i=0;i<output.size();i++){
            res[i] = output.get(i);
        }
        return res;
    }

    private boolean dfs(int course,Map<Integer,List<Integer>> map,Set<Integer> visit,Set<Integer> cycle,List<Integer> res){
        if(cycle.contains(course)){
            return false;
        }
        if(visit.contains(course)){
            return true;
        }

        cycle.add(course);
        for(int pre:map.getOrDefault(course,Collections.emptyList())){
            if(!dfs(pre,map,visit,cycle,res)){
                return false;
            }
        }
        cycle.remove(course);
        visit.add(course);
        res.add(course);
        return true;
    }
}
