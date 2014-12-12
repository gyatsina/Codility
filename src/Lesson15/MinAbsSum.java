package Lesson15;

/**
 * Created by yaodh on 2014/12/12.
 * 1. MinAbsSum
 * Given array of integers, find the lowest absolute sum of elements.
 * Task description
 * For a given array A of N integers and a sequence S of N integers from the set {−1, 1},
 * we define val(A, S) as follows:
 * val(A, S) = |sum{ A[i]*S[i] for i = 0..N−1 }|
 * (Assume that the sum of zero elements equals zero.)
 * For a given array A, we are looking for such a sequence S that minimizes val(A,S).
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given an array A of N integers, computes the minimum value of val(A,S)
 * from all possible values of val(A,S) for all possible sequences S of N integers from the set {−1, 1}.
 * For example, given array:
 * A[0] =  1
 * A[1] =  5
 * A[2] =  2
 * A[3] = -2
 * your function should return 0, since for S = [−1, 1, −1, 1], val(A, S) = 0, which is the minimum possible value.
 * Assume that:
 * N is an integer within the range [0..20,000];
 * each element of array A is an integer within the range [−100..100].
 * Complexity:
 * expected worst-case time complexity is O(N*max(|A|)^2);
 * expected worst-case space complexity is O(N+sum(|A|)),
 * beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
public class MinAbsSum {
    public int solution(int[] A) {
        return 0;
    }
}
