package model;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Closest {

    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
        }
    }

    static double distance(Point p1, Point p2) {
        return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y));
    }

    public static double minimalDistance(int[] x, int[] y) {

        Point[] points = new Point[x.length];
        for (int i = 0; i < x.length; i++) {
            points[i] = new Point(x[i], y[i]);
        }
        Arrays.sort(points, new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2) {
                return Long.signum(p1.x - p2.x);
            }
        });
        Point pMinX = points[0];
        Point pMaxX = points[points.length-1];
        return minimalDistanceHelp(points, pMinX.x, pMaxX.x);
    }

    private static double minimalDistanceHelp(Point[] points, double minX, double maxX) {

        int[] range = getIndexInRange(points, minX, maxX);
        int left = range[0];
        int right = range[1];
        if (right - left < 1)
            return Double.POSITIVE_INFINITY;
        else if (right - left == 1)
            return distance(points[right], points[left]);

        double midX = minX + (maxX - minX)/2;
        double dl = minimalDistanceHelp(points, minX, midX);
        double dr = minimalDistanceHelp(points, midX, maxX);
        double d = Math.min(dl, dr);
        
        List<Point> focus = new ArrayList<>();
        for (Point p: points) {
            if (Math.abs(p.x - midX) <= d) {
                focus.add(p);
            }
        }

        focus.sort(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return Long.signum(p1.y - p2.y);
            }      
        });

        double dprime = Double.POSITIVE_INFINITY;

        for (int i = 0; i < Math.min(focus.size(), 7); i++) {
            double dist = minDistance(focus, i, focus.size()-1);
            if (dist < dprime)
                dprime = dist;
        } 

        return Math.min(dprime, d);
    }

    private static int[] getIndexInRange(Point[] points, double minX, double maxX) {
        int minIndex = 0;
        int maxIndex = points.length - 1;
        for (int i = 0; i < points.length; i++) {
            if (points[i].x >= minX) {
                minIndex = i;
                break;
            }
        }
        for (int j = points.length - 1; j >= 0; j--) {
            if (points[j].x <= maxX) {
                maxIndex = j;
                break;
            }
        }
        return new int[] {minIndex, maxIndex};
    }
    
    public static double minimalDistanceNaive(int[] x, int[] y) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < x.length; i++) {
            points.add(new Point(x[i], y[i]));
        }
        return minDistance(points, 0, points.size() - 1);
    }
    
    private static double minDistance(List<Point> focus, int left, int right) {
        double minDist = Double.POSITIVE_INFINITY;
        for (int i = left; i <= right; i++) {
            for (int j = left; j <= right; j++) {
                if (i != j) {
                    double dist = distance(focus.get(i), focus.get(j));
                    if (dist < minDist)
                        minDist = dist;
                }
            }
        }
        return minDist;
    }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        System.out.println(minimalDistance(x, y));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
