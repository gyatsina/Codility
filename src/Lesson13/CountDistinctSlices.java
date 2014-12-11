package Lesson13;

import java.util.BitSet;

/**
 * Created by yaodh on 2014/12/10.
 * 1. CountDistinctSlices
 * Count the number of distinct slices (containing only unique numbers).
 * Task description
 * An integer M and a non-empty zero-indexed array A consisting of N non-negative integers are given.
 * All integers in array A are less than or equal to M.
 * A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A.
 * The slice consists of the elements A[P], A[P + 1], ..., A[Q].
 * A distinct slice is a slice consisting of only unique numbers.
 * That is, no individual number occurs more than once in the slice.
 * For example, consider integer M = 6 and array A such that:
 * A[0] = 3
 * A[1] = 4
 * A[2] = 5
 * A[3] = 5
 * A[4] = 2
 * There are exactly nine distinct slices: (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2), (3, 3), (3, 4) and (4, 4).
 * The goal is to calculate the number of distinct slices.
 * Write a function:
 * class Solution { public int solution(int M, int[] A); }
 * that, given an integer M and a non-empty zero-indexed array A consisting of N integers,
 * returns the number of distinct slices.
 * If the number of distinct slices is greater than 1,000,000,000, the function should return 1,000,000,000.
 * For example, given integer M = 6 and array A such that:
 * A[0] = 3
 * A[1] = 4
 * A[2] = 5
 * A[3] = 5
 * A[4] = 2
 * the function should return 9, as explained above.
 * Assume that:
 * N is an integer within the range [1..100,000];
 * M is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [0..M].
 * Complexity:
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(M), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
public class CountDistinctSlices {
    // Time--O(N) Space--O(M)
    // https://codility.com/demo/results/demo724FXS-J88/
    public int solution(int M, int[] A) {
        int ans = 0, pre = -1;
        int[] hash = new int[M + 1];
        for (int i = 0; i < hash.length; i++) hash[i] = -1;
        for (int i = 0; i < A.length; i++) {
            if (hash[A[i]] > pre) {
                pre = hash[A[i]];
            }
            ans += i - pre;
            hash[A[i]] = i;
            if (ans > 1000000000) ans = 1000000000;
        }
        return ans;
    }
}
