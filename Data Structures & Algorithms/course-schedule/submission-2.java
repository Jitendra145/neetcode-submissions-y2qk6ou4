class Solution {
    // topolocal sort Kahn's algorithm
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int [] pre : prerequisites){
            indegrees[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                q.add(i);
            }
        }

        int finish = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            finish++;
            for(int nei : adj.get(node)){
                indegrees[nei]--;
                if(indegrees[nei]==0){
                    q.add(nei);
                }
            }
        }

        return finish==numCourses;
    }
}
