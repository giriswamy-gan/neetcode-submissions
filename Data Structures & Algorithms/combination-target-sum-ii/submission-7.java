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

        for(int j=i; j<nums.length; ++j) {
            if(j > i && nums[j] == nums[j-1]) {
                continue;
            }
            if(curSum + nums[j] > target) {
                break;
            }
            subset.add(nums[j]);
            dfs(nums, j + 1, target, curSum + nums[j], subset);
            subset.remove(subset.size() - 1);
        }
    }
}
