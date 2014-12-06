package Lesson1;

/**
 * Created by yaodh on 2014/12/4.
 * PermMissingElem
 * Find the missing element in a given permutation.
 * Task description
 * A zero-indexed array A consisting of N different integers is given.
 * The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 * Your goal is to find that missing element.
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given a zero-indexed array A, returns the value of the missing element.
 * For example, given array A such that:
 * A[0] = 2
 * A[1] = 3
 * A[2] = 1
 * A[3] = 5
 * the function should return 4, as it is the missing element.
 * Assume that:
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 * Complexity:
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
public class PermMissingElem {
    // swap the ith element and the (A[i]-1)th element, until A[i]=i+1;
    // 置换群
    public int solution(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i] == i + 1) continue;
            while (A[i] != i + 1 && A[i] <= n) {
                swap(A, i, A[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (A[i] > n) return i + 1;
        }
        return n + 1;
    }

    private void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    public static void main(String[] args) {
        int ans = new PermMissingElem().solution(new int[]{5, 2, 3, 1});
        System.out.println(ans);
    }

    // calculate the sum of all elements
    /*public int solution(int[] A) {
        int n = A.length;
        // using long instead of int
        long target = (long) (n + 1) * (n + 2) / 2;
        for (int i = 0; i < n; i++) {
            target -= A[i];
        }
        return (int) target;
    }*/
}
