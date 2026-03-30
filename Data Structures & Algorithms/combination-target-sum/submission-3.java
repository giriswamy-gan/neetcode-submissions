class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, target, 0, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int target, int curSum, int i, List<Integer> subSet) {
        if(curSum > target) return;
        else if(curSum == target) {
            res.add(new ArrayList<>(subSet));
            return;
        }
        if(i >= nums.length) return;

        subSet.add(nums[i]);
        dfs(nums, target, curSum + nums[i], i, subSet);

        subSet.remove(subSet.size() - 1);
        dfs(nums, target, curSum, i+1, subSet);
    }
}
