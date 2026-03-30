class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> temp) {
        if(i >= nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        dfs(nums, i+1, temp);

        temp.remove(temp.size() - 1);
        dfs(nums, i+1, temp);
    }
}
