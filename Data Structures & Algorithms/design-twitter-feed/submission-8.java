class Twitter {
    private int time;
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<Pair<Integer, Integer>>> tweetMap;

    public Twitter() {
        time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Pair(time, tweetId));
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Set<Integer> followers = followMap.containsKey(userId) ? followMap.get(userId) : new HashSet<>();
        followers.add(userId);
        followers.forEach((user) -> {
            List<Pair<Integer, Integer>> curTweets = tweetMap.get(user);
            if(curTweets != null) {
                Pair<Integer, Integer> tweet = curTweets.get(curTweets.size() - 1);
                pq.add(new int[]{tweet.getKey(), tweet.getValue(), user, curTweets.size() - 1});
            }
        });

        List<Integer> feed = new ArrayList<>();
        int idx = 0;
        while(!pq.isEmpty() && idx < 10) {
            int[] tweet = pq.poll();
            feed.add(tweet[1]);
            idx++;
            if(tweet[3] > 0) {
                Pair<Integer, Integer> prevTweet = tweetMap.get(tweet[2]).get(tweet[3] - 1);
                pq.add(new int[]{prevTweet.getKey(), prevTweet.getValue(), tweet[2], tweet[3] - 1});
            }
        }
        return feed;
    }
    
    public void follow(int followerId, int k) {
        followMap.computeIfAbsent(followerId, key -> new HashSet<>()).add(k);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId)) {
            return;
        }
        followMap.get(followerId).remove(followeeId);
        if(followMap.get(followerId).size() == 0) {
            followMap.remove(followerId);
        }
    }
}

private static class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }
}
