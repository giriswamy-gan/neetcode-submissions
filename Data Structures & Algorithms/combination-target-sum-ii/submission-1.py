class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort()
        check = set()

        def dfs(i, comb, total):
            if total == target:
                if tuple(comb) not in check:
                    check.add(tuple(comb))
                    res.append(comb[:])
                return
            if i >= len(candidates) or total > target:
                # print(comb)
                return
            
            comb.append(candidates[i])
            dfs(i + 1, comb, total + candidates[i])

            comb.pop()
            dfs(i + 1, comb, total)
        
        dfs(0, [], 0)
        return res
