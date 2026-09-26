class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int counter = 1;

        while(!q.isEmpty()){
            counter++;
            int size = q.size();
            for(int i=0;i<size;i++){
                String str = q.poll();
                char[] chArr = str.toCharArray();
                for(int j=0;j<str.length();j++){
                    char orig = chArr[j];
                    for(char c='a';c<='z';c++){
                        chArr[j] = c;
                        String newWord = new String(chArr);
                        if(!set.contains(newWord)){
                            continue;
                        }
                        if(endWord.equals(newWord)){
                            return counter;
                        }                  
                        q.offer(newWord);
                        set.remove(newWord);      
                    }
                    chArr[j] = orig;
                }
            }
        }

        return 0;
    }
}
