class Solution {
    //O(nlogn) and O(n)
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int [][] cars = new int[n][2];
        for(int i=0;i<n;i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars,Comparator.comparing(c->c[0]));
        Stack<Double> stk = new Stack<>();
        for(int i=n-1;i>=0;i--){
            double time = (double) (target-cars[i][0])/cars[i][1];
            stk.push(time);
            if(stk.size() >=2 && stk.peek() <= stk.get(stk.size()-2)){
                stk.pop();
            }
        }
        return stk.size();
    }
}
