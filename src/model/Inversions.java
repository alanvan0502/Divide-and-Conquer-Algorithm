package model;
import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long[][] ans = mergeSort(a, left, right-1);
        return ans[1][0];
    }
    
    /**
     * Sort the input array using Merge Sort. Time complexity O(nlogn)
     * @param A, array to be sorted
     * @param left, left index of range to be sorted
     * @param right, right index of range to be sorted, including this index
     * @return sorted array and the number of inversions in the array
     */
    public static long[][] mergeSort(int[] A, int left, int right) {
        long numberOfInversions = 0;
        
        if (left == right) {
            return new long[][] {new long[] {A[left]}, new long[] {numberOfInversions}};
        }
        
        int mid = (int) Math.floor(left + (right - left)/2);
        long[][] leftArr = mergeSort(A, left, mid);
        long[][] rightArr = mergeSort(A, mid+1, right);
        
        return merge(leftArr, rightArr, leftArr[1][0] + rightArr[1][0]);   
    }

    public static long[][] merge(long[][] leftArr, long[][] rightArr, long inversions) {
        long[][] result = new long [2][];
        result[0] = new long[leftArr[0].length + rightArr[0].length];
        result[1] = new long[1];
        
        int firstLeft = 0;
        int firstRight = 0;
        int insertIndex = 0;
        
        for (int i = 0; i < leftArr[0].length; i++) {
            for (int j = 0; j < rightArr[0].length; j++) {
                if (leftArr[0][i] > rightArr[0][j])
                    ++inversions;
            }
        }

        while (firstLeft != leftArr[0].length && firstRight != rightArr[0].length) {
            if (leftArr[0][firstLeft] <= rightArr[0][firstRight]) {
                result[0][insertIndex] = leftArr[0][firstLeft];
                firstLeft++;
                insertIndex++;
            } else {
                result[0][insertIndex] = rightArr[0][firstRight];
                firstRight++;
                insertIndex++;
            }
        }
        while (insertIndex < result[0].length) {
            if (firstLeft < leftArr[0].length) {
                result[0][insertIndex] = leftArr[0][firstLeft];
                insertIndex++;
                firstLeft++;
            }
            if (firstRight < rightArr[0].length) {
                result[0][insertIndex] = rightArr[0][firstRight];
                insertIndex++;
                firstRight++;
            }
        }
        result[1] = new long[] {inversions};
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length));
    }
}

