package Lesson12;

/**
 * Created by yao on 2014/12/8.
 * https://codility.com/demo/results/demo4327W6-EVB/
 * 1. MinMaxDivision
 * Divide array A into K blocks and minimize the largest sum of any block.
 * Task description
 * You are given integers K, M and a non-empty zero-indexed array A consisting of N integers. Every element of the array is not greater than M.
 * You should divide this array into K blocks of consecutive elements. The size of the block is any integer between 0 and N. Every element of the array should belong to some block.
 * The sum of the block from X to Y equals A[X] + A[X + 1] + ... + A[Y]. The sum of empty block equals 0.
 * The large sum is the maximal sum of any block.
 * For example, you are given integers K = 3, M = 5 and array A such that:
 * A[0] = 2
 * A[1] = 1
 * A[2] = 5
 * A[3] = 1
 * A[4] = 2
 * A[5] = 2
 * A[6] = 2
 * The array can be divided, for example, into the following blocks:
 * [2, 1, 5, 1, 2, 2, 2], [], [] with a large sum of 15;
 * [2], [1, 5, 1, 2], [2, 2] with a large sum of 9;
 * [2, 1, 5], [], [1, 2, 2, 2] with a large sum of 8;
 * [2, 1], [5, 1], [2, 2, 2] with a large sum of 6.
 * The goal is to minimize the large sum. In the above example, 6 is the minimal large sum.
 * Write a function:
 * class Solution { public int solution(int K, int M, int[] A); }
 * that, given integers K, M and a non-empty zero-indexed array A consisting of N integers, returns the minimal large sum.
 * For example, given K = 3, M = 5 and array A such that:
 * A[0] = 2
 * A[1] = 1
 * A[2] = 5
 * A[3] = 1
 * A[4] = 2
 * A[5] = 2
 * A[6] = 2
 * the function should return 6, as explained above. Assume that:
 * N and K are integers within the range [1..100,000];
 * M is an integer within the range [0..10,000];
 * each element of array A is an integer within the range [0..M].
 * Complexity:
 * expected worst-case time complexity is O(N*log(N+M));
 * expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
public class MinMaxDivision {
    public int solution(int K, int M, int[] A) {
        int n = A.length;
        int sum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            max = Math.max(max, A[i]);
        }
        int left = max, right = sum;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int intervals = countIntervals(A, mid);
            if (intervals > K) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return left;
    }

    private int countIntervals(int[] A, int target) {
        int sum = 0, count = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum > target) {
                count++;
                sum = A[i];
            }
        }
        return count + (sum > 0 ? 1 : 0);
    }

    // 递归求解，TLE
    // https://codility.com/demo/results/demoBXPEWQ-T6C/
    /*public int solution(int K, int M, int[] A) {
        int n = A.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + A[i];
        }
        return bSum(sum, K, 0, n - 1);
    }

    private int bSum(int[] sum, int K, int start, int end) {
        if (start > end) return 0;
        if (K == 1) return sum[end + 1] - sum[start];
        int ans = Integer.MAX_VALUE;
        for (int i = start; i <= end + 1; i++) {
            int left = bSum(sum, K / 2, start, i - 1);
            int right = bSum(sum, K - K / 2, i, end);
            ans = Math.min(ans, Math.max(left, right));
        }
        return ans;
    }*/

    public static void main(String[] args) {
        int ans = new MinMaxDivision().solution(1, 5, new int[]{0});
        System.out.println(ans);
    }
}
