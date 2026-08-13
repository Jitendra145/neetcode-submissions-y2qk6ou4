class Solution {
    public boolean isPalindrome(String s) {
       // String str = s.toLowerCase();
        int l=0, r=s.length()-1;

        while(l<r){
            if(!Character.isLetterOrDigit(s.charAt(l))){
                l++;
               // continue;
            }
            else if(!Character.isLetterOrDigit(s.charAt(r))){
                r--;
                //continue;
            }
            else if(Character.toLowerCase(s.charAt(l))!= Character.toLowerCase(s.charAt(r))){
                return false;
            }else{
                l++;
                r--;
            }
        }
        return true;
    }
}
