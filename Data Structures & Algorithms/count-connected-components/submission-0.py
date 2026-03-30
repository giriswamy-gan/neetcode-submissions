class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        graph = defaultdict(list)
        for e1, e2 in edges:
            graph[e1].append(e2)
            graph[e2].append(e1)
        visit = set()

        def dfs(node, prev):
            if node in visit:
                return
            visit.add(node)
            for nei in graph[node]:
                if nei == prev:
                    continue
                dfs(nei, node)

        res = 0
        for node in range(n):
            if node not in visit:
                res += 1
                dfs(node, -1)
        return res
