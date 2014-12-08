package Lesson11;

import java.util.Arrays;

/**
 * Created by yaodh on 2014/12/8.
 * 1. FibFrog
 * Count the minimum number of jumps required for a frog to get to the other side of a river.
 * Task description
 * The Fibonacci sequence is defined using the following recursive formula:
 * F(0) = 0
 * F(1) = 1
 * F(M) = F(M - 1) + F(M - 2) if M >= 2
 * A small frog wants to get to the other side of a river. The frog is initially located at one bank of the river (position −1) and wants to get to the other bank (position N). The frog can jump over any distance F(K), where F(K) is the K-th Fibonacci number. Luckily, there are many leaves on the river, and the frog can jump between the leaves, but only in the direction of the bank at position N.
 * The leaves on the river are represented in a zero-indexed array A consisting of N integers. Consecutive elements of array A represent consecutive positions from 0 to N − 1 on the river. Array A contains only 0s and/or 1s:
 * 0 represents a position without a leaf;
 * 1 represents a position containing a leaf.
 * The goal is to count the minimum number of jumps in which the frog can get to the other side of the river (from position −1 to position N). The frog can jump between positions −1 and N (the banks of the river) and every position containing a leaf.
 * For example, consider array A such that:
 * A[0] = 0
 * A[1] = 0
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * A[5] = 0
 * A[6] = 1
 * A[7] = 0
 * A[8] = 0
 * A[9] = 0
 * A[10] = 0
 * The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given a zero-indexed array A consisting of N integers, returns the minimum number of jumps by which the frog can get to the other side of the river. If the frog cannot reach the other side of the river, the function should return −1.
 * For example, given:
 * A[0] = 0
 * A[1] = 0
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * A[5] = 0
 * A[6] = 1
 * A[7] = 0
 * A[8] = 0
 * A[9] = 0
 * A[10] = 0
 * the function should return 3, as explained above.
 * Assume that:
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer that can have one of the following values: 0, 1.
 * Complexity:
 * expected worst-case time complexity is O(N*log(N));
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
public class FibFrog {
    public final int MAX_STEP = 25;

    public int solution(int[] A) {
        int[] fib = new int[MAX_STEP];
        fib[0] = fib[1] = 1;
        for (int i = 2; i < MAX_STEP; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        int n = A.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
            if (i < n && A[i] == 0) continue;
            if (Arrays.binarySearch(fib, i + 1) >= 0) {
                dp[i] = 1;
                continue;
            }
            for (int j = 1; j < MAX_STEP; j++) {
                if (i - fib[j] < 0) break;
                if (dp[i - fib[j]] == -1) continue;
                if (dp[i] == -1) dp[i] = dp[i - fib[j]] + 1;
                else dp[i] = Math.min(dp[i], dp[i - fib[j]] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int ans = new FibFrog().solution(new int[]{0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0});
        System.out.println(ans);
    }
}
