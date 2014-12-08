package Lesson9;

/**
 * Created by yaodh on 2014/12/8.
 * https://codility.com/demo/results/demoQ32RC4-KTT/
 * 1. CountSemiprimes
 * Count the semiprime numbers in the given range [a..b]
 * Task description
 * A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.
 * A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.
 * You are given two non-empty zero-indexed arrays P and Q, each consisting of M integers. These arrays represent queries about the number of semiprimes within specified ranges.
 * Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.
 * For example, consider an integer N = 26 and arrays P, Q such that:
 * P[0] = 1    Q[0] = 26
 * P[1] = 4    Q[1] = 10
 * P[2] = 16   Q[2] = 20
 * The number of semiprimes within each of these ranges is as follows:
 * (1, 26) is 10,
 * (4, 10) is 4,
 * (16, 20) is 0.
 * Write a function:
 * class Solution { public int[] solution(int N, int[] P, int[] Q); }
 * that, given an integer N and two non-empty zero-indexed arrays P and Q consisting of M integers, returns an array consisting of M elements specifying the consecutive answers to all the queries.
 * For example, given an integer N = 26 and arrays P, Q such that:
 * P[0] = 1    Q[0] = 26
 * P[1] = 4    Q[1] = 10
 * P[2] = 16   Q[2] = 20
 * the function should return the values [10, 4, 0], as explained above.
 * Assume that:
 * N is an integer within the range [1..50,000];
 * M is an integer within the range [1..30,000];
 * each element of arrays P, Q is an integer within the range [1..N];
 * P[i] ≤ Q[i].
 * Complexity:
 * expected worst-case time complexity is O(N*log(log(N))+M);
 * expected worst-case space complexity is O(N+M), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
public class CountSemiprimes {
    boolean[] notPrime, semi;

    public void seivee(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (notPrime[i]) continue;
            for (int k = i * i; k <= n; k += i) {
                notPrime[k] = true;
            }
        }
    }

    public void semi(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (notPrime[i]) continue;
            for (int k = i * i; k <= n; k += i) {
                if (!notPrime[k / i]) semi[k] = true;
            }
        }
    }

    public int[] solution(int N, int[] P, int[] Q) {
        notPrime = new boolean[N + 1];
        seivee(N);
        semi = new boolean[N + 1];
        semi(N);
        int[] sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1];
            if (semi[i]) sum[i]++;
        }
        for (int i = 0; i < P.length; i++) {
            P[i] = sum[Q[i]] - sum[P[i] - 1];
        }
        return P;
    }

    public static void main(String[] args) {
        int[] ans = new CountSemiprimes().solution(26, new int[]{1, 2, 16}, new int[]{26, 10, 20});
        for (int x : ans) {
            System.out.printf("%d ", x);
        }
    }
}
