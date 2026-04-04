class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Stack<Character> stk = new Stack<>();
        for(char ch : s.toCharArray()){
            if(!map.containsKey(ch)){
                stk.push(ch);
            }else{
                if(stk.isEmpty() || stk.pop() != map.get(ch)){
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }
}
