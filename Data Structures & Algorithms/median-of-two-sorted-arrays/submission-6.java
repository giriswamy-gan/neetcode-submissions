class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        if(A.length > B.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }
        int total = A.length + B.length;
        int half = total / 2;
        int l = -1, r = A.length-1;
        int res = 0;
        while(l <= r) {
            int i = (l + r) / 2;
            int j = half - i - 2;

            int Aleft = i >= 0 ? A[i] : Integer.MIN_VALUE;
            int Aright = (i + 1) < A.length ? A[i + 1] : Integer.MAX_VALUE;
            int Bleft = j >= 0 ? B[j] : Integer.MIN_VALUE;
            int Bright = (j + 1) < B.length ? B[j + 1] : Integer.MAX_VALUE;

            if(Aleft <= Bright && Aright >= Bleft) {
                if(total % 2 == 0) {
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                }
                else {
                    return Math.min(Aright, Bright);
                }
            }
            else if(Aleft > Bright) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        return -1;
    }
}

// [1, 2, 3, 4, 5] [1, 2, 3, 4, 5, 6, 7, 8]
// [1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8]

// Aleft
// Aright
// Bleft
// Bright
