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
        return qs(pairs, 0, pairs.size() - 1);
    }

    private List<Pair> qs(List<Pair> arr, int l, int r) {
        if(l >= r) {
            return arr;
        }
        int pivot = r;
        int j = l;
        for(int i = l; i < pivot; ++i) {
            if(arr.get(i).key < arr.get(pivot).key) {
                Pair tmp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, tmp);
                j++;
            }
        }
        Pair tmp = arr.get(j);
        arr.set(j, arr.get(pivot));
        arr.set(pivot, tmp);

        qs(arr, l, j - 1);
        qs(arr, j + 1, r);

        return arr;
    }
}
