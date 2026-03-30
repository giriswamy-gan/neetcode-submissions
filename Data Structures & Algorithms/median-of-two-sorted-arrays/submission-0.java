class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0, j=0;
        int len1 = nums1.length, len2 = nums2.length;
        int median1 = 0, median2 = 0;
        for(int count=0; count< (len1 + len2)/2 + 1; ++count) {
            median2 = median1;
            if(i < len1 && j < len2) {
                if(nums1[i] < nums2[j]) {
                    median1 = nums1[i];
                    ++i;
                }
                else {
                    median1 = nums2[j];
                    ++j;
                }
            }
            else if(i < len1) {
                median1 = nums1[i];
                ++i;
            }
            else {
                median1 = nums2[j];
                ++j;
            }
        }
        if((len1 + len2) % 2 == 0) {
            return (double) (median1 + median2) / 2;
        }
        else {
            return (double) median1;
        }
    }
}
