class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
        adj = [[] for _ in range(n + 1)]

        def dfs(node, prev):
            if visit[node]:
                return True

            visit[node] = True
            for nei in adj[node]:
                if nei == prev:
                    continue
                if dfs(nei, node):
                    return True

        for e1, e2 in edges:
            visit = [False] * (n + 1)
            adj[e1].append(e2)
            adj[e2].append(e1)
            
            if dfs(e1, -1):
                return [e1, e2]
        return []
