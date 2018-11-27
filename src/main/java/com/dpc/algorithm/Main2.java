package com.dpc.algorithm;

import java.util.Scanner;

public class Main2 {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",");
        int x = Integer.valueOf(input[0]);
        int y = Integer.valueOf(input[1]);

        String[] ps = sc.nextLine().split(",");
        Point[] points = new Point[ps.length / 2];
        int j = 0;
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        for (int i = 0; i < ps.length - 1; i += 2) {
            int x0 = Integer.valueOf(ps[i]);
            int y0 = Integer.valueOf(ps[i + 1]);
            minX = Math.min(minX, x0);
            minY = Math.min(minY, y0);
            maxX = Math.max(maxX, x0);
            maxY = Math.max(maxY, y0);
            points[j++] = new Point(x0, y0);
        }
//        if (contains(x, y, points)) {
//            System.out.println("yes,0");
//        }

        if (x > maxX || x < minX || y > maxY || y < minY)
            System.out.println("yes,0");

    }

    private static boolean contains(double x0, double y0, Point[] points) {
        int crossings = 0;
        for (int i = 0; i < points.length - 1; i++) {
            double slope = (points[i + 1].y - points[i].y) / (points[i + 1].x - points[i].x);
            boolean cond1 = (points[i].x < x0) && (points[i + 1].x > x0);
            boolean cond2 = (points[i + 1].x < x0) && (points[i].x > x0);
            boolean above = (y0 < slope * (x0 - points[i].x) + points[i].y);
            if ((cond1 || cond2) && above) {
                crossings++;
            }
        }
        return (crossings % 2 != 0);
    }
}
