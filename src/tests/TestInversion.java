package tests;

import org.junit.jupiter.api.Test;

import model.Inversions;

import static org.junit.Assert.*;

public class TestInversion {
    
    @Test
    public void testInversion1() {
        long[][] a = Inversions.mergeSort(new int[] {2, 3, 9, 2, 9}, 0, 4);
        long[] ansArr = new long[] {2, 2, 3, 9, 9};
        for (int i = 0; i < a[0].length; i++) {
            assertTrue(a[0][i] == ansArr[i]);
        }
        System.out.println(a[1][0]);
    }
    
    @Test
    public void testInversion2() {
        long[][] a = Inversions.mergeSort(new int[] {6, 5, 4, 3, 2, 1}, 0, 5);
        long[] ansArr = new long[] {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < a[0].length; i++) {
            assertTrue(a[0][i] == ansArr[i]);
        }
        System.out.println(a[1][0]);
    }
    
    @Test
    public void testInversion3() {
        long[][] a = Inversions.mergeSort(new int[] {1, 2, 3, 4, 5, 6}, 0, 5);
        long[] ansArr = new long[] {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < a[0].length; i++) {
            assertTrue(a[0][i] == ansArr[i]);
        }
        System.out.println(a[1][0]);
    }
    
    @Test
    public void testMerge() {
        long[][] left = new long[][] {new long[] {2, 3, 5, 7}, new long[] {0}};
        long[][] right = new long[][] {new long[] {1, 6, 7, 13}, new long[] {0}};
        long[][] a = Inversions.merge(left, right, 0);
        
        long[] ansa = new long[] {1, 2, 3, 5, 6, 7, 7, 13};
        for (int i = 0; i < a[0].length; i++) {
            assertTrue(a[0][i] == ansa[i]);
        }
        System.out.println(a[1][0]);
    }
}
