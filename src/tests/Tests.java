package tests;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import model.BinarySearch;
import model.Solutions;

public class Tests {
    
    @Test
    public void testBinarySearch1() {
        int[] arr1 = new int[] {3, 5, 8, 20, 20, 50, 60};
        assertTrue(Solutions.binarySearchArray(arr1, 0, 6, 20) == 3);
        assertTrue(Solutions.binarySearchArray(arr1, 0, 6, 8) == 2);
               
        assertTrue(Solutions.binarySearchArray(arr1, 0, 6, 60) == 6);
        assertTrue(Solutions.binarySearchArray(arr1, 0, 6, 2) == -1);
        assertTrue(Solutions.binarySearchArray(arr1, 0, 6, 90) == 6);
    }
    
    @Test
    public void testLinearSearch() {
        int[] arr1 = new int[] {3, 5, 8, 20, 20, 50, 60};
        assertTrue(BinarySearch.linearSearch(arr1, 20) == 3);
        assertTrue(BinarySearch.linearSearch(arr1, 8) == 2);
        assertTrue(BinarySearch.linearSearch(arr1, 7) == -1);
        assertTrue(BinarySearch.linearSearch(arr1, 60) == 6);
        assertTrue(BinarySearch.linearSearch(arr1, 2) == -1);
        assertTrue(BinarySearch.linearSearch(arr1, 90) == -1);
    }
    
    @Test
    public void testBinarySearch2() {
        int[] arr1 = new int[] {3, 5, 8, 20, 20, 50, 60};
        assertTrue(BinarySearch.binarySearch(arr1, 20) == 3);
        assertTrue(BinarySearch.binarySearch(arr1, 8) == 2);
        assertTrue(BinarySearch.binarySearch(arr1, 7) == -1);
        assertTrue(BinarySearch.binarySearch(arr1, 60) == 6);
        assertTrue(BinarySearch.binarySearch(arr1, 2) == -1);
        assertTrue(BinarySearch.binarySearch(arr1, 90) == -1);
    }
    
}
