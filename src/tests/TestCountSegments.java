package tests;

import org.junit.jupiter.api.Test;

import model.PointsAndSegments;

import static org.junit.Assert.*;

import java.util.Random;

public class TestCountSegments {
    
    @Test
    public void test1() {
        int[] starts = new int[] {0, 7};
        int[] ends = new int[] {5, 10};
        int[] points = new int[] {1, 6, 11};
        int[] expected = new int[] {1, 0, 0};
        
        int[] ans = PointsAndSegments.fastCountSegments(starts, ends, points);
        
        for (int i = 0; i < ans.length; i++) {
            assertTrue(ans[i] == expected[i]);
        }        
    }
    
    @Test
    public void test2() {
        int[] starts = new int[] {-10};
        int[] ends = new int[] {10};
        int[] points = new int[] {-100, 100, 0};
        int[] expected = new int[] {0, 0, 1};
        
        int[] ans = PointsAndSegments.fastCountSegments(starts, ends, points);
        
        for (int i = 0; i < ans.length; i++) {
            assertTrue(ans[i] == expected[i]);
        }        
    }
    
    @Test
    public void test3() {
        int[] starts = new int[] {0, -3, 7};
        int[] ends = new int[] {5, 2, 10};
        int[] points = new int[] {1, 6};
        int[] expected = new int[] {2, 0};
        
        int[] ans = PointsAndSegments.fastCountSegments(starts, ends, points);
        
        for (int i = 0; i < ans.length; i++) {
            assertTrue(ans[i] == expected[i]);
        }        
    }
    
    @Test
    public void test4() {
        int[] starts = new int[] {1, 1, 2, 2, 0};
        int[] ends = new int[] {2, 2, 6, 4, 2};
        int[] points = new int[] {1, 2, 3, 4};
        
        int[] expected = PointsAndSegments.naiveCountSegments(starts, ends, points);
        int[] ans = PointsAndSegments.fastCountSegments(starts, ends, points);
        
        for (int i = 0; i < ans.length; i++) {
            assertTrue(ans[i] == expected[i]);
        }
    }
    
    @Test
    public void stressTest() {
        int size = 100;
        
        Random rand = new Random();
        
        outerloop:
        while (true) {
            int[] starts = new int[size];
            int[] ends = new int[size];
            int[] points = new int[size];
            
            for (int i = 0; i < size; i++) {
                starts[i] = rand.nextInt(size);
                ends[i] = starts[i] + rand.nextInt(size);
            }
            for (int i = 0; i < points.length; i++) {
                points[i] = rand.nextInt(size);
            }
            int[] slowAns = PointsAndSegments.naiveCountSegments(starts, ends, points);
            int[] fastAns = PointsAndSegments.fastCountSegments(starts, ends, points);
            
            for (int i = 0; i < points.length; i++) {
                if (slowAns[i] != fastAns[i]) {
                    System.out.println("Start: ");
                    printArray(starts);
                    System.out.println("End: ");
                    printArray(ends);
                    System.out.println("Points: ");
                    printArray(points);
                    break outerloop;
                }
            }
        }
    }

    private void printArray(int[] arr) {
        for (int i: arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
       
}
