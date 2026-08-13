class Solution {
    public boolean isPalindrome(String str) {
       // String str = s.toLowerCase();
        int l=0, r=str.length()-1;

        while(l<r){
            if(!Character.isLetterOrDigit(str.charAt(l))){
                l++;
                continue;
            }
            if(!Character.isLetterOrDigit(str.charAt(r))){
                r--;
                continue;
            }
            if(Character.toLowerCase(str.charAt(l))!= Character.toLowerCase(str.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
