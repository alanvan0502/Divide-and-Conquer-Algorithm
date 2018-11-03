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
}