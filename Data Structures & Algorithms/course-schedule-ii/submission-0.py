class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        preMap = {c: [] for c in range(numCourses)}
        for crs, pre in prerequisites:
            preMap[crs].append(pre)
        res = []
        cycle, visit = set(), set()

        def dfs(c):
            if c in cycle:
                return False
            if c in visit:
                return True
            cycle.add(c)
            for crs in preMap[c]:
                if not dfs(crs):
                    return False
            cycle.remove(c)
            visit.add(c)
            res.append(c)
            return True

        for c in range(numCourses):
            if not dfs(c):
                return []
        return res
