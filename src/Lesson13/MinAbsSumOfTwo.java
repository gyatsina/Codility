package Lesson13;

import java.util.Arrays;

/**
 * Created by yaodh on 2014/12/11.
 * 1. MinAbsSumOfTwo
 * Find the minimal absolute value of a sum of two elements.
 * Let A be a non-empty zero-indexed array consisting of N integers.
 * The abs sum of two for a pair of indices (P, Q) is the absolute value |A[P] + A[Q]|, for 0 ≤ P ≤ Q < N.
 * For example, the following array A:
 * A[0] =  1
 * A[1] =  4
 * A[2] = -3
 * has pairs of indices (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2).
 * The abs sum of two for the pair (0, 0) is A[0] + A[0] = |1 + 1| = 2.
 * The abs sum of two for the pair (0, 1) is A[0] + A[1] = |1 + 4| = 5.
 * The abs sum of two for the pair (0, 2) is A[0] + A[2] = |1 + (−3)| = 2.
 * The abs sum of two for the pair (1, 1) is A[1] + A[1] = |4 + 4| = 8.
 * The abs sum of two for the pair (1, 2) is A[1] + A[2] = |4 + (−3)| = 1.
 * The abs sum of two for the pair (2, 2) is A[2] + A[2] = |(−3) + (−3)| = 6.
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given a non-empty zero-indexed array A consisting of N integers, returns the minimal abs sum of two for any pair of indices in this array.
 * For example, given the following array A:
 * A[0] =  1
 * A[1] =  4
 * A[2] = -3
 * the function should return 1, as explained above.
 * Given array A:
 * A[0] = -8
 * A[1] =  4
 * A[2] =  5
 * A[3] =-10
 * A[4] =  3
 * the function should return |(−8) + 5| = 3.
 * Assume that:
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 * Complexity:
 * expected worst-case time complexity is O(N*log(N));
 * expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
public class MinAbsSumOfTwo {
    // https://codility.com/demo/results/demoQTTHD3-Y23/
    // Time--O(N*logN)
    public int solution(int[] A) {
        Arrays.sort(A);
        int ans = Math.abs(A[0]) * 2;
        int p = 0, q = A.length - 1;
        while (p < q) {
            ans = Math.min(ans, Math.abs(A[p] + A[p]));
            ans = Math.min(ans, Math.abs(A[q] + A[q]));
            ans = Math.min(ans, Math.abs(A[p] + A[q]));
            if (ans == 0) return 0;
            else if (A[p] + A[q] > 0) {
                q--;
            } else p++;
            if ((A[p] > 0 && A[q] > 0) || (A[p] < 0 && A[q] < 0)) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new MinAbsSumOfTwo().solution(new int[]{1, 2});
        System.out.println(ans);
    }
}
