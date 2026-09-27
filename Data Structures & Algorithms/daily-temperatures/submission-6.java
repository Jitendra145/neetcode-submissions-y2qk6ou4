class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            int count = 0;
            int flag = 0;
            for(int j=i+1;j<n;j++){
                count++;
                if(temperatures[i]< temperatures[j]){
                    flag = 1;
                    break;                  
                }                
            }
            if(flag==1)
                res[i] = count;
            else
                res[i] = 0;
        }
        return res;
    }
}
