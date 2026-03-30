class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(candidates, 0, target, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int i, int target, int curSum, List<Integer> subset) {
        if(curSum == target) {
            res.add(new ArrayList<>(subset));
            return;
        }
        if(curSum > target || i >= nums.length) {
            return;
        }
        subset.add(nums[i]);
        dfs(nums, i + 1, target, curSum + nums[i], subset);

        while(i + 1 < nums.length && nums[i] == nums[i+1]) {
            i++;
        }
        subset.remove(subset.size() - 1);
        dfs(nums, i + 1, target, curSum, subset);
    }
}
