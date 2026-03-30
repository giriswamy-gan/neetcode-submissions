class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < triplets.length; ++i) {
            boolean flag = true;
            for(int j = 0; j < 3; ++j) {
                if(triplets[i][j] > target[j]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                list.add(triplets[i]);
            }
        }
        if(list.size() == 0) return false;

        boolean a = false, b = false, c = false;
        for(int[] triplet : list) {
            if(triplet[0] == target[0]) a = true;
            if(triplet[1] == target[1]) b = true;
            if(triplet[2] == target[2]) c = true;
        }

        return a && b && c;
    }
}
