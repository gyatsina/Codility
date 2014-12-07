package Lesson8;

/**
 * Created by yaodh on 2014/12/7.
 * 1. CountFactors
 * Count factors of given number n.
 * Task description
 * A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.
 * For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).
 * Write a function:
 * class Solution { public int solution(int N); }
 * that, given a positive integer N, returns the number of its factors.
 * For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.
 * Assume that:
 * N is an integer within the range [1..2,147,483,647].
 * Complexity:
 * expected worst-case time complexity is O(sqrt(N));
 * expected worst-case space complexity is O(1).
 */
public class CountFactors {
    public int solution(int N) {
        int ans = 1, s = (int) Math.sqrt(N);
        for (int i = 2; i <= s; i++) {
            int count = 0;
            while (N % i == 0) {
                N /= i;
                count++;
            }
            ans *= count + 1;
        }
        return ans * (N > 1 ? 2 : 1);
    }
}
