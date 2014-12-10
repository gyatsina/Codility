package Challenges;

/**
 * Created by yaodh on 2014/12/9.
 * In this problem we consider only strings consisting of lower-case English letters (a−z).
 * A string is a palindrome if it reads exactly the same from left to right as it does from right to left.
 * For example, these strings are palindromes:
 * aza
 * abba
 * abacaba
 * These strings are not palindromes:
 * zaza
 * abcd
 * abacada
 * Given a string S of length N, a slice of S is a substring of S specified by a pair of integers (p, q),
 * such that 0 ≤ p < q < N. A slice (p, q) of string S is palindromic
 * if the string consisting of letters S[p], S[p+1], ..., S[q] is a palindrome.
 * For example, in a string S = abbacada:
 * slice (0, 3) is palindromic because abba is a palindrome,
 * slice (6, 7) is not palindromic because da is not a palindrome,
 * slice (2, 5) is not palindromic because baca is not a palindrome,
 * slice (1, 2) is palindromic because bb is a palindrome.
 * Write a function
 * class Solution { public int solution(String S); }
 * that, given a string S of length N letters, returns the number of palindromic slices of S.
 * The function should return −1 if this number is greater than 100,000,000.
 * For example, for string S = baababa the function should return 6,
 * because exactly six of its slices are palindromic; namely: (0, 3), (1, 2), (2, 4), (2, 6), (3, 5), (4, 6).
 * Assume that:
 * N is an integer within the range [0..20,000];
 * string S consists only of lower-case letters (a−z).
 * Complexity:
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class Gamma2011 {
    // TLE: Time-O(n^2) Space-O(1)
    // The answer will be less then 2*10^8.
    public int solution(String S) {
        int ans = 0;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i - 1) == S.charAt(i)) {
                ans += expend(S, i - 1, i);
            }
            if (i >= 2 && S.charAt(i - 2) == S.charAt(i)) {
                ans += expend(S, i - 2, i);
            }
        }
        return ans > 100000000 ? -1 : ans;
    }

    public int expend(String S, int left, int right) {
        int ans = 0;
        while (left >= 0 && right < S.length() && S.charAt(left) == S.charAt(right)) {
            ans++;
            left--;
            right++;
        }
        return ans;
    }
}
