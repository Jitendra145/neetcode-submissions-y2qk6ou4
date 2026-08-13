class Solution {
    public boolean isPalindrome(String s) {
        String st = s.toLowerCase();
        int l=0,r=st.length()-1;

        while(l<r){
            if(!Character.isLetterOrDigit(st.charAt(l))){
                l++;
                continue;
            }
            if(!Character.isLetterOrDigit(st.charAt(r))){
                r--;
                continue;
            }
            if(st.charAt(l)!=st.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
