// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        return mergeSortHelper(pairs, 0, pairs.size() - 1);
    }

    private List<Pair> mergeSortHelper(List<Pair> pairs, int l, int r) {
        if(r - l + 1 <= 1) {
            return pairs;
        }

        int m = (l + r) / 2;

        mergeSortHelper(pairs, l, m);
        mergeSortHelper(pairs, m + 1, r);
        merge(pairs, l, m, r);

        return pairs;
    }

    private void merge(List<Pair> pairs, int l, int m, int r) {
        int i = l, j = m + 1;

        while(i <= m && j <= r) {
            if(pairs.get(i).key <= pairs.get(j).key) {
                i++;
                continue;
            }

            Pair val = pairs.get(j);
            for(int k = j; k > i; --k) {
                pairs.set(k, pairs.get(k - 1));
            }
            pairs.set(i, val);

            i++;
            j++;
            m++;
        }
    }
}
