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

    private List<Pair> mergeSortHelper(List<Pair> pairs, int s, int e) {
        if((e - s + 1) <= 1) {
            return pairs;
        }

        int m = s + (e - s) / 2;

        mergeSortHelper(pairs, s, m);

        mergeSortHelper(pairs, m + 1, e);

        merge(pairs, s, m, e);

        return pairs;
    }

    private void merge(List<Pair> arr, int s, int m, int e) {
        List<Pair> L = new ArrayList<>(arr.subList(s, m + 1));
        List<Pair> R = new ArrayList<>(arr.subList(m + 1, e + 1));

        int i = 0;
        int j = 0;
        int k = s;

        while(i < L.size() && j < R.size()) {
            if(L.get(i).key <= R.get(j).key) {
                arr.set(k, L.get(i++));
                k++;
            }
            else {
                arr.set(k, R.get(j++));
                k++;
            }
        }

        while(i < L.size()) {
            arr.set(k, L.get(i++));
            k++;
        }

        while(j < R.size()) {
            arr.set(k, R.get(j++));
            k++;
        }
    }
}
