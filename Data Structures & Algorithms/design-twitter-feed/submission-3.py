class Twitter:

    def __init__(self):
        self.count = 0
        self.mapTweet = defaultdict(list)
        self.mapFollow = defaultdict(set)

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.mapTweet[userId].append([self.count, tweetId])
        self.count -= 1

    def getNewsFeed(self, userId: int) -> List[int]:
        feed = []
        minHeap = []

        self.mapFollow[userId].add(userId)
        for followeeId in self.mapFollow[userId]:
            if followeeId in self.mapTweet:
                index = len(self.mapTweet[followeeId]) - 1
                count, tweetId = self.mapTweet[followeeId][index]
                heapq.heappush(minHeap, [count, tweetId, followeeId, index-1])

        while minHeap and len(feed) < 10:
            count, tweetId, followeeId, index = heapq.heappop(minHeap)
            feed.append(tweetId)
            if index >= 0:
                count, tweetId = self.mapTweet[followeeId][index]
                heapq.heappush(minHeap, [count, tweetId, followeeId, index-1])
        
        return feed

    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId != followeeId:
            self.mapFollow[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId != followeeId:
            self.mapFollow[followerId].discard(followeeId)
