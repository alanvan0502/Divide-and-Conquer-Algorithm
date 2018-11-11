package model;
import java.util.*;

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
     * @param right, right index of range to be sorted, including this index
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
     * Sort the input array using Counting Sort. Time complexity O(N)
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
    
    /**
     * Sort the input array using Counting Sort, copying elements of input array
     * @param A, array to be sorted
     * @param m, [1...m] are elements of array A
     * @return sorted array
     */
    public static int[] countSortCopy(int[]A, int m) {
        int[] count = new int[m];
        
        for (int i = 0; i < A.length; i++) {
            count[A[i] - 1] += 1;
        }
        
        int[] pos = new int[m];
        pos[0] = 0;
        for (int j = 1; j < m; j++) {
            pos[j] = pos[j-1] + count[j-1];
        }
        
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            result[pos[A[i]-1]] = A[i];
            pos[A[i]-1] += 1;
        }
        
        return result;
    }
    
    /**
     * Trial Version:
     * Sort the input array using Quick Sort, copying elements of input array
     * @param A, array to be sorted
     * @return sorted array
     */
    public static int[] quickSortTry(int[] arr) {
        if (arr.length == 1 || arr.length == 0) {
            return arr;
        }
        
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        int pivot = arr[0];
        
        int l = 0;
        int r = 0;
        
        for (int i = 1; i < arr.length; i++) {
            int currElement = arr[i];
            if (currElement < pivot) {
                left[l] = currElement;
                l++;
            } else {
                right[r] = currElement;
                r++;
            }
        }
        
        int[] pivotedLeft = new int[l];
        for (int i = 0; i < l; i++) {
            pivotedLeft[i] = left[i];
        }
        int[] pivotedRight = new int[r];
        for (int i = 0; i < r; i++) {
            pivotedRight[i] = right[i];
        }
        
        int[] pL = quickSortTry(pivotedLeft);
        int[] pR = quickSortTry(pivotedRight);
        
        int[] result = new int[arr.length];
        for (int i = 0; i < l; i++) {
            result[i] = pL[i];
        }
        result[l] = pivot;
        int index = 0;
        for (int i = l+1; i < arr.length; i++) {
            result[i] = pR[index];
            index++;
        }
        
        return result;
    }
    
    /**
     * Quicksort Algorithm
     * Sort the input array using Quick Sort, copying elements of input array
     * @param arr, array to be sorted
     * @param l, left index of array to be sorted
     * @param r, right index of array to be sorted, including this index
     * @return nothing, array arr is modified by this method
     */
    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;
       
        int m = partition(arr, l, r);
        quickSort(arr, l, m-1);
        quickSort(arr, m+1, r);
    }

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        int j = l;
        
        for (int i = l+1; i <= r; i++) {
            if (arr[i] <= pivot) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, j, l);
        return j;
    }
    
    /**
     * Randomized Quicksort Algorithm to ensure average time-complexity to be O(nlogn)
     * Sort the input array using Quick Sort, copying elements of input array
     * @param arr, array to be sorted
     * @param l, left index of array to be sorted
     * @param r, right index of array to be sorted, including this index
     * @return nothing, array arr is modified by this method
     */
    public static void randomizedQuickSort(int[] arr, int l, int r) {
        if (l >= r) return;
        
        Random rand = new Random();
        int k = l + rand.nextInt(r - l + 1);
        swap(arr, l, k);
        
        int m = partition(arr, l, r);
        randomizedQuickSort(arr, l, m-1);
        randomizedQuickSort(arr, m+1, r);
    }
    
    /**
     * Tail-recursive Randomized Quicksort Algorithm. This reduces the stack depth used.
     * Sort the input array using Quick Sort, copying elements of input array
     * @param arr, array to be sorted
     * @param l, left index of array to be sorted
     * @param r, right index of array to be sorted, including this index
     * @return nothing, array arr is modified by this method
     */
    public static void tailRandomizedQuickSort(int[] arr, int l, int r) {
        if (l >= r) return;
        
        Random rand = new Random();
        int k = l + rand.nextInt(r - l + 1);
        swap(arr, l, k);
        
        while (l < r) {
            int m = partition(arr, l, r);
            if ((m - l) < (r - m)){
                tailRandomizedQuickSort(arr, l, m - 1);
                l = m + 1;
            } else {
                tailRandomizedQuickSort(arr, m+1, r);
                r = m - 1;
            }
        }
    }    
}
