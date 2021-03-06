package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import model.Closest;

public class TestClosest {
    Random rand = new Random();
    //TODO: DEBUG THIS!
    @Test
    public void testClosest1() {
        int[] x = new int[] {0, 3};
        int[] y = new int[] {0, 4};
        System.out.println(Closest.minimalDistanceNaive(x, y));
        System.out.println(Closest.minimalDistance(x, y));
        assertEquals(Closest.minimalDistance(x, y), Closest.minimalDistanceNaive(x, y), 0.01);
    }

    @Test
    public void testClosest2() {
        int[] x = new int[] {7, 1, 4, 7};
        int[] y = new int[] {7, 100, 8, 7};
        assertEquals(Closest.minimalDistance(x, y), Closest.minimalDistanceNaive(x, y), 0.01);
    }

    @Test
    public void testClosest3() {
        int[] x = new int[] {4, -2, -3, -1, 2, -4, 1, -1, 3, -4, -2};
        int[] y = new int[] {4, -2, -4, 3, 3, 0, 1, -1, -1, 2, 4};
        assertEquals(Closest.minimalDistance(x, y), Closest.minimalDistanceNaive(x, y), 0.01);
    }

    @Test
    public void testClosest4() {
        int[] x = new int[] {0, 5, 3, 7};
        int[] y = new int[] {0, 6, 4, 2};
        assertEquals(Closest.minimalDistance(x, y), Closest.minimalDistanceNaive(x, y), 0.01);
    }
    
//    @Test
//    public void testClosest5() {
//        int[] x = new int[] {0, 3, 3, 3};
//        int[] y = new int[] {0, 6, 4, 2};
//        assertEquals(Closest.minimalDistance(x, y), Closest.minimalDistanceNaive(x, y), 0.01);
//    }
    
    @Test
    public void testClosest6() {
        int[] x = new int[] {-44, 18, 30, 20, 19, 28, 36, 10, -22, -18};
        int[] y = new int[] {-43, 43, 32, 15, -26, -22, 17, -15, -12, -17};
        assertEquals(Closest.minimalDistance(x, y), Closest.minimalDistanceNaive(x, y), 0.01);
    }
    
    // Special test case!
    @Test
    public void testClosest7() {
        int size = 100000;
        int[] x = new int[size];
        int[] y = new int[size];
        x[0] = 0;
        x[1] = 5000;
        y[0] = 0;
        y[1] = 5000;
        x[2] = 1;
        y[2] = 20000;
        for (int i = 3; i <= 10000; i++) {
            x[i] += 1;
            y[i] += 10000;
        }
        for (int i = 10001; i < size; i++) {
            x[i] = 10000;
            y[i] -= 10000;
        }
        
    }

    @Test
    public void stressTest() {
        int size = 1000;
        int[] x = new int[size];
        int[] y = new int[size];

        while (true) {
            List<Integer> xValues = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                while(true) {
                    int xValue = rand.nextInt(2000);
                    if (!xValues.contains(xValue) && xValue > 100) {
                        xValues.add(xValue);
                        x[i] = xValue;
                        break;
                    }  
                }
                y[i] = rand.nextInt(100);
            }
            System.out.println("x: ");
            printArray(x);
            System.out.println("y: ");
            printArray(y);
            double dist = Closest.minimalDistance(x, y);
            double distNaive = Closest.minimalDistanceNaive(x, y);
            System.out.println(dist);
            System.out.println(distNaive);
            
            if (dist != distNaive) {
                break;
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
