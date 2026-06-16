class Solution {
    //brute force O(n^2) O(n)
    public boolean isValid(String s) {
        while(s.contains("()") || s.contains("{}") || s.contains("[]")){
            s = s.replace("()","");
            s = s.replace("{}","");
            s = s.replace("[]","");
        }
        return s.isEmpty();
    }
}
