package Lesson13;

/**
 * Created by yaodh on 2014/12/10.
 * https://codility.com/demo/results/demoK4MGXD-XGF/
 * 1. AbsDistinct
 * Compute number of distinct absolute values of sorted array elements.
 * Task description
 * A non-empty zero-indexed array A consisting of N numbers is given. The array is sorted in non-decreasing order. The absolute distinct count of this array is the number of distinct absolute values among the elements of the array.
 * For example, consider array A such that:
 * A[0] = -5
 * A[1] = -3
 * A[2] = -1
 * A[3] =  0
 * A[4] =  3
 * A[5] =  6
 * The absolute distinct count of this array is 5, because there are 5 distinct absolute values among the elements of this array, namely 0, 1, 3, 5 and 6.
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given a non-empty zero-indexed array A consisting of N numbers, returns absolute distinct count of array A.
 * For example, given array A such that:
 * A[0] = -5
 * A[1] = -3
 * A[2] = -1
 * A[3] =  0
 * A[4] =  3
 * A[5] =  6
 * the function should return 5, as explained above.
 * Assume that:
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647];
 * array A is sorted in non-decreasing order.
 * Complexity:
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
public class AbsDistinct {
    public int solution(int[] A) {
        int newLength = 0;
        for(int i=1;i<A.length;i++) {
            if(A[i]!=A[newLength]) {
                A[++newLength] = A[i];
            }
        }
        int ans = ++newLength;
        int left = 0, right = 0;
        while (left < newLength && A[left] < 0) left++;
        right = left;
        left--;
        while (left >= 0 && right < newLength) {
            if (A[left] + A[right] == 0) {
                ans--;
                left--;
                right++;
            } else if (A[left] + A[right] > 0) {
                left--;
            } else right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new AbsDistinct().solution(new int[]{-5,-3,-1,0,3,6});
        System.out.println(ans);
    }
}
