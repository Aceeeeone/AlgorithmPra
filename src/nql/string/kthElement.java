package nql.string;

/**
 * @author nql
 * @version 1.0
 * @date 2020/12/30 12:52
 */
public class kthElement {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length , length2 = nums2.length;
        int length = length1 + length2;
        if (length%2==1) {
            int k = length/2;
            return getKthElement(nums1,nums2,k+1);
        } else {
            int k = length/2;
            return (getKthElement(nums1,nums2,k)+getKthElement(nums1,nums2,k+1))/2.0;
        }
    }

    private double getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length , length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            if (index1 == length1) {
                return nums2[index2+k-1];
            }
            if (index2 == length2) {
                return nums1[index1+k-1];
            }
            if (k == 1) {
                return Math.min(nums1[index1],nums2[index2]);
            }

            int half = k/2;
            int newIndex1=Math.min(index1+half,length1)-1;
            int newIndex2=Math.min(index2+half,length2)-1;
            int p1 = nums1[newIndex1], p2 = nums2[newIndex2];
            if (p1 <= p2) {
                k = k-(newIndex1-index1+1);
                index1 = newIndex1 + 1;
            } else {
                k = k-(newIndex2-index2+1);
                index2 = newIndex2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        kthElement kthElement = new kthElement();
        int[] a = {1,3,4,9};
        int[] b = {1,2,3,4,5,6,7,8,9};
        double mid = kthElement.findMedianSortedArrays(a,b);
        System.out.println(mid);
    }

}
