class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> subset) {
        if(subset.size() == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        for(int j=0; j<nums.length; ++j) {
            if(set.contains(nums[j])) continue;
            set.add(nums[j]);
            subset.add(nums[j]);
            dfs(nums, j+1, subset);
            set.remove(nums[j]);
            subset.remove(subset.size() - 1);
            // dfs(nums, j+1, subset);
        }
    }
}
