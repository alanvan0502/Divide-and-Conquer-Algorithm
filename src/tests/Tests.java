package tests;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import java.util.Random;

import model.BinarySearch;
import model.MajorityElement;
import model.Solutions;
import model.SortingAlgorithms;

public class Tests {

    // Binary Search
    @Test
    public void testBinarySearchRecur() {
        int[] arr1 = new int[] {3, 5, 8, 20, 20, 50, 60};
        assertTrue(Solutions.binarySearchArray(arr1, 0, 6, 20) == 3);
        assertTrue(Solutions.binarySearchArray(arr1, 0, 6, 8) == 2);

        assertTrue(Solutions.binarySearchArray(arr1, 0, 6, 60) == 6);
        assertTrue(Solutions.binarySearchArray(arr1, 0, 6, 2) == -1);
        assertTrue(Solutions.binarySearchArray(arr1, 0, 6, 90) == 6);
    }

    @Test
    public void testBinarySearchIter() {
        int[] arr1 = new int[] {3, 5, 8, 20, 20, 50, 60};
        assertTrue(Solutions.binarySearchArrayIter(arr1, 0, 6, 20) == 3);
        assertTrue(Solutions.binarySearchArrayIter(arr1, 0, 6, 8) == 2);

        assertTrue(Solutions.binarySearchArrayIter(arr1, 0, 6, 60) == 6);
        assertTrue(Solutions.binarySearchArrayIter(arr1, 0, 6, 2) == -1);
        assertTrue(Solutions.binarySearchArrayIter(arr1, 0, 6, 90) == 6);
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

    // Polynomial
    @Test
    public void testMultPolyNaiive() {
        int[] A = new int[] {3, 2, 5};
        int[] B = new int[] {5, 1, 2};
        int[] product = new int[] {15, 13, 33, 9, 10};

        int[] ans = Solutions.multPolyNaiive(A, B, A.length);
        for (int i = 0; i < product.length; i++) {
            assertTrue(product[i] == ans[i]);
        }
    }

    // Majority Element
    @Test
    public void testMajorityElementNaiive() {
        int[] a = new int[] {2, 3, 9, 2, 2};
        assertTrue(MajorityElement.getMajorityElementNaiive(a, 0, a.length) == 2);
        int[] b = new int[] {1, 4, 4, 21, 4, 0, 4, 4};
        assertTrue(MajorityElement.getMajorityElementNaiive(b, 0, b.length) == 4);
        int[] c = new int[] {1, 2, 3, 5, 4, 9, 0};
        assertTrue(MajorityElement.getMajorityElementNaiive(c, 0, c.length) == -1);
        int[] d= new int[] {1, 9, 9, 21, 9, 9, 1, 1};
        assertTrue(MajorityElement.getMajorityElementNaiive(d, 0, d.length) == -1);
    }

    @Test
    public void testMajorityElement() {
        int[] a = new int[] {2, 3, 9, 2, 2};
        assertTrue(MajorityElement.getMajorityElement(a, 0, a.length) == 2);
        int[] b = new int[] {1, 4, 4, 21, 4, 0, 4, 4};
        assertTrue(MajorityElement.getMajorityElement(b, 0, b.length) == 4);
        int[] c = new int[] {1, 2, 3, 5, 4, 9, 0};
        assertTrue(MajorityElement.getMajorityElement(c, 0, c.length) == -1);
        int[] d= new int[] {1, 9, 9, 21, 9, 9, 1, 1};
        assertTrue(MajorityElement.getMajorityElement(d, 0, d.length) == -1);
    }

//    @Test
//    public void stressTest() {
//        Random rand = new Random();
//        int size = 10;
//        int bound = 5;
//        
//        while (true) {
//            int[] randArr = new int[size];
//            for (int i = 0; i < randArr.length; i++) {
//                randArr[i] = rand.nextInt(bound);
//            }
//            int naiive = MajorityElement.getMajorityElementNaiive(randArr, 0, randArr.length);
//            int fast = MajorityElement.getMajorityElement(randArr, 0, randArr.length);
//            System.out.println("Naiive: " + naiive);
//            System.out.println("Fast: " + fast);
//            if (naiive != fast) {
//                printArray(randArr);
//                System.out.println("Naiive: " + naiive);
//                System.out.println("Fast: " + fast);
//            }
//        } 
//    }
//
//    private void printArray(int[] randArr) {
//        for (int i : randArr) {
//            System.out.print(i + ", ");
//        }
//    }
    
    // Sorting Algorithms
    
    // 1 - Selection Sort
    @Test
    public void testSelectionSort() {
        int[] a = SortingAlgorithms.selectionSort(new int[] {10, 32, 2, 1, 0, 44, 22, 5});
        int[] ans = new int[] {0, 1, 2, 5, 10, 22, 32, 44};
        for (int i = 0; i < a.length; i++) {
            assertTrue(a[i] == ans[i]);
        }
    }
    
    // 2 - Merge Sort
    @Test
    public void testMergeSort() {
        int[] a = SortingAlgorithms.mergeSort(new int[] {10, 32, 2, 1, 0, 44, 22, 5}, 0, 7);
        int[] ans = new int[] {0, 1, 2, 5, 10, 22, 32, 44};
        for (int i = 0; i < a.length; i++) {
            assertTrue(a[i] == ans[i]);
        }
    }
    
    @Test
    public void testMerge() {
        int[] a = SortingAlgorithms.merge(new int[] {2, 3, 5, 7}, new int[] {1, 6, 7, 13});
        int[] ansa = new int[] {1, 2, 3, 5, 6, 7, 7, 13};
        for (int i = 0; i < a.length; i++) {
            assertTrue(a[i] == ansa[i]);
        }
        
        int[] b = SortingAlgorithms.merge(new int[] {0, 2, 3, 5, 7}, new int[] {1, 6, 7, 13});
        int[] ansb = new int[] {0, 1, 2, 3, 5, 6, 7, 7, 13};
        for (int i = 0; i < b.length; i++) {
            assertTrue(b[i] == ansb[i]);
        }
        
        int[] c = SortingAlgorithms.merge(new int[] {0, 2, 3, 5, 15}, new int[] {1, 6, 7, 13, 15, 17});
        int[] ansc = new int[] {0, 1, 2, 3, 5, 6, 7, 13, 15, 15, 17};
        for (int i = 0; i < c.length; i++) {
            assertTrue(c[i] == ansc[i]);
        }
        
        int[] d = SortingAlgorithms.merge(new int[] {2}, new int[] {1});
        int[] ansd = new int[] {1, 2};
        for (int i = 0; i < d.length; i++) {
            assertTrue(d[i] == ansd[i]);
        }
        
        SortingAlgorithms.merge(new int[] {1, 2, 3, 0, 0, 0}, 3, new int[] {2, 5, 6}, 3);
    }
    
    // 3 - Count Sort
    @Test
    public void testCountSort() {
        int[] a = SortingAlgorithms.countSort(new int[] {3, 4, 1, 2, 4, 6, 6, 7, 5, 7}, 7);
        int[] ans = new int[] {1, 2, 3, 4, 4, 5, 6, 6, 7, 7};
        for (int i = 0; i < a.length; i++) {
            assertTrue(a[i] == ans[i]);
        }
        int[] b = SortingAlgorithms.countSort(new int[] {1}, 1);
        assertTrue(b[0] == 1);
    }
    
    @Test
    public void testCountSortCopy() {
        int[] a = SortingAlgorithms.countSortCopy(new int[] {3, 4, 1, 2, 4, 6, 6, 7, 5, 7}, 7);
        int[] ans = new int[] {1, 2, 3, 4, 4, 5, 6, 6, 7, 7};
        for (int i = 0; i < a.length; i++) {
            assertTrue(a[i] == ans[i]);
        }
        int[] b = SortingAlgorithms.countSortCopy(new int[] {1}, 1);
        assertTrue(b[0] == 1);
    }
    
    
    @Test
    public void testQuickSortTry() {
        int[] a = SortingAlgorithms.quickSortTry(new int[] {10, 32, 2, 1, 0, 44, 22, 5});
        int[] ansa = new int[] {0, 1, 2, 5, 10, 22, 32, 44};
        for (int i = 0; i < a.length; i++) {
            assertTrue(a[i] == ansa[i]);
        }
        
        int[] b = SortingAlgorithms.quickSortTry(new int[] {32, 2});
        int[] ansb = new int[] {2, 32};
        for (int i = 0; i < b.length; i++) {
            assertTrue(b[i] == ansb[i]);
        }
        
        int[] c = SortingAlgorithms.quickSortTry(new int[] {32});
        int[] ansc = new int[] {32};
        for (int i = 0; i < c.length; i++) {
            assertTrue(c[i] == ansc[i]);
        }
    }
    
    @Test
    public void testQuickSort() {
        int[] a = new int[] {10, 32, 2, 1, 0, 44, 22, 5};
        SortingAlgorithms.quickSort(a, 0, a.length-1);
        int[] ansa = new int[] {0, 1, 2, 5, 10, 22, 32, 44};
        for (int i = 0; i < a.length; i++) {
            assertTrue(a[i] == ansa[i]);
        }
        
        int[] b = new int[] {32, 2};
        SortingAlgorithms.quickSort(b, 0, b.length-1);
        int[] ansb = new int[] {2, 32};
        for (int i = 0; i < b.length; i++) {
            assertTrue(b[i] == ansb[i]);
        }
        
        int[] c = new int[] {32};
        SortingAlgorithms.quickSort(c, 0, c.length-1);
        int[] ansc = new int[] {32};
        for (int i = 0; i < c.length; i++) {
            assertTrue(c[i] == ansc[i]);
        }
        
        int[] d = new int[] {2, 1, 2, 1, 2, 2, 22, 5};
        SortingAlgorithms.quickSort(d, 0, d.length-1);
        int[] ansd = new int[] {1, 1, 2, 2, 2, 2, 5, 22};
        for (int i = 0; i < d.length; i++) {
            assertTrue(d[i] == ansd[i]);
        }
    }
    
    @Test
    public void testRandomizedQuickSort() {
        int[] a = new int[] {10, 32, 2, 2, 1, 0, 44, 22, 5};
        SortingAlgorithms.randomizedQuickSort(a, 0, a.length-1);
        int[] ansa = new int[] {0, 1, 2, 2, 5, 10, 22, 32, 44};
        for (int i = 0; i < a.length; i++) {
            assertTrue(a[i] == ansa[i]);
        }
        
        int[] b = new int[] {32, 2};
        SortingAlgorithms.randomizedQuickSort(b, 0, b.length-1);
        int[] ansb = new int[] {2, 32};
        for (int i = 0; i < b.length; i++) {
            assertTrue(b[i] == ansb[i]);
        }
        
        int[] c = new int[] {32};
        SortingAlgorithms.randomizedQuickSort(c, 0, c.length-1);
        int[] ansc = new int[] {32};
        for (int i = 0; i < c.length; i++) {
            assertTrue(c[i] == ansc[i]);
        } 
    }
    
    @Test
    public void testTailRandomizedQuickSort() {
        int[] a = new int[] {10, 32, 2, 2, 1, 0, 44, 22, 5};
        SortingAlgorithms.tailRandomizedQuickSort(a, 0, a.length-1);
        int[] ansa = new int[] {0, 1, 2, 2, 5, 10, 22, 32, 44};
        for (int i = 0; i < a.length; i++) {
            assertTrue(a[i] == ansa[i]);
        }
        
        int[] b = new int[] {32, 2};
        SortingAlgorithms.tailRandomizedQuickSort(b, 0, b.length-1);
        int[] ansb = new int[] {2, 32};
        for (int i = 0; i < b.length; i++) {
            assertTrue(b[i] == ansb[i]);
        }
        
        int[] c = new int[] {32};
        SortingAlgorithms.tailRandomizedQuickSort(c, 0, c.length-1);
        int[] ansc = new int[] {32};
        for (int i = 0; i < c.length; i++) {
            assertTrue(c[i] == ansc[i]);
        }
    }
    
    @Test
    public void testParitition() {
        int[] a = new int[] {4, 3, 2, 4, 4, 1, 44, 22, 5};
        int m = SortingAlgorithms.partition(a, 0, a.length - 1);
        
        int[] b = new int[] {4, 3, 2, 1, 4, 1, 4, 22, 4, 6};
        int n = SortingAlgorithms.partition(b, 0, b.length - 1);
        
        int[] c = new int[] {4, 3, 2, 4, 4, 1, 44, 22, 5};
        int[] m3 = SortingAlgorithms.partition3(c, 0, c.length - 1);
        
        int[] d = new int[] {4, 3, 2, 1, 4, 1, 4, 22, 4, 6};
        int[] n3 = SortingAlgorithms.partition3(d, 0, d.length - 1);
    }
    
    @Test
    public void testRandomizedQuickSort3() {
        int[] a = new int[] {10, 32, 2, 2, 1, 0, 44, 22, 5};
        SortingAlgorithms.randomizedQuickSort3(a, 0, a.length-1);
        int[] ansa = new int[] {0, 1, 2, 2, 5, 10, 22, 32, 44};
        for (int i = 0; i < a.length; i++) {
            assertTrue(a[i] == ansa[i]);
        }
        
        int[] b = new int[] {32, 2};
        SortingAlgorithms.randomizedQuickSort3(b, 0, b.length-1);
        int[] ansb = new int[] {2, 32};
        for (int i = 0; i < b.length; i++) {
            assertTrue(b[i] == ansb[i]);
        }
        
        int[] c = new int[] {32};
        SortingAlgorithms.randomizedQuickSort3(c, 0, c.length-1);
        int[] ansc = new int[] {32};
        for (int i = 0; i < c.length; i++) {
            assertTrue(c[i] == ansc[i]);
        } 
    }
    
    @Test
    public void testQuickSort3() {
        int[] a = new int[] {10, 32, 2, 1, 0, 44, 22, 5};
        SortingAlgorithms.quickSort3(a, 0, a.length-1);
        int[] ansa = new int[] {0, 1, 2, 5, 10, 22, 32, 44};
        for (int i = 0; i < a.length; i++) {
            assertTrue(a[i] == ansa[i]);
        }
        
        int[] b = new int[] {32, 2};
        SortingAlgorithms.quickSort3(b, 0, b.length-1);
        int[] ansb = new int[] {2, 32};
        for (int i = 0; i < b.length; i++) {
            assertTrue(b[i] == ansb[i]);
        }
        
        int[] c = new int[] {32};
        SortingAlgorithms.quickSort3(c, 0, c.length-1);
        int[] ansc = new int[] {32};
        for (int i = 0; i < c.length; i++) {
            assertTrue(c[i] == ansc[i]);
        }
        
        int[] d = new int[] {2, 1, 2, 1, 2, 2, 22, 5};
        SortingAlgorithms.quickSort3(d, 0, d.length-1);
        int[] ansd = new int[] {1, 1, 2, 2, 2, 2, 5, 22};
        for (int i = 0; i < d.length; i++) {
            assertTrue(d[i] == ansd[i]);
        }
    }
    
    @Test
    public void stressTest() {
        int[] arr1 = new int[100];
        int[] arr2 = new int[100];
        
        Random rand = new Random();
        
        while (true) {
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = rand.nextInt();
                arr2[i] = arr1[i];   
            }
            SortingAlgorithms.randomizedQuickSort(arr1, 0, arr1.length-1);
            SortingAlgorithms.randomizedQuickSort3(arr2, 0, arr2.length-1);

            for (int i = 0; i < arr1.length; i++) {
                System.out.print(arr1[i] + " ");
                System.out.println();
                System.out.print(arr2[i] + " ");
                if (arr1[i] == arr2[i]) {
                    break;
                }
            }
        }
    }
}
