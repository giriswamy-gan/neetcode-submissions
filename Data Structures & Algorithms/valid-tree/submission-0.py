class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        treeMap = defaultdict(list)
        for e1, e2 in edges:
            treeMap[e1].append(e2)
            treeMap[e2].append(e1)

        visit = set()
        def dfs(curr, prev):
            if curr in visit:
                return False
            visit.add(curr)
            for nei in treeMap[curr]:
                if nei == prev:
                    continue
                if not dfs(nei, curr):
                    return False
            return True
            
        return dfs(0, -1) and len(visit) == n
