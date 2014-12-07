package Lesson7;

import java.util.Random;

/**
 * Created by yaodh on 2014/12/7.
 * 1. MaxDoubleSliceSum
 * Find the maximal sum of any double slice.
 * Task description
 * A non-empty zero-indexed array A consisting of N integers is given.
 * A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
 * The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
 * For example, array A such that:
 * A[0] = 3
 * A[1] = 2
 * A[2] = 6
 * A[3] = -1
 * A[4] = 4
 * A[5] = 5
 * A[6] = -1
 * A[7] = 2
 * contains the following example double slices:
 * double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
 * double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
 * double slice (3, 4, 5), sum is 0.
 * The goal is to find the maximal sum of any double slice.
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given a non-empty zero-indexed array A consisting of N integers, returns the maximal sum of any double slice.
 * For example, given:
 * A[0] = 3
 * A[1] = 2
 * A[2] = 6
 * A[3] = -1
 * A[4] = 4
 * A[5] = 5
 * A[6] = -1
 * A[7] = 2
 * the function should return 17, because no double slice of array A has a sum of greater than 17.
 * Assume that:
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 * Complexity:
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
public class MaxDoubleSliceSum {
    // dp from two directions
    public int solution(int[] A) {
        int n = A.length;
        int[] dpL = new int[n];
        int[] dpR = new int[n];
        for (int i = 1; i < n - 1; i++) {
            dpL[i] = Math.max(dpL[i - 1] + A[i], 0);
        }
        for (int i = n - 2; i > 0; i--) {
            dpR[i] = Math.max(dpR[i + 1] + A[i], 0);
        }
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, dpL[i - 1] + dpR[i + 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = new int[5];
        for(int i=0;i<a.length;i++) {
            Random rand = new Random();
            a[i] = rand.nextInt()%10;
            System.out.print(a[i] + ",");
        }
        System.out.println();
        int ans = new MaxDoubleSliceSum().solution(a);
        System.out.println(ans);
    }
}
//3,2,6,-1,4,5,-1,2
//1,1,0,10,-100,10,0
//0,-5,7,-3,5,-9,-4,2,2,1
//1,5,-4,4,-6,-4,8,3,-1,-4 ->12
//-2,-3,-3,2,-8,7,0,-2,-6,7->9