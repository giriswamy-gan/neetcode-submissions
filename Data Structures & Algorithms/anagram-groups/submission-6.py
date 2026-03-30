class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = defaultdict(list)
        for str in strs:
            freq = [0] * 26
            for i in range(len(str)):
                freq[ord(str[i]) - ord("a")] += 1
            res[tuple(freq)].append(str)
        return list(res.values())
