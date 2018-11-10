package model;
import java.util.*;
import java.io.*;
//Task. The goal in this code problem is to check whether an input sequence
//contains a majority element. Input Format. The first line contains an 
//integer 𝑛, the next one contains a sequence of 𝑛 non-negative
//integers 𝑎0, 𝑎1, . . . , 𝑎𝑛−1.
//Constraints. 1 ≤ 𝑛 ≤ 10^5;0≤𝑎_𝑖 ≤10^9 for all 0 ≤ 𝑖 < 𝑛.
//Output Format. Output 1 if the sequence contains an element that appears 
//strictly more than 𝑛/2 times, and 0 otherwise.

public class MajorityElement {
    /**
     * Return the majority element in the input array a, -1 if there is none
     * @param a
     * @param left, left-bound index
     * @param right, right-bound index
     * @return see function description
     */
    public static int getMajorityElement(int[] a, int left, int right) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = left; i < right; i++) {
            if (!countMap.containsKey(a[i]))
                countMap.put(a[i], 1);
            else {
               int count = countMap.get(a[i]);
               count++;
               countMap.put(a[i], count);
            }
        }
        for (int key: countMap.keySet()) {
            int count =countMap.get(key);
            if (count > (double) (right - left)/2) {
                return key;
            }
        }
        return -1;
    }
    
    public static int getMajorityElementNaiive2(int[] a, int left, int right) {
        int n = right - left;
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        //write your code here
        for (int i = left; i < right; i++) {
            int currentElement = a[i];
            int count = countElement(a, left, right-1, currentElement, 0);
            if (count > (double) n/2) {
                return currentElement;
            }
        }
        return -1;
    }

    private static int countElement(int[] a, int left, int right, int currentElement, int count) {
        if (left == right) {
            if (a[left] == currentElement) {
                count++;
                return count;
            } else {
                return count;
            }
        }
        else {
            int mid = (int)Math.floor(left + (right-left)/2);
            return countElement(a, left, mid, currentElement, count) + countElement(a, mid+1, right, currentElement, count);
        }
    }

    public static int getMajorityElementNaiive(int[] a, int left, int right) {
        int n = right - left;
        if (n == 0) 
            return -1;
        if (left + 1 == right)
            return a[left];
        for (int i = left; i < right; i++) {
            int currentElement = a[i];
            int count = 0;
            for (int j = left; j < right; j++) {
                if (currentElement == a[j])
                    count++;
            }
            if (count > (double)n/2)
                return currentElement;
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
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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