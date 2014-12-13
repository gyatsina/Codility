package Lesson99;

/**
 * Created by yaodh on 2014/12/13.
 * 1. ArrayInversionCount
 * Compute number of inversion in an array.
 * Task description
 * A zero-indexed array A consisting of N integers is given. An inversion is a pair of indexes (P, Q) such that P < Q and A[Q] < A[P].
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that computes the number of inversions in A, or returns −1 if it exceeds 1,000,000,000.
 * Assume that:
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 * For example, in the following array:
 * A[0] = -1 A[1] = 6 A[2] = 3
 * A[3] =  4 A[4] = 7 A[5] = 4
 * there are four inversions:
 * (1,2)  (1,3)  (1,5)  (4,5)
 * so the function should return 4.
 * Complexity:
 * expected worst-case time complexity is O(N*log(N));
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
public class ArrayInversionCount {
    // https://codility.com/demo/results/demoEP3Q2P-46A/
    int ans = 0;

    public int solution(int[] A) {
        mergeSort(A, 0, A.length - 1);
        return ans;
    }

    private void mergeSort(int[] a, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);
        merge(a, start, end);
    }

    private void merge(int[] a, int start, int end) {
        int mid = (start + end) / 2;
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        for (int i = start; i <= mid; i++) {
            L[i - start] = a[i];
        }
        for (int i = mid + 1; i <= end; i++) {
            R[i - mid - 1] = a[i];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int k = start; k <= end; k++) {
            if (L[i] <= R[j]) {
                a[k] = L[i++];
            } else {
                a[k] = R[j++];
                ans += n1 - i;
                if (ans > 1000000000) ans = -1;
            }
        }
    }

    public static void main(String[] args) {
        int ans = new ArrayInversionCount().solution(new int[]{3, 2, 1});
        System.out.println(ans);
    }
}
