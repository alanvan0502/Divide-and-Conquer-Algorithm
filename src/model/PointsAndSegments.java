package model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PointsAndSegments {

    static class Element {
        int value;
        String type;
        int pos;
        int count;

        Element(int value, String type, int pos){
            this.value = value;
            this.type = type;
            this.pos = pos;
            count = 0;
        }
    }

    public static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        Element[] elements = new Element[starts.length + ends.length + points.length];
        
        int s = 0;
        for (int i = 0; i < starts.length; i++) {
            elements[i] = new Element(starts[s], "l", s);
            s++;
        }
        
        int e = 0;
        for (int i = starts.length; i < starts.length + ends.length; i++) {
            elements[i] = new Element(ends[e], "r", e);
            e++;
        }
        
        int p = 0;
        for (int i = starts.length + ends.length; i < elements.length; i++) {
            elements[i] = new Element(points[p], "p", p);
            p++;
        }
        
        Arrays.sort(elements, new Comparator<Element>() {
            @Override
            public int compare(Element e1, Element e2) {
                if (e1.value != e2.value)
                    return e1.value - e2.value;
                else
                    return e1.type.compareTo(e2.type);
            }     
        });

        int numLeft = 0;
        int numRight = 0;

        Element[] resultElements = new Element[points.length];
        int resultIndex = 0;
        
        for (int i = 0; i < elements.length; i++) {

            if (elements[i].type.equals("l")) {
                numLeft++;
            }
            
            if (elements[i].type.equals("p")) {
                elements[i].count = numLeft - numRight;
                resultElements[resultIndex] = elements[i];
                resultIndex++;
            }
            
            if (elements[i].type.equals("r")) {
                numRight++;
            }
        }
        
        int[] result = new int[points.length];
        
        for (Element element: resultElements) {
            result[element.pos] = element.count;
        }
        
        return result;
    }

    public static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

