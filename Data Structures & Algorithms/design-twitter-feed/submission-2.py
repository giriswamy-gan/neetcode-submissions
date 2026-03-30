class Twitter:

    def __init__(self):
        self.count = 0
        self.mapTweets = defaultdict(list)
        self.mapFollow = defaultdict(set)

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.mapTweets[userId].append([self.count, tweetId])
        self.count += 1

    def getNewsFeed(self, userId: int) -> List[int]:
        feed = self.mapTweets[userId][:]
        for followeeId in self.mapFollow[userId]:
            feed.extend(self.mapTweets[followeeId])
        
        feed.sort(key=lambda x:-x[0])
        return [tweetId for _, tweetId in feed[:10]]

    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId != followeeId:
            self.mapFollow[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId != followeeId:
            self.mapFollow[followerId].discard(followeeId)
