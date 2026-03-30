class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        res = []
        comb = []

        def dfs(i, total):
            if total == target:
                # print("RIGHT: ", comb)
                res.append(comb.copy())
                return
            if i >= len(candidates) or total > target:
                # print("WRONG: ", comb)
                return
            
            comb.append(candidates[i])
            dfs(i + 1, total + candidates[i])

            comb.pop()
            while i+1 < len(candidates) and candidates[i] == candidates[i+1]:
                i += 1
            
            dfs(i + 1, total)

        dfs(0, 0)
        return res
