class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(0, nums, new ArrayList<>(), 0, target);
        return res;
    }

    private void dfs(int i, int[] nums, List<Integer> cur, int curSum, int target) {
        if(curSum == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int j=i; j<nums.length; ++j) {
            if(curSum + nums[j] > target) return;
            cur.add(nums[j]);
            dfs(j, nums, cur, curSum + nums[j], target);
            cur.remove(cur.size() - 1);
        }
    }
}
