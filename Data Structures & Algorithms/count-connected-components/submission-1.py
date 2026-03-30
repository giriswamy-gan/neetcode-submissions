class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        graph = [[] for _ in range(n)]
        for e1, e2 in edges:
            graph[e1].append(e2)
            graph[e2].append(e1)
        visit = [False] * n

        def dfs(node):
            for nei in graph[node]:
                if not visit[nei]:
                    visit[nei] = True
                    dfs(nei)

        res = 0
        for node in range(n):
            if not visit[node]:
                visit[node] = True
                dfs(node)
                res += 1
        return res
