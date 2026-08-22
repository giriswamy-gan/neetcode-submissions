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
        List<Pair> left = new ArrayList<>(pairs.subList(l, m + 1));
        List<Pair> right = new ArrayList<>(pairs.subList(m + 1, r + 1));

        int i = 0, j = 0, k = l;

        while(i < left.size() && j < right.size()) {
            if(left.get(i).key <= right.get(j).key) {
                pairs.set(k, left.get(i++));
            }
            else {
                pairs.set(k, right.get(j++));
            }
            k++;
        }
        while(i < left.size()) {
            pairs.set(k, left.get(i++));
            k++;
        }
        while(j < right.size()) {
            pairs.set(k, right.get(j++));
            k++;
        }
    }
}
