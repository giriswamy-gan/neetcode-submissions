// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        return helper(pairs, 0, pairs.size() - 1);
    }

    private List<Pair> helper(List<Pair> pairs, int l, int r) {
        if(l > r) {
            return pairs;
        }
        int pivot = r;
        int cur = l;
        for(int i = l; i < pivot; ++i) {
            if(pairs.get(i).key < pairs.get(pivot).key) {
                Pair tmp = pairs.get(i);
                pairs.set(i, pairs.get(cur));
                pairs.set(cur, tmp);
                cur++;
            }
        }
        Pair tmp = pairs.get(cur);
        pairs.set(cur, pairs.get(pivot));
        pairs.set(pivot, tmp);

        helper(pairs, l, cur - 1);
        helper(pairs, cur + 1, r);
        return pairs;
    }
}
