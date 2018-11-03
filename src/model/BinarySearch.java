package model;
import java.io.*;
import java.util.*;

public class BinarySearch {

    public static int binarySearchArray(int[] array, int low, int high, int key) {
        if (low > high) return - 1;
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
    
    public static int binarySearch(int[] a, int x) {
        int left = 0, right = a.length - 1;
        return binarySearchArray(a, left, right, x);
    }

    public static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(binarySearch(a, b[i]) + " ");
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

