package chags.io.ds.fb;

public class MergeSortedArrays {

    public static void main(String[] args) {
        MergeSortedArrays mergeSortArrays = new MergeSortedArrays();
        mergeSortArrays.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int writeIndex = nums1.length - 1;

        while (j >= 0 && i >= 0) {
            if (nums2[j] > nums1[i]) {
                nums1[writeIndex--] = nums2[j];
                j--;
            } else {
                nums1[writeIndex--] = nums1[i];
                i--;
            }
        }
        while (i >= 0) {
            nums1[writeIndex--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[writeIndex--] = nums2[j--];
        }
    }

}
