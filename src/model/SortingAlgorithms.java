package model;

public class SortingAlgorithms {
    
    /**
     * Sort the input array using Selection Sort. Time complexity O(n^2).
     * @param A, array to be sorted
     * @return none. input array is modified by this method.
     */
    public static int[] selectionSort(int[] A) {
        
        for (int i = 0; i < A.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[minIndex]) {
                    minIndex = j;
                }
            }
            swap(A, i, minIndex);
        } 
        return A;
    }

    private static void swap(int[] A, int i, int minIndex) {
        int temp = A[i];
        A[i] = A[minIndex];
        A[minIndex] = temp;
    }
    
    /**
     * Sort the input array using Merge Sort. Time complexity O(nlogn)
     * @param A, array to be sorted
     * @param left, left index of range to be sorted
     * @param right, right index of range to be sorted
     * @return sorted array
     */
    public static int[] mergeSort(int[] A, int left, int right) {
        if (left == right) {
            return new int[] {A[left]};
        }    
        int mid = (int) Math.floor(left + (right - left)/2);
        int[] leftArr = mergeSort(A, left, mid);
        int[] rightArr = mergeSort(A, mid+1, right);
        
        return merge(leftArr, rightArr);   
    }

    public static int[] merge(int[] leftArr, int[] rightArr) {
        int[] result = new int[leftArr.length + rightArr.length];
        int firstLeft = 0;
        int firstRight = 0;
        int insertIndex = 0;
        while (firstLeft != leftArr.length && firstRight != rightArr.length) {
            if (leftArr[firstLeft] <= rightArr[firstRight]) {
                result[insertIndex] = leftArr[firstLeft];
                firstLeft++;
                insertIndex++;
            } else {
                result[insertIndex] = rightArr[firstRight];
                firstRight++;
                insertIndex++;
            }
        }
        while (insertIndex < result.length) {
            if (firstLeft < leftArr.length) {
                result[insertIndex] = leftArr[firstLeft];
                insertIndex++;
                firstLeft++;
            }
            if (firstRight < rightArr.length) {
                result[insertIndex] = rightArr[firstRight];
                insertIndex++;
                firstRight++;
            }
        }
        
        return result;
    }
    
    public static void merge(int[] leftArr, int m, int[] rightArr, int n) {
        int[] result = new int[m + n];
        int firstLeft = 0;
        int firstRight = 0;
        int insertIndex = 0;
        while (firstLeft != m && firstRight != n) {
            if (leftArr[firstLeft] <= rightArr[firstRight]) {
                result[insertIndex] = leftArr[firstLeft];
                firstLeft++;
                insertIndex++;
            } else {
                result[insertIndex] = rightArr[firstRight];
                firstRight++;
                insertIndex++;
            }
        }
        while (insertIndex < result.length) {
            if (firstLeft < m) {
                result[insertIndex] = leftArr[firstLeft];
                insertIndex++;
                firstLeft++;
            }
            if (firstRight < n) {
                result[insertIndex] = rightArr[firstRight];
                insertIndex++;
                firstRight++;
            }
        }
        
        System.arraycopy(result, 0, leftArr, 0, leftArr.length);
    }
    
    /**
     * Sort the input array using Counting Sort. Time complexity...
     * @param A, array to be sorted
     * @param m, [1...m] are elements of array A
     * @return sorted array
     */
    public static int[] countSort(int[]A, int m) {
        int[] M = new int[m];

        for (int i = 0; i < A.length; i++) {
            M[A[i] - 1] += 1;
        }
        
        int[] result = new int[A.length];
        int index = 0;
        for (int i = 0; i < m; i++) {
            int e = M[i];
            while (e > 0) {
                result[index] = i+1;
                e--;
                index++;
            }
        }
        return result;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
