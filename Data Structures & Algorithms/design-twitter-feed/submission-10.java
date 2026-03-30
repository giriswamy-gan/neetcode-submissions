class Twitter {
    Map<Integer, Set<Integer>> followerMap;
    Map<Integer, List<int[]>> tweetMap;
    int time;

    public Twitter() {
        followerMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{tweetId, time});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        Set<Integer> followeeSet = followerMap.getOrDefault(userId, new HashSet<>());
        followeeSet.add(userId);
        followeeSet.forEach((user) -> {
            if(tweetMap.get(user) != null && tweetMap.get(user).size() > 0) {
                List<int[]> tweetList = tweetMap.get(user);
                int idx = tweetList.size() - 1;
                int[] tweet = tweetList.get(idx);
                int tweetId = tweet[0];
                int time = tweet[1];
                pq.add(new int[]{time, idx, tweetId, user});
            }
        });

        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty() && res.size() < 10) {
            int[] tweets = pq.poll();
            res.add(tweets[2]);
            int idx = tweets[1];
            if(idx > 0) {
                int[] tweetPair = tweetMap.get(tweets[3]).get(idx-1);
                pq.add(new int[]{tweetPair[1], idx-1, tweetPair[0], tweets[3]});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followerMap.putIfAbsent(followerId, new HashSet<>());
        followerMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!followerMap.containsKey(followerId)) {
            return;
        }
        Set<Integer> followeeSet = followerMap.get(followerId);
        followeeSet.remove(followeeId);
    }
}
