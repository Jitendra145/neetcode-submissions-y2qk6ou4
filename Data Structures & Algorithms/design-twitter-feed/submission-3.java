class Twitter {
    private Map<Integer,List<Integer>> userTweetMap;
    private Map<Integer,Set<Integer>> userFollowingMap;
    private Map<Integer,Integer> timestampMap;
    private int timestamp;
    
    public Twitter() {
        userTweetMap = new HashMap<>();
        userFollowingMap = new HashMap<>();
        timestampMap = new HashMap<>();
        timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        userTweetMap.computeIfAbsent(userId,k-> new ArrayList<>()).add(tweetId);
        timestampMap.put(tweetId,timestamp++);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followers = userFollowingMap.getOrDefault(userId,new HashSet<>());
        Set<Integer> relevantUsers = new HashSet<>(followers);
        relevantUsers.add(userId);

        Queue<Integer> maxHeap = new PriorityQueue<>((tweet1,tweet2)->{
            return timestampMap.get(tweet2)-timestampMap.get(tweet1);
        });

        for(int user : relevantUsers){
            List<Integer> tweets = userTweetMap.get(user);
           
            if(tweets !=null && !tweets.isEmpty()){
                 int maxSize = Math.min(10, tweets.size());
                for(int i=tweets.size()-1;i>=tweets.size()-maxSize;i--){
                    maxHeap.offer(tweets.get(i));
                }
            }
        }

        List<Integer> feed = new ArrayList<>();
        while(!maxHeap.isEmpty() && feed.size()<10){
            feed.add(maxHeap.poll());
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        userFollowingMap.computeIfAbsent(followerId,k->new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        userFollowingMap.computeIfAbsent(followerId,k->new HashSet<>()).remove(followeeId);
    }
}
