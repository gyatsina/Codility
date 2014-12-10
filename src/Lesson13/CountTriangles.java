package Lesson13;

import java.util.Arrays;

/**
 * Created by yaodh on 2014/12/10.
 * 1. CountTriangles
 * Count the number of triangles that can be built from a given set of edges.
 * Task description
 * A zero-indexed array A consisting of N integers is given.
 * A triplet (P, Q, R) is triangular if it is possible to build a triangle with sides of lengths A[P], A[Q] and A[R].
 * In other words, triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
 * A[P] + A[Q] > A[R],
 * A[Q] + A[R] > A[P],
 * A[R] + A[P] > A[Q].
 * For example, consider array A such that:
 * A[0] = 10    A[1] = 2    A[2] = 5
 * A[3] = 1     A[4] = 8    A[5] = 12
 * There are four triangular triplets that can be constructed from elements of this array,
 * namely (0, 2, 4), (0, 2, 5), (0, 4, 5), and (2, 4, 5).
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given a zero-indexed array A consisting of N integers, returns the number of triangular triplets in this array.
 * For example, given array A such that:
 * A[0] = 10    A[1] = 2    A[2] = 5
 * A[3] = 1     A[4] = 8    A[5] = 12
 * the function should return 4, as explained above.
 * Assume that:
 * N is an integer within the range [0..1,000];
 * each element of array A is an integer within the range [1..1,000,000,000].
 * Complexity:
 * expected worst-case time complexity is O(N^2);
 * expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
public class CountTriangles {
    // O(n^2)
    //https://codility.com/demo/results/demoHFCK86-FBV/
    public int solution(int[] A) {
        Arrays.sort(A);
        int ans = 0, n = A.length;
        for (int i = 0; i < n - 2; i++) {
            int k = 0;  // k is init here
            for (int j = i + 1; j < n - 1; j++) {
                while (k < n && A[i] + A[j] > A[k]) {
                    k++;
                }
                ans += k - j - 1;
            }
        }
        return ans;
    }

    // O(n^3)
    //https://codility.com/demo/results/demoHVJ2YB-D56/
    /*public int solution(int[] A) {
        Arrays.sort(A);
        int ans = 0, n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = A[i] + A[j];
                for (int k = j + 1; k < n && A[k] < sum; k++) {
                    ans++;
                }
            }
        }
        return ans;
    }*/

    public static void main(String[] args) {
        int ans = new CountTriangles().solution(new int[]{10, 2, 5, 1, 8, 12});
        System.out.println(ans);
    }
}
