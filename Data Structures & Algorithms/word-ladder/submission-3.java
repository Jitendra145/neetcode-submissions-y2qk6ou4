class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int count = 1;

        while(!q.isEmpty()){
            count++;
            int size = q.size();
            for(int i=0;i<size;i++){
                String word = q.poll();
                char[] arr = word.toCharArray();
                for(int j=0;j<arr.length;j++){
                    char orig = arr[j];
                    for(char start='a';start<='z';start++){
                        arr[j] = start;
                        String newWord = new String(arr);
                        if(!set.contains(newWord)){
                            continue;
                        }
                        if(newWord.equals(endWord)){
                            return count;
                        }
                        q.offer(newWord);
                        set.remove(newWord);
                    }
                    arr[j] = orig;
                }
            }
        }

        return 0;
    }
}
