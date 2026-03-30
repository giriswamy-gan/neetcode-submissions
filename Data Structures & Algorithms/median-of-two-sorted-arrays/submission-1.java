class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1, B = nums2;
        if(nums2.length < nums1.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }
        int len1 = A.length, len2 = B.length;
        int half = (len1 + len2 + 1)/2;
        int l = 0, r = len1;
        while(l <= r) {
            int i = (l + r) / 2;
            int j = half - i;

            int Aleft = i > 0 ? A[i-1] : Integer.MIN_VALUE;
            int Aright = i < A.length ? A[i] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? B[j-1] : Integer.MIN_VALUE;
            int Bright = j < B.length ? B[j] : Integer.MAX_VALUE;

            if(Aleft <= Bright && Bleft <= Aright) {
                if((A.length + B.length) % 2 == 1) {
                    return (double) Math.max(Aleft, Bleft);
                }
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } else if(Aleft > Bright) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        return -1;
    }
}

// calculate total
// calculate half by using Math.floor
// for the smaller array, find the middle point and that will be left partition
// do half - left partition of smaller array to find the left partition of the bigger array
// check if rightmost value in left partition in smaller array is <= leftmost value in right partition of bigger array
// check if rightmost value in left partition in bigger array is <= leftmost value in right partition of smaller array
// if it is then the left partitions are correct. {
// if odd, calculate median using min(leftmost in right partition big array, small array)
// if even, calculate median using max(rightmost in left partition big, small) + min(leftmost in right partition big, small) / 2 }
// else left pointer in smaller array = 1 + mid
