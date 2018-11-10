package model;

public class Solutions {
    
    /**
     * Search a sorted array
     * @param array, sorted array of Integers to be searched (from low index to high index)
     * @param low, low index of range to be searched
     * @param high, high index of range to be searched
     * @param key, the search integer key
     * @return i, index of key if found
     * else, return i where A[i] < key
     * else, return -1 if key < low
     */
    public static int binarySearchArray(int[] array, int low, int high, int key) {
        if (low > high) return low - 1;
        else {
            int mid = (int) Math.floor(low + (high - low)/2);
            if (array[mid] == key)
                return mid;
            else if (array[mid] > key)
                return binarySearchArray(array, low, mid - 1, key);
            else
                return binarySearchArray(array, mid + 1, high, key);
        }
    }
    
    public static int binarySearchArrayIter(int[] array, int low, int high, int key) {

        while (high >= low) {
            int mid = (int) Math.floor(low + (high - low)/2);
            if (array[mid] == key) return mid;
            else if (array[mid] > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low - 1;
    }
    
    /**
     * Multiply 2 polynomials
     * @param A, factors of polynomial A (example: A = [3, 2, 5] for 3x^2 + 2x + 5
     * @param B, factors of polynomial B (example: B = [0, 1, 2] for x + 2
     * @param n, size of array A (== size of array B)
     * @return the product array (factors of the product polynomial)
     * (example: for the above A & B, return [0, 3, 8, 9, 10]
     * (product polynomial: 3x^3 + 8x^2 + 9x + 10
     */
    public static int[] multPolyNaiive(int[] A, int[] B, int n) {
        int[] product = new int[2*n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                product[i+j] += A[i] * B[j];
            }
        }
        return product;
    }
}